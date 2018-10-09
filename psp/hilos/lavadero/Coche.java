package lavadero;

public class Coche{
    private Tamanno tamanno;
    private String identificador;
    /**
     * metodo constructor con el tamanno del coche
     * @param tamanno
     */
    public Coche(Tamanno tamanno,String identificador){
        super();
        this.tamanno = tamanno;
        this.identificador = identificador;
    }
    /**
     * metodo que devuelve el tiempo del lavado
     * @return
     */
    public int getTiempo(){
        return this.tamanno.getTiempo();
    }
    /**
     * metodo que devuelve el identificador de l coche
     * @return
     */
    public String getIdentificador(){
        return identificador;
    }

}