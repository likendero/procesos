package ejercicios;
import java.lang.Thread;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * clase principal para el ejecucion del ejercicio 2
 */
public class Ejercicio2Hilos{
    private static Scanner key = new Scanner(System.in);
    public static void main(String[] args) {
        //  introduccion del numero a descomponer
        boolean control = false;
        Descomposicion des = null;
        do{
        try{
            System.out.println("introduce el numero a descomponer");
            System.out.println("tiene que ser 100000 < n < 1000000");
            // creacion + instanciacion
            des = new Descomposicion(key.nextInt());
            // cambio de situacion
            control = true;
            // control de la introduccion
        }catch(InputMismatchException in){
            System.out.println("error en la entrada");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        // fin del bucle control
        }while(!control);
        long ti = System.currentTimeMillis();
        // instanciacion de los hilos
        Thread saludo =  new Thread( new Saludos());
        Thread descomposicion = new Thread(des);
        saludo.start();
        descomposicion.start();
        try{
            for(int i = 0; i < 10 ; i++){
                System.out.println("\t\tjava es divertido");
                Thread.sleep(1000);
            }
        }catch(InterruptedException it){
            System.out.println("error");
        }
        while(descomposicion.isAlive() || saludo.isAlive()){

        }
        long tf = (System.currentTimeMillis()-ti)/1000;
        System.out.println("tiempo total = " + tf);
    }
}
/**
 * clase que hace la descomposicion en numeros primos 
 */
class Descomposicion implements Runnable{
    private int numero;
    /**
     * constructor principal
     */
    public Descomposicion(int numero)throws Exception{
        super();
        // control para que el numero este en el rango adecuado
        if(numero < 100000 || numero > 1000000){
            throw new Exception("numero fuera de rango");
        }
        this.numero = numero;
    }
    @Override
    public void run() {
        // tiempo de inicio
        long ti = System.currentTimeMillis();
        // inicio de la descomposicion
        proceso();
        // tiempo final
        long tf = (System.currentTimeMillis()-ti)/1000;
        // salida del tiempo
        System.out.println("tiempo descomposicion = " + tf);
    }
    /**
     * metodo que hace la descomposicion
     */
    public void proceso(){
        int aux = this.numero;
        int dos = 0 ,tres = 0 ,cinco = 0;
        // bucle que hace la descomposicion de 2
        while(aux % 2 == 0 && aux != 0 ){
            // se realiza la divison
            aux /= 2;
            dos++;
        }
        // descomposicion de 3
        while(aux % 3 == 0 && aux != 0){
            // division entre 3
            aux /= 3;
            tres++;
        }
         // descomposicion de 5
         while(aux % 5 == 0 && aux != 0){
            // division entre 3
            aux /= 3;
            cinco++;
        }
        
        System.out.println(formateoSalida(dos, tres, cinco));
    }
    /**
     * metodo que prepara la salida dependiendo de la descomposicion
     * @param dos
     * @param tres
     * @param cinco
     * @return
     */
    private String formateoSalida(int dos,int tres, int cinco){
        boolean bandera = false;
        String salida = new String(this.numero + " = ");
        // formateo de 2
        if(dos != 0){
            // caso que 2 tenga pontencia > 1
            if(dos > 1){
                salida += "2^" + dos; 
                
            }
            // caso que 2 tenga pontencia < 1
            else{
                salida += "2";
            }
            // bandera de suceso
            bandera = true;
        }
        // formateo para 3
        if(tres != 0){
            if(bandera){
                salida += " * ";
            }
            // caso que 3 tenga pontencia > 1
            if(tres > 1){
                salida += "3^" + tres; 
                
            }
            // caso que 3 tenga pontencia < 1
            else{
                salida += "3";
            }
            // bandera de suceso
            bandera = true;
        }
        // formateo para 5
        if(cinco != 0){
            if(bandera){
                salida += " * ";
            }
            // caso que 5 tenga pontencia > 1
            if(cinco > 1){
                salida += "5^" + tres; 
                
            }
            // caso que 5 tenga pontencia < 1
            else{
                salida += "5";
            }
            // bandera de suceso
            bandera = true;
        }
        return salida;
    }

}
class Saludos implements Runnable{
    private int numeroSaludos;
    /**
     * constructor que genera el numero de saludos de forma aleatoria
     */
    public Saludos(){
        super();
        // generacion del numero aleatorio
        numeroSaludos = (int)(Math.random()*10+1);
    }
    @Override
    public void run() {
        long ti = System.currentTimeMillis();
        for(int i = 0; i < numeroSaludos; i++){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException it){
                System.out.println("error");
            }
            System.out.println("\t saludo " + i);
        }
         // tiempo final
         long tf = (System.currentTimeMillis()-ti)/1000;
         // salida del tiempo
         System.out.println("tiempo saludos = " + tf);
    }

}