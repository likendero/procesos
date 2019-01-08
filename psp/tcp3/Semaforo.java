package tcp2;

public class Semaforo{
    private boolean estado;
    /**
     * metodo constructor del semaforo
     * inicio encendido
     */
    public Semaforo(){
        super();
        this.estado = true;
    }
    /**
     * metodo que cambia el estado del semaforo
     * @param estado nuevo estado del semaforo
     */
    public void setEstado(boolean estado){
        this.estado = estado;
    }
    /**
     * metodo que devuelve el estado actual del semaforo
     * @return true or false 
     */
    public boolean isEstado(){
        return this.estado;
    }
}