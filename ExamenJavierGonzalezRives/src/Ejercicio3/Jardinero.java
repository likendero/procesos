/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio3;

/**
 *
 * @author Javier Gonzalez Rives
 */
public class Jardinero implements Runnable {
    /**
     * constructor del jardinero
     */
    public Jardinero(){
        super();
    }

    @Override
    public void run() {
        // bucle infinito para el hilo
        while(true){
            Cuba.estaCubaRevolucionaria(this);
            System.out.println("el jardinero descansa");
            try{
                Thread.sleep(2000);
            }catch(InterruptedException in){}
            System.out.println("el jardinero despierta");
        }
    }
}
