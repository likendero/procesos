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
public class Llenado implements Runnable {
    /**
     * constructor para la empresa que llena
     */
    public Llenado(){
        super();
    }
    @Override
    public void run() {
        // bucle infinito para el hilo
        while(true){
            Cuba.estaCubaRevolucionaria(this);
            System.out.println("la empresa descanasa");
            try{
                Thread.sleep(1000);
            }catch(InterruptedException in){}
            System.out.println("la empresa despierta");
        }
    }
}
