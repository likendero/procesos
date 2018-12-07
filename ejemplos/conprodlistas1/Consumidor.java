/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conprodlistas1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paco
 */
public class Consumidor extends Thread {
    MiLista ml;
    public Consumidor(MiLista m){
        ml=m;
    }
    @Override
    public void run(){
        while(true){
            if(ml.miLista.size()==0){
                System.out.println("Lista Vacia, Esperando!!");
               
            }
            else{
                System.out.println("Consumiendo la palabra: " + ml.quitar() + ", quedan: " + ml.miLista.size() + ", elementos");
                 try {
                    sleep(1500);
                } catch (InterruptedException ex) {}
            }
        }
    }
    //--------------------------------------------------------------------------
}
