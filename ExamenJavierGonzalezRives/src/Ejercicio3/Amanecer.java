/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

/**
 * clase que inicia un nuevo dia de llenar y vaciar cubas
 * de agua con jardineros y empresas con una vida monotona con 
 * agua muy triste ):
 * @author Javier Gonzalez Rives
 */
public class Amanecer {
    /**
     * metdodo principal
     * @param args 
     */
    public static void main(String[] args) {
        // creo los inbtervinientes en la actividad
        Jardinero jardinero = new Jardinero();
        Llenado llenado = new Llenado();
        // crear los hilos
        Thread hiloJardinero = new Thread(jardinero);
        Thread hiloLlenado = new Thread(llenado);
        // inicio de la actividad diaria monotona
        System.out.println("inicio del dia");
        hiloJardinero.start();
        hiloLlenado.start();
    }
}
