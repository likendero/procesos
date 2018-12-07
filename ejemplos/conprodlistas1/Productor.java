/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conprodlistas1;



/**
 *
 * @author paco
 */
public class Productor extends Thread {
    MiLista ml;
    public Productor(MiLista ml){
        this.ml=ml;
    }
    
    @Override
    public void run(){
        while(true){
            String palabra=creaPalabra();
            ml.ponerDato(palabra);
            System.out.println("Poniendo la palabra: " + palabra + ", hay un total de: " +ml.miLista.size());
            try {
                sleep(500);
            } catch (InterruptedException ex) {}
        }
    }
    //--------------------------------------------------------------------------
    public String creaPalabra(){
        String semilla="abcdefghikklmnñopqrstuvwxyz";
        String palabra="";
        int tam = (int)((Math.random()*10+2));
        for(int i=0; i<=tam; i++){
            int l=(int)((Math.random()*27));
            char c=semilla.charAt(l);
            palabra+=c;
        }
        return palabra;
    }
}
