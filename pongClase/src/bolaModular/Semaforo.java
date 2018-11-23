/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolaModular;

/**
 *
 * @author Javier Gonzalez Rives
 */
public class Semaforo {
    private boolean estado;
    /**
     * constructor
     */
    public Semaforo(){
        super();
        this.estado = true;
    }
    /**
     * constructor parametrizado
     * @param estado 
     */
    public Semaforo(boolean estado) {
        this.estado = estado;
    }
    //// GUETTERS SETTERS////
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
