/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaConBotones;

import java.awt.EventQueue;

/**
 *  clase principal que crea una ventana con multiples botones que hacen 
 *  acciones como quitar las A y S de un texto
 * @author likendero
 */
public class Principal {
    /**
     * metodo que crea la instancia ventana del programa
     */
    private static void mostrar(){
        Ventana ven = new Ventana("borrar cosicas");
        ven.setVisible(true);
    }
    /**
     * metodo principal
     * @param args 
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                mostrar();
            }
        });
    }
}
