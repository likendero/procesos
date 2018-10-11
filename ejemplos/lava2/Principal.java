package lava2;
import static java.lang.Thread.sleep;
import java.util.concurrent.*;

import java.util.Random;
public class Principal{
    public static void main(String [] args){
        int numCoches=20;
        int numOpe=15;
        long ti = System.currentTimeMillis();
        Coches [] misCoches=new Coches[numCoches];
        int tC, tL;
        int [] tiempos = new int[numCoches];
        for(int i=0; i<misCoches.length; i++){
            Random r = new Random();
            tC=r.nextInt(3);
            tL=r.nextInt(3);
            misCoches[i]=new Coches("Coche-"+i, tC, tL);
            tiempos[i]=misCoches[i].getTiempoLavado();
        }
         //1.- Cremos el executor y le indicamos en numero de hilos simultaneo  
        ExecutorService es = Executors.newFixedThreadPool(numOpe);
        //2.- Mandamos todos los coches al executors, es decir creamos un pool de coches
        int contOp=1;
        for(Coches c : misCoches){
            Operarios op = new Operarios(c, "Operarios->"+contOp);
            es.execute(op);
            contOp++;
        }
       
        //3.- Apagamos el servicio
        es.shutdown();;
        //4.- esperamos a que terminen todos los coches de lavarse 
        while(!es.isTerminated()){

        }
        long tf=System.currentTimeMillis();
        System.out.println("\033[32m\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> He terminado de lavar los " + numCoches + " coches!!!!!");
        System.out.println("\033[32m>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> El tiempo Total ha sido :" + (tf-ti)/1000 + " segundos.");

    }
    //-------------------------------------------------------------------------------  
    
}
