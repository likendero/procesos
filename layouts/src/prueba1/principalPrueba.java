/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import sun.awt.resources.awt;

/**
 *
 * @author likendero
 */
public class principalPrueba {
    
    public static void mostrarVentana(){
        ventanaPrueaba ventanuco = new ventanaPrueaba("ventanucossss");
        // caso de cierre
        ventanuco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // hacer visible
        ventanuco.setVisible(true);
        ventanuco.pack();
    }
    
    /**
     * metodo principal 
     * @param args 
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run() {
                mostrarVentana();
            }
        
        
        });
    }
}
