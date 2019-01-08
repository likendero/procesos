/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1;

/**
 *
 * @author Javier Gonzalez Rives
 */
public class Ejercicio1 {
    private static String[][] proyectos = 
    {
        {"acdat","matematicas","biologia"},
        {"fisica","conocimiento","filosofia","lengua"},
        {"algebraLienal","matematica discreta","quimica"},
        {"fisica","conocimiento","filosofia","lengua"},
        {"algebraLienal","matematica discreta","quimica"}
    };
    /**
     * metodo principal
     * @param args 
     */
    public static void main(String[] args) {
        // creacion de alumnos
        Alumno alumno1 = new Alumno("javier", proyectos[0]);
        Alumno alumno2 = new Alumno("maria", proyectos[1]);
        Alumno alumno3 = new Alumno("alicia", proyectos[2]);
        Alumno alumno4 = new Alumno("jesu", proyectos[3]);
        Alumno alumno5 = new Alumno("enrique", proyectos[4]);
        
        // creacion de profesores
        Profesor profesor1 = new Profesor("fran", alumno1);
        Profesor profesor2 = new Profesor("Mariano", alumno2);
        Profesor profesor3 = new Profesor("sergismundo", alumno3);
        Profesor profesor4 = new Profesor("canola", alumno4);
        Profesor profesor5 = new Profesor("pimpinela", alumno5);
        
        // inicio del tiempo
        long inicial = System.currentTimeMillis();
        Thread hilo1 = new Thread(profesor1);
        Thread hilo2 = new Thread(profesor2);
        Thread hilo3 = new Thread(profesor3);
        Thread hilo4 = new Thread(profesor4);
        Thread hilo5 = new Thread(profesor5);
        // incio de los hilos
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        // bucle control de hilos
        while(
                hilo1.isAlive() ||
                hilo2.isAlive() ||
                hilo3.isAlive() ||
                hilo4.isAlive() ||
                hilo5.isAlive() 
                ){
        
        }
        long tiempoFinal = (System.currentTimeMillis()-inicial)/1000;
        System.out.println("TIEMPO FINAL: " + tiempoFinal);
    }
}
