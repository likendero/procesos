package lava2;
import static java.lang.Thread.sleep;

public class Operarios implements Runnable{
    Coches miCoche;
    String nombre;
    public Operarios(Coches c, String n){
        miCoche=c;
        nombre=n;
    }
    @Override
    public void run(){
        long ti = System.currentTimeMillis();
        System.out.println("\033[34m### >> Iniciando Lavado de Coche: " +miCoche.getNombreCoche()+", por operario: " +nombre+" << ###");
        try{
            sleep(1000*miCoche.getTiempoLavado());
        }catch(Exception ex){
            System.err.println("Error: "+ex.getMessage());
        }
        long tf=System.currentTimeMillis();
        System.out.println("\033[31m=======>>>> El operario: " + nombre + " Termino de lavar el coche: " + miCoche.getNombreCoche() +" !!!!!");
        System.out.println("\033[31m=======>>>> El tiempo de Lavado de coche: " +miCoche.getNombreCoche()+ " ha sido: " + (tf-ti)/1000);
    }
    //----------------------------------------------------------------------------------------------------
}