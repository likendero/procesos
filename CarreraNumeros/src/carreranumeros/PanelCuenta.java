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

import java.awt.Color;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author likendero
 */
public class PanelCuenta extends JPanel implements Runnable{
    private JTextField cuenta;
    private boolean control;
    /**
     * constructor del panel sin paramentros
     * el tiempo y velocidad se genera de forma automatica
     */
    public PanelCuenta(){
        super();
        init();
    }
    /**
     * metodo que incializa los elementos
     */
    public void init(){
        // incializacion del JTextField
        cuenta = new JTextField();
        cuenta.setText("0");
        // cambio de colores, fuente y tamanno
        cuenta.setColumns(20);
        cuenta.setBackground(Color.BLACK);
        cuenta.setForeground(Color.YELLOW);
        cuenta.setFont(new Font("arial",Font.BOLD,23));
        // cambio de layout
        BoxLayout box = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(box);
        // cambio de alineacion de cuenta al centro centro
        cuenta.setAlignmentX(CENTER_ALIGNMENT);
        cuenta.setAlignmentY(CENTER_ALIGNMENT);
        // cambio de editable
        cuenta.setEditable(false);
        // adds
        add(cuenta);
    }

    @Override
    public void run() {
        NumberGenerator carrera = new NumberGenerator();
        int creciente = carrera.getNumInicial();
        control = true;
        // bucle de carrera
        while(creciente < 100 && control){
            espera(carrera.getVelocidad());
            cuenta.setText("" + creciente);
            creciente++;
        }
    }
    /**
     * metodo para realizar la pausa entre numero y numnero
     * @param espera 
     */
    public void espera(int espera){
        try{
            // espera
            Thread.sleep(espera);
        }catch(InterruptedException it){
            it.printStackTrace();
        }
    }
    /**
     * metodo que cambia el valor de control
     * @param control 
     */
    public void setControl(boolean control) {
        this.control = control;
    }
        
    
}
