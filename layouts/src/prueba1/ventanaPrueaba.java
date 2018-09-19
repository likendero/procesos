/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author likendero
 */
public class ventanaPrueaba extends JFrame {
    
    // elementos
    private JButton btnPageStart,btnPageEnd,btnLineStart,btnLineEnd,btnCenter;
    
    
    /**
     * metodo constructor
     * @param titulo 
     */
    public ventanaPrueaba(String titulo){
        super(titulo);
        initFrame();
    }
    /**
     * metodo que incializa los elementos de la ventana
     */
    public void initFrame(){
        // inicializacion de los botones
        // botones arriba y abajo
        btnPageEnd = new  JButton("boton de abajo");
        btnPageStart =  new JButton("boton de arriba");
        // botones de los lados
        btnLineStart = new JButton("boton de la izquierda");
        btnLineEnd = new JButton("boton de la derecha");
        // boton del centro
        btnCenter = new JButton("boton del centro");
        
        // annadir elementos a la ventana
        // creo la variable continente que contiene el "container" de la ventana
        Container continente = this.getContentPane();
        // defino el tamanno de la ventana (400*400)
        continente.setSize(new Dimension(400,400));
        // annado los elementos
        
        // page_start y page_end
        continente.add(btnPageStart,BorderLayout.PAGE_START);
        continente.add(btnPageEnd,BorderLayout.PAGE_END);
        
        // Line_end y line_start
        continente.add(btnLineStart,BorderLayout.LINE_START);
        continente.add(btnLineEnd,BorderLayout.LINE_END);
        
        // Center
        continente.add(btnCenter,BorderLayout.CENTER);
        
        // annado el action listener a los botones
        btnPageEnd.addActionListener(e->abajo());
        btnPageStart.addActionListener(e->arriba());
        btnLineStart.addActionListener(e->izquierda());
        btnLineEnd.addActionListener(e->derecha());
        btnCenter.addActionListener(e->centro());
    }
    /**
     * metodo que funciona al pulsar el boton superior
     */
    public void arriba(){
        JOptionPane.showMessageDialog(this, "este es el boton de arriba");
    }
    /**
     * metodo que funciona al pulsar el boton inferior
     */
    public void abajo(){
        JOptionPane.showMessageDialog(this, "este es el boton de abajo");
    }
    /**
     * metodo que funciona al pulsar el boton derecho
     */
    public void derecha(){
        JOptionPane.showMessageDialog(this, "este es el boton de la derecha");
    }
    /**
     * metodo que funciona al pulsar el boton izquierdo
     */
    public void izquierda(){
        JOptionPane.showMessageDialog(this, "este es el boton de la izquierda");
    }
    
    public void centro(){
        JOptionPane.showMessageDialog(this, "este es el boton del centro");
    }
}
