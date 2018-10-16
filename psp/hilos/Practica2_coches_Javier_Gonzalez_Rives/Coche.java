package lavadero;
/**
 * @author Javier Gonzalez Rives
 */
public class Coche{
    private Tamanno tamanno;
    private String identificador;
    private int tiempo;
    /**
     * metodo constructor con el tamanno del coche
     * @param tamanno
     */
    public Coche(Tamanno tamanno,String identificador){
        super();
        this.tamanno = tamanno;
        this.identificador = identificador;
        // el tiempo total se saca con el tiempo por tamanno + tiempo por lavado aleatorio
        this.tiempo = this.tamanno.getTiempo() + tiempoTipoAleatorio();
    }
   
    /**
     * metodo que devuelve el tiempo del lavado
     * @return
     */
    public int getTiempo(){
        return this.tiempo;
    }
    /**
     * metodo que devuelve el identificador de l coche
     * @return
     */
    public String getIdentificador(){
        return identificador;
    }
    /**
     * metodo que genera de forma aleatoria el tiempo de lavado
     * 2,4,8
     * @return
     */
    private int tiempoTipoAleatorio(){
        // se genera un numero aleatorio entre el 1 y el 3
        return (int)((Math.random()*3+1)*2);
    }
}