package lavadero;
import java.lang.Thread;
import lavadero.Coche;
/**
 * metodo que realiza el lavado del coche
 * @author Javier Gonzalez Rives
 */
public class Lavar extends Thread{
    private Coche coche;
    public Lavar(){
        super();
        this.coche = null;
    }
    public Lavar(Coche coche){
        super();
        this.coche = coche;
    }
    
    /**
     * metodo que realiza el lavado segun el tiempo
     */
    private void lavando(){
        try{
            System.out.println("incio del lavado " + this.coche.getIdentificador());
            long tiempoLavado = this.coche.getTiempo();
            sleep(tiempoLavado*1000);
        }catch(InterruptedException it){
            System.out.println("proceso interrumpido");
        }

    }
    @Override
    public void run() {
        // inicio del tiempo
        long ti = System.currentTimeMillis();
        lavando();
        // final del tiempo
        long te = (System.currentTimeMillis() - ti)/1000;
        System.out.println("tiempo total de lavado: " + te);
    }
    public void setCoche(Coche coche){
        this.coche = coche;
    }
}