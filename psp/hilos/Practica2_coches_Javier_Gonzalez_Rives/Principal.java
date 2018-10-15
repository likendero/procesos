package lavadero;
import java.util.ArrayList;

import lavadero.Coche;
/**
 * @author Javier Gonzalez Rives
 */
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
        
        // oredenacion del array
        coches = ordenar(coches);
        System.out.println("tiempo coche1 " +  coches.get(0).getTiempo());
        System.out.println("tiempo coche2 " +  coches.get(1).getTiempo());
        System.out.println("tiempo coche3 " +  coches.get(2).getTiempo());
        System.out.println("tiempo coche4 " +  coches.get(3).getTiempo());
        // creacion de lavaderos
        Lavar lavadero1 = new Lavar(coches.get(0));
        Lavar lavadero2 = new Lavar(coches.get(1));
        Lavar lavadero3 = new Lavar(coches.get(2));
        Lavar lavadero4 = new Lavar(coches.get(3));
        long ti = System.currentTimeMillis();
        // inicio de los dos primeros lavados
        lavadero1.start();
        lavadero2.start();
        // espera mientras uno termina
        while(lavadero1.isAlive() && lavadero2.isAlive()){

        }
        // inicio del lavadero3
        lavadero3.start();
        // en el caso que no este el lavadero 1 se espera al 3 y el 2
        if(!lavadero1.isAlive()){
            while(lavadero3.isAlive() && lavadero2.isAlive()){

            }
            // en el caso que el 1 este vivo se espera al 3 y el 1
        }else{
            while(lavadero3.isAlive() && lavadero1.isAlive()){

            }
        }
        // se inicia el 4
        lavadero4.start();
        // no mostrar tiempo final hasta que todos los hilos hallan terminado
        try{
            lavadero1.join();
            lavadero2.join();
            lavadero3.join();
            lavadero4.join();
        }catch(InterruptedException it){
            it.printStackTrace();
        }
        // final
        long te = (System.currentTimeMillis() - ti)/1000;
        
        System.out.println("tiempo final: " + te);
    }
    /**
     * metodo que ordena la lista de coches
     * @param list
     */
    public static ArrayList<Coche> ordenar(ArrayList<Coche> list){
        Coche aux = null; 
        boolean control = false;
        // numero de veces de ordenado
        for(int i = 0; i < list.size() && !control;i++){
            control = true;
            // recorrido a trabes de la lista
            for(int j = 0; j < list.size();j++){
                // compribacion que el el indice no se sale
                if(j+1 < list.size()){
                    // comparacion entre el elemento anterior y el siguiente
                    if(list.get(j).getTiempo() < list.get(j+1).getTiempo()){
                        // si es menor se hace el cambio
                        aux = list.get(j);
                        list.set(j,list.get(j+1));
                        list.set(j+1,aux);
                        control = false;
                    }
                }
            }
        }
        return list;
    }
}