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
public class Main {
     public static void main(String [] args){
        MiLista c = new MiLista();
        Consumidor con =  new Consumidor(c);
        Productor pro = new Productor(c);
        pro.start();
        con.start();
               
    }
    
}
