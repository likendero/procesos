/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reloj;

import static java.awt.EventQueue.invokeLater;
import javax.swing.JFrame;

/**
 *
 * @author paco
 */
public class Principal {
    public static void mostrar(){
        Ventana mv = new Ventana();
        mv.setTitle("Cronometro");
        mv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mv.setVisible(true);
    }
    public static void main(String [] args){
        invokeLater(new Runnable(){
            @Override
            public void run(){
                mostrar();
            }
        });
    }
}
