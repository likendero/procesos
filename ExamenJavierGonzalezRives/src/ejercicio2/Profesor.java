/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import ejercicio1.*;

/**
 *
 * @author examen
 */
public class Profesor implements Runnable {
    private String nombre;
    private Alumno alumno;
    /**
     * metodo que crea un profesor
     */
    public Profesor(String nombre,Alumno al){
        super();
        this.nombre = nombre;
        this.alumno = al;
    }
    //
    private void espera(int seg){
        try{
            long tiempo = seg * 1000;
            Thread.sleep(tiempo);
        }catch(InterruptedException in){
            System.out.println("fallo");
        }
    }
    @Override
    public void run() {
        // recorrido de las practicas
        for(int i = 0; i < alumno.getnTarea().length; i++){
            long inicio = System.currentTimeMillis();
            System.out.println(nombre + " corrijiendo practica " + alumno.getnTarea()[i] + ""
                    + "\n del alumno " + alumno.getNombre());
            // espera
            espera(alumno.gettPracticas()[i]);
            long tiempoTotal = (System.currentTimeMillis()-inicio)/1000;
            System.out.println(nombre + " ha correjido " + alumno.getnTarea()[i] + ""
                    + "\n del alumno " + alumno.getNombre() + " tiempo total : " + tiempoTotal);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ejercicio2.Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(ejercicio2.Alumno alumno) {
        this.alumno = alumno;
    }
    
}
