/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conprodlistas1;


import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paco
 */
public class MiLista {
    public ArrayList<String> miLista = new ArrayList<>();
    
    public synchronized void ponerDato(String c){
        if(miLista.size()==10){
            System.out.println("Lista LLENA, esperando!!!!!");
            try {
                wait();
            } catch(InterruptedException ex){}
        }
        miLista.add(c);
        notify();
    }
    public synchronized String quitar() {
        if(miLista.size()==0){
            //System.out.println("------>Esperando que haya una palabra!!!!");
            try {
                wait();
            } catch (InterruptedException ex) {}
        }
        String cadena=miLista.get(0);
        miLista.remove(0);
        notify();
        return cadena;
    }
}
