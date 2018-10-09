package lavadero;
import java.lang.Thread;
import lavadero.Coche;
/**
 * metodo que realiza el lavado del coche
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
     * metodo que genera de forma aleatoria el tiempo de lavado
     * 2,4,8
     * @return
     */
    private int tiempoTipoAleatorio(){
        // se genera un numero aleatorio entre el 1 y el 3
        return (int)((Math.random()*3+1)*2);
    }
    /**
     * metodo que realiza el lavado segun el tiempo
     */
    private void lavando(){
        try{
            System.out.println("incio del lavado " + this.coche);
            long tiempoLavado = this.coche.getTiempo() + tiempoTipoAleatorio();
            sleep(tiempoLavado);
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