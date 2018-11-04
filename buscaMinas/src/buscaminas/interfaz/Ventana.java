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
package buscaminas.interfaz;

import buscaminas.logica.Control;
import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author likendero
 */
public class Ventana extends JFrame {
    private PanelMinas panelMinas;
    private PanelMenu panelMenu;
    private Control control;
    /**
     * metodo contructor de la ventana
     * esta en esta ventana habra dos paneles
     * el panel izquierdo contendra el el panel con los botones
     */
    public Ventana(){
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100,600, 600);
        setResizable(false);
        init();
    }
    /**
     * metodo que incicaliza todos los elementos
     * de la ventana
     */
    private void init(){
        // instanciacion del panel minas
        panelMinas = new PanelMinas();
        // instanciacion del panel menu
        panelMenu = new PanelMenu();
        // control
        control = new Control(panelMinas, panelMenu);
        // add del panel
        add(panelMinas,BorderLayout.CENTER);
        add(panelMenu,BorderLayout.LINE_END);
    }
}
