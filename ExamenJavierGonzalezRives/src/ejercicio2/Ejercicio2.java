/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Scanner;
/**
 *
 * @author Javier Gonzalez Rives
 */
public class Ejercicio2 {
    private static Alumno[] alumnos;
    
    private static Scanner key = new Scanner(System.in);
    /**
     * metodo principal
     * @param args 
     */
    public static void main(String[] args) {
       String[] tarea = {"tarea1","tarea2","tarea3","tarea4","tarea5"};
       
        
        alumnos = new Alumno[20];
        // generando alumnos
        for(int i = 0; i < alumnos.length; i++){
            String[] aux = new String[5];
            aux[0] = tarea[0];
            aux[1] = tarea[1];
            aux[2] = tarea[2];
            aux[3] = tarea[3];
            aux[4] = tarea[4];
            // generacion de alumnos
            alumnos[i] =  new Alumno("alumno"+i, aux);
        }
        int numeroProfesores = 0;
        // introduccion controlada
        do{
            try{
                System.out.println("introduce un numero de profesores entre 2 y 10");
                numeroProfesores = key.nextInt();
            }catch(InputMismatchException in){
                System.out.println("introduce un numero");
            }
        }while(numeroProfesores < 2 || numeroProfesores > 10);
       
        ExecutorService ex = Executors.newFixedThreadPool(numeroProfesores);
        long time = System.currentTimeMillis();
        int contador = 0;
        while(contador < alumnos.length){
            
            ex.execute(new Profesor("profesor " + contador,alumnos[contador]));
            contador++;
        }
        ex.shutdown();
        while(!ex.isTerminated()){}
        long timeEnd = (System.currentTimeMillis()-time)/1000;
        System.out.println("terminado en " + timeEnd + " segundos");
       
    }
}
