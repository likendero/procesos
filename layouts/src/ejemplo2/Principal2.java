/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo2;

import static java.awt.EventQueue.invokeLater;
import javax.swing.JFrame;

/**
 *
 * @author likendero
 */
public class Principal2 {
    /**
     * metodo que inicia la ventana
     */
    public static void mostrar(){
        ventana2 ven = new ventana2();
        ven.setVisible(true);
        ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ven.setTitle("los tres reyes magos");
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
