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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * esta clase crea un panel con los botones del 
 * programa
 * 1- start para iniciar un juego
 * 2- salir para salir del juego
 * @author likendero
 */
public class PanelBotones extends JPanel {
    private JButton salir,start;
    /**
     * metodo constructor del panel que 
     * contendra los botones
     */
    public PanelBotones(){
        super();
        init();
    }
    /**
     * metodo que incializa los elemntos del panel
     */
    public void init(){
        // instanciacion de los botones
        salir = new JButton("salir");
        start = new JButton("start");
        // cambio de colores
        // fondo
        salir.setBackground(Color.BLACK);
        start.setBackground(Color.BLACK);
        // letra
        salir.setForeground(Color.YELLOW);
        start.setForeground(Color.MAGENTA);
        // add funcion salir
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        // adds
        add(start);
        add(salir);
    }
    /**
     * metodo que retorna el boton start
     * @return 
     */
    public JButton getStart(){
        return this.start;
    }
}
