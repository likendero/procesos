/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

import java.util.ArrayList;

/**
 *
 * @author Javier Gozalez Rives
 */
public   class  Contenedor {
    private  String palabra;
    /**
     * metodo constructor
     */
    public  Contenedor(){
        super();
        palabra = null;
    }
    /**
     * metodo que escribe palabras
     * @param cadena 
     */
    public synchronized void producir(String cadena){
        if(palabra != null){
            System.out.println("lleno");
            try{
                wait();
            }catch(InterruptedException in){}
        }else{
            System.out.println("se ha añadido " + cadena);
            palabra = cadena;
            notify();
        }
    }
    /**
     * metodo que consume
     */
    public synchronized void consumir(){
    if(palabra == null){
            System.out.println("vacio");
            try{
                wait();
            }catch(InterruptedException in){}
        }else{
            // proceso de consumir palabra
            System.out.println("consumiendo " + palabra);
            try{
                int tiempo = (int)(Math.random()*10);
                Thread.sleep(tiempo*1000);
            }catch(InterruptedException in){}
            palabra = null;
            notify();
        }
    }
}
