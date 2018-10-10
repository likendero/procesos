/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejcardlayout;

import javax.swing.JFrame;
import static javax.swing.SwingUtilities.invokeLater;

/**
 *
 * @author paco
 */
public class EjCardLayout {

    /**
     * @param args the command line arguments
     * 
     */
    public static void mostrarTodo(){
        Ventana v = new Ventana();
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setTitle("CardLayout");
        v.setVisible(true);
    }
    public static void main(String[] args) {
        invokeLater(new Runnable(){
            @Override
            public void run(){
                mostrarTodo();
            }
        });
    }
    
}
