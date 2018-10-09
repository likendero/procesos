package lavadero;
import java.util.ArrayList;

import lavadero.Coche;
public class Principal{
    /**
     * metodo  principal
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<Coche> coches = new ArrayList<Coche>();
        // annadiendo coches
        coches.add(new Coche(Tamanno.GRANDE, "zafira"));
        coches.add(new Coche(Tamanno.PEQUENNO, "clio"));
        coches.add(new Coche(Tamanno.MEDIANO, "polo"));
        coches.add(new Coche(Tamanno.GRANDE, "renault 19"));
        // creacion de lavaderos
        Lavar lavadero1 = new Lavar();
        Lavar lavadero2 = new Lavar();
        long ti = System.currentTimeMillis();
        // bucle que recorre los coches
        for(Coche co: coches){
            
            // si se pude se usa el lavadero1
            if(!lavadero1.isAlive()){
                lavadero1.setCoche(co);
                lavadero1.start();
                
            }
            // sino y  si se puede se usa el 2
            else if(!lavadero2.isAlive()){
                lavadero2.setCoche(co);
                lavadero2.start();
            }
            while(lavadero1.isAlive() && lavadero2.isAlive()){
            }
        }
        // final
        long te = (System.currentTimeMillis() - ti)/1000;
        
        System.out.println("tiempo final: " + te);
    }
}