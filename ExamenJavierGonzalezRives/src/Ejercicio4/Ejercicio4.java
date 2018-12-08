/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

/**
 *
 * @author examen
 */
public class Ejercicio4 {
    public static void main(String[] args) {
        Contenedor  con = new Contenedor();
        Ponedor ponedor = new Ponedor(con);
       Consumidor consumidor = new Consumidor(con);
       (new Thread(ponedor)).start();
       (new Thread(consumidor)).start();
       
        
    }
}
