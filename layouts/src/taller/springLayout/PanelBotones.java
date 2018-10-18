/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller.springLayout;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;

/**
 *  clase que crea un panel con botones, este 
 * utiliza un Spring layout
 * @author Javier Gonzalez Rives
 */
public class PanelBotones extends JPanel {
    private JButton bt1,bt2,bt3,bt4;
    private SpringLayout ly;
    private Container cont;
    /**
     * metodo constructor del panel con botones
     */
    public PanelBotones(Container cont){
        super();
        this.cont = cont;
        init();
    }
    /**
     * metodo que inicializa los elementos del panel
     * tambien cambia el layout
     */
    private void init(){
        // inicializacion de los botones
        bt1 = new JButton("boton1");
        bt2 = new JButton("boton2");
        bt3 = new JButton("boton3");
        bt4 = new JButton("boton4");
        
        // creacion del layout
        ly = new SpringLayout();
        setLayout(ly);
        // adds
        add(bt1);
        add(bt2);
        add(bt3);
        //add(bt4);
        
        // restricciones
        springs();
    }
    /**
     * metodo que define la posicion de los 
     * elementos
     */
    public void springs(){
        // enganchado a 10 de la parte superior de la ventana
        ly.putConstraint(SpringLayout.NORTH, bt1, 10, SpringLayout.NORTH, cont);
        // enganchado a 10 de la parte izquierda
        ly.putConstraint(SpringLayout.WEST, bt1, 10, SpringLayout.WEST, cont);
        
        // prueba con Springs
        Spring muelle = Spring.constant(50, 80, 100);
        ly.putConstraint(SpringLayout.WEST, bt2, muelle, SpringLayout.EAST, bt1);
        ly.putConstraint(SpringLayout.NORTH, bt2, 10, SpringLayout.NORTH, cont);
        //ly.putConstraint(SpringLayout.EAST, bt2, muelle, SpringLayout.WEST, bt3);
        
        // bt3
        ly.putConstraint(SpringLayout.NORTH, bt3, 10, SpringLayout.NORTH, cont);
        ly.putConstraint(SpringLayout.EAST, bt3, muelle, SpringLayout.EAST, cont);
    }
}
