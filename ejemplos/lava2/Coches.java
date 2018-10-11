package lava2;
public class Coches{
    private String nombreCoche;
    private int tipoC; //tipo coche pequeño mediano....
    private int tipoL; //tipo lavado normal, extra...
    private int tiempoLavado;

    public Coches(String n, int c, int l){
        nombreCoche=n;
        tipoC=c;
        tipoL=l;

    }
    //--------------------------------------------------------------------------------------------
    public int getTiempoLavado(){
            tiempoLavado=10+4*tipoC+2*tipoL;
        
        return tiempoLavado;
    }
    //---------------------------------------------------------------------------------------------
    public String getNombreCoche(){
        return nombreCoche;
    }
}