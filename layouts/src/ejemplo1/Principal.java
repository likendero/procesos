/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo1;

import static java.awt.EventQueue.invokeLater;
import javax.swing.JFrame;

/**
 *
 * @author likendero
 */
public class Principal {
    
    public static void mostrar(){
        Ventana ventana = new Ventana("ventanuco");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
        ventana.pack();
    }
    public static void main(String[] args) {
        invokeLater(new Runnable() {
            @Override
            public void run() {
                mostrar();
            }
        });
        
    }
}
