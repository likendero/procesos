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
package carreranumeros;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author likendero
 */
public class Ventana extends JFrame implements Runnable{
    private PanelCuenta cuenta1,cuenta2;
    private JButton start;
    /**
     * metodo constructor
     */
    public Ventana(){
        super("carrera");
        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
    }
    /**
     * metodo que incicializa los elementos
     */
    public void init(){
        // instanciacion de los paneles
        cuenta1 = new PanelCuenta();
        cuenta2 = new PanelCuenta();
        JPanel panelAux = new JPanel();
        PanelBotones botones = new PanelBotones();
        // posicion de los paneles
        cuenta1.setAlignmentX(CENTER_ALIGNMENT);
        cuenta1.setAlignmentY(CENTER_ALIGNMENT);
        cuenta2.setAlignmentX(CENTER_ALIGNMENT);
        cuenta2.setAlignmentY(CENTER_ALIGNMENT);
        // annadir al panel auxiliar
        panelAux.add(cuenta1);
        panelAux.add(cuenta2);
        
        // captura del boton
        start = botones.getStart();
        // annadir accion start
        start.addActionListener(e->inicio());
       // adds
       add(panelAux,BorderLayout.CENTER);
       add(botones,BorderLayout.PAGE_END);
    }
    /**
     * metodo que inicia la accion del boton
     */
    public void inicio(){
        // creacion  del nuevo hilo
        Thread correr = new Thread(this);
        //desabilitar boton
        start.setEnabled(false);
        // inicio del hilo
        correr.start();
    }
    @Override
    public void run() {
        Thread cont1 = new Thread(cuenta1);
        Thread cont2 = new Thread(cuenta2);
        
        cont1.start();
        cont2.start();
        // control de los hilos
        while(cont1.isAlive() && cont2.isAlive()){}
        // control
        if(!cont1.isAlive() && !cont2.isAlive()){
            JOptionPane.showMessageDialog(this,"empate","resultado",JOptionPane.INFORMATION_MESSAGE);
            // caso ue halla ganado el panel 1
        }else if(!cont1.isAlive()){
            cuenta1.setControl(false);
            JOptionPane.showMessageDialog(this,"Gana el panel 1","resultado",JOptionPane.INFORMATION_MESSAGE);
            // caso que halla ganado el panel 2
        }else{
            cuenta2.setControl(false);
            JOptionPane.showMessageDialog(this,"Gana el panel 2","resultado",JOptionPane.INFORMATION_MESSAGE);
        }
        // se devuelve la funcionalidad a start
        start.setEnabled(true);
    }
    
    
}
