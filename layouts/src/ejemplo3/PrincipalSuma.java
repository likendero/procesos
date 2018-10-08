/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo3;

import java.awt.EventQueue;
import javax.swing.JFrame;

/**
 *
 * @author likendero
 */
public class PrincipalSuma {
    public static void mostrar(){
        VentanaSuma ven = new VentanaSuma();
        ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ven.setVisible(true);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                mostrar();
            }
        });
    }
}
