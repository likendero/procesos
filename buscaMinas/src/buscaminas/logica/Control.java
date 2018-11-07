/*
 * Copyright (C) 2018 likendero
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package buscaminas.logica;

import buscaminas.interfaz.PanelMenu;
import buscaminas.interfaz.PanelMinas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author likendero
 */
public class Control implements ActionListener, Runnable {
    
    private JButton btStart;
    private JButton btPausaContinuar;
    private Relog relog;
    private Semaforo semaforoRelog;
    private Semaforo semaforoJuego;
    private ControlJuego controlJuego;
    
    /**
     * metodo constructor del control de la aplicacion
     */
    public Control(PanelMinas minas, PanelMenu menu){
        super();
        /// init
        semaforoRelog = new Semaforo();
        semaforoJuego = new Semaforo();
       
        
        /// elementos del menu
        this.btPausaContinuar = menu.getBtPausaContinuar();
        this.btStart = menu.getBtStart();
        relog = new Relog(menu.getTxRelog(), semaforoRelog);
        ///  control juego
        controlJuego = new ControlJuego(minas.getBtnMinas(), menu.getTxMarcador(), semaforoJuego);
        // acciones
        acciones();
    }
    /**
     * metodo que annade los acction listener a 
     * los elementos.
     */
    private void acciones(){
        // acciones botones
        btPausaContinuar.addActionListener(this);
        btStart.addActionListener(this);
        
        // estado inicial 
        btPausaContinuar.setEnabled(false);
        
    }

    @Override
    public void run() {
        while (semaforoJuego.isActivo()) {            
            System.out.println("");
        }
        semaforoRelog.setActivo(false);
        // caso si ganas
        if(
                controlJuego.getContMinas()
                ==
                controlJuego.getNUMEROMINAS()
                ){
            btPausaContinuar.setEnabled(false);
            btStart.setEnabled(true);
            controlJuego.reiniciar();
            controlJuego.setFuncionando(false);
            // mensaje si ganas
            JOptionPane.showMessageDialog(null, "HAS GANADO!!!!","fin del juego",JOptionPane.INFORMATION_MESSAGE);
            // si pierdes
        }else{
            btPausaContinuar.setEnabled(false);
            btStart.setEnabled(true);
            controlJuego.reiniciar();
            controlJuego.setFuncionando(false);
            // mensaje si ganas
            JOptionPane.showMessageDialog(null, "HAS PERDIDO D:","fin del juego",JOptionPane.ERROR_MESSAGE);
            
        }
        
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // caso de boton start, inicar partida
        if(btStart == e.getSource()){
            // activacion el juego
            controlJuego.setFuncionando(true);
            // creacion del hilo para el juego
            Thread juego = new Thread(this);
            // creacion del hilo para el relog
            if(!relog.isAlive()){
                relog.start();
            }
            else{
                relog.reiniciar();
                semaforoRelog.setActivo(true);
            }
            juego.start();
            // desactivar el boton
            btStart.setEnabled(false);
            btPausaContinuar.setEnabled(true);
        }
        if(btPausaContinuar == e.getSource()){
            // caso que el boton sea para pausar
            if(btPausaContinuar.getText().equals("pausa")){
                semaforoRelog.setActivo(false);
                btPausaContinuar.setText("continuar");
                // para que no se pueda seguir pulsando 
                controlJuego.setFuncionando(false);
            // caso que el boton sea continuar
            }else{
            btPausaContinuar.setText("pausa");
            semaforoRelog.setActivo(true);
            controlJuego.setFuncionando(true);
            }
        }
    }
    
}
