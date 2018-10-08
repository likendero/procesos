package ejercicios;
import java.lang.Thread;



/**
 * clase principal
 */
public class Ejercicio1Hilos{
    public static void main(String[] args) {
        // inicio de tiempo
        long tiempoInicial = System.currentTimeMillis();
        // cuenta atras
        CuentaAtras cuenta = new CuentaAtras();
        cuenta.start();
        int numeroPrimos = 0,aux;
        
        // bucle que imprime los 10 primeros primos
        for(int i = 2 ; numeroPrimos < 10;i++){
            CuentaAtras.espera(500);
            aux = i-1;
            // recorrido comprobando divisores de los numeros
            while(i%aux!=0 && aux>1){
                // en cada paso se reduce el valor de aux
                aux--;
            }
            // si aux no es uno quiere decir que el numero no es primo
            if(aux != 1){
                System.out.println( i + " es primo ");
                numeroPrimos++;
            }
        }
        // control que el segundo proceso sigue en marcha
        while(cuenta.isAlive()){

        }
        long tiempoFinal = (System.currentTimeMillis()-tiempoInicial)/1000;
        System.out.println("tiempo final: " + tiempoFinal);
    }

}
/**
 * clase que hace la cuenta atras
 */
class CuentaAtras extends Thread{

    public CuentaAtras(){
        super();

    }

    @Override
    public void run() {
        super.run();
        CuentaAtras();
    }

    public void CuentaAtras(){
        long tiempoInicial = System.currentTimeMillis();
        // cuenta atras
        for(int i = 15; i >= 1; i-- ){
            // se imprime la cuenta atras
            System.out.println("\tquedan " + i + " segundos");
            espera(1000);

        }
        // calculo y salida del tiempo de proceso
        long tiempoFinal = (System.currentTimeMillis()-tiempoInicial)/1000;
        System.out.println("\t tiempo final: " + tiempoFinal);

    }
    /**
     * metodo para realizar la espera entre cada segundo
     * @param tiempo
     */
    public static void espera(long tiempo){
        try{
            // sleep para realizar la espera
            Thread.sleep(tiempo);
            // control de excepciones
        }catch(InterruptedException in){
            System.out.println("la espera ha sido interrumpida");
            System.exit(0);
        }

    }
}