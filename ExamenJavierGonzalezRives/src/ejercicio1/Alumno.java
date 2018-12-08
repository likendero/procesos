package ejercicio1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author examen
 */
public class Alumno {
    private String nombre;
    private String[] nTarea;
    private int[] tPracticas;
    /**
     * metodo constructor de alumnos
     */
    public Alumno(String nombre,String[] tareas){
        super();
        this.nombre = nombre;
        this.nTarea = tareas;
        this.tPracticas = new int[this.nTarea.length];
        // asigancion del tiempo
        generarTiempos();
    }
    /**
     * metodo que genera de forma aleatoria el tiempo
     * a cada tarea
     */
    private void generarTiempos(){
        
        // bucle que crea y añade los tiempos
        for(int i = 0; i < tPracticas.length ; i++){
            // se generara un tiempo de entre 1 y 21
            int tiempo = (int)(Math.random()*20+1);
            tPracticas[i] = tiempo;
            
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getnTarea() {
        return nTarea;
    }

    public void setnTarea(String[] nTarea) {
        this.nTarea = nTarea;
    }

    public int[] gettPracticas() {
        return tPracticas;
    }

    public void settPracticas(int[] tPracticas) {
        this.tPracticas = tPracticas;
    }
    
}
