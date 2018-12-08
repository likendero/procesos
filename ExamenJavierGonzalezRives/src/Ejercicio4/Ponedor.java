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
public class Ponedor implements Runnable {
    private Contenedor con;
    public Ponedor(Contenedor con){
        super();
        this.con = con;
    }
    /**
     * metodo que genera cadenas de forma aleatoria
     * @return 
     */
    private String generar(){
        String letras = "abcdefghijklmnopqrstuvwxyz";
        char[] letrasch = letras.toCharArray();
        int a = 26;
        String salida = "";
        for(int i = 0; i < 6 ; i++){
            int posicion = (int)(Math.random()*26);
            salida += letrasch[posicion];
        }
        return salida;
    }
    @Override
    public void run() {
        while(true){
            con.producir(generar());
            try{
                int tiempo = (int)(Math.random()*10);
                Thread.sleep(tiempo*1000);
            }catch(InterruptedException ie){}
        }
    }
    
}
