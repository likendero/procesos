/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *  metodo que crea un panel con botones
 * @author likendero
 */
public class PanelIzquierdo extends JPanel {
    private JButton btnQuitarA, btnQuitarS, btnSalir;
    /**
     * metodo cosntructor del panel
     */
    public PanelIzquierdo(){
        super();
        init();
    }
    /**
     * metodo que inicializa los elementos del 
     * panel
     */
    public void init(){
        // definicion de los botones
        btnQuitarA =  new JButton("quitar A");
        btnQuitarS = new JButton("quitar S");
        btnSalir =  new JButton("salir");
        // cambio de aspecto para los botones
        // boton A
        // cambio de color
        btnQuitarA.setBackground(Color.BLUE);
        // cambio de las dimensiones
        btnQuitarA.setSize(new Dimension(20, 10));
        // boton S
        // cambio de color
        btnQuitarS.setBackground(Color.GREEN);
        // cambio de dimensiones
        btnQuitarS.setSize(new Dimension(20, 10));
        
        // boton salir
        btnSalir.setBackground(Color.PINK);
        btnSalir.setSize(new Dimension(20, 10));
        // funcionalidad salir
        btnSalir.addActionListener(e->salir());
        // annadir los botones
        
        add(btnQuitarA);
        add(btnQuitarS);
        add(btnSalir);
    }
    /**
     * metodo que termina el programa
     */
    private void salir(){
        System.exit(0);
    }
    public JButton getBtnA(){
        return btnQuitarA;
    }
    
    public JButton getBtnS(){
        return btnQuitarS;
    }
    
    
}
