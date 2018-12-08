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
public class Consumidor implements Runnable{
    private Contenedor con;
    /**
     * constructor de consumidor
     * @param con 
     */
    public Consumidor(Contenedor con){
        super();
        this.con = con;
    }

    @Override
    public void run() {
        while(true){
            con.consumir();
        }
    }
    
}
