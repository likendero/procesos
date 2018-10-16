package lavadero2;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lavadero2.*;
/**
 * @author Javier Gonzalez Rives
 */
public class Principal{
    private static Scanner key = new Scanner(System.in);
    /**
     * metodo  principal
     * @param args
     */
    public static void main(String[] args) {
        long ti = System.currentTimeMillis();
        int numeroCoches = 4,numeroOperarios = 2;
        ArrayList<Coche> coches = new ArrayList<Coche>();
        // annadiendo coches
        /*
        coches.add(new Coche(Tamanno.GRANDE, "zafira"));
        coches.add(new Coche(Tamanno.PEQUENNO, "clio"));
        coches.add(new Coche(Tamanno.MEDIANO, "polo"));
        coches.add(new Coche(Tamanno.GRANDE, "renault 19"));
        */
        
        // bucle que genera y annade tantos coches como se halla especificado
        for(int i = 0 ; i < numeroCoches; i++){
            // creacion y annadido del coche
            coches.add(crearCoche());
        }
        
        // oredenacion del array
        coches = ordenar(coches);
        // creacion del Executor
        ExecutorService ex = Executors.newFixedThreadPool(numeroOperarios);
        // creacion del pool
        for(Coche co: coches){
            // creacion del lavadero con hilo
            Lavar lav = new Lavar(co);
            // se annade al pool
            ex.execute(lav);
        }
        ex.shutdown();
        while(!ex.isTerminated()){

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
    /**
     * metodo que genera de forma aleatoria el tamanno del coche
     * @return tamanno aleatorio
     */
    public static Tamanno tamannoEleg(int tam){
        
        // switch para devolver el tamanno segun el numero
        switch(tam){
            // 1 equivale a pequenno
            case 1:
                return Tamanno.PEQUENNO;
            // 2 equivale a mediano
            case 2: 
                return Tamanno.MEDIANO;
            // 3 equivale a Grande
            case 3:
                return Tamanno.GRANDE;
        }
        return null;
    }
    /**
     * metodo que devuelve el tiempo segun el modo seleccionado
     * @param tiem modo seleccionado
     */
    public static int tiempo(int tiem){
        // se controla que el modo seleccionado es valido
        if(tiem > 0 && tiem < 4){
            // si lo es devuelve el tiempo indicado
            return tiem*2;
        }
        // sino devuelve -1 indicando que esta fuera derango
        return -1;
    }
    /**
     * metodo que sirve para preguntar al usuario por los datos del coche
     * @return
     */
    public static Coche crearCoche(){
        boolean control = false;
        Tamanno tam = null;
        int tiempo = 0;
        String modelo = "";
        // introduccion del tamanno
        do{
            try{
                // mensaje mostrando opciones
                System.out.println("Tamanno del coche");
                System.out.println("1. pequenno");
                System.out.println("2. mediano");
                System.out.println("3. grande");
                // introduccion y seleccion a trabes del metodo 
                tam = tamannoEleg(key.nextInt());
                // comprobacion de introduccion valida
                if(tam != null){
                    control = true;
                }else{
                    // si la introduccion no es valida muestra un mensaje
                    System.out.println("valor fuera de rango");
                }
                // en el caso de error en la intro por teclado
            }catch(InputMismatchException in){
                System.out.println("error en la introduccion");
                key.nextLine();
            }catch(Exception ex){
                System.out.println("error inesperado");
            }
        }while(!control);
        control = false;
        // introduccion del modo
        do{
            try{
                // mensaje mostrando opciones
                System.out.println("Tamanno del coche");
                System.out.println("1. normal");
                System.out.println("2. extra");
                System.out.println("3. super");
                // introduccion y seleccion a trabes del metodo 
                tiempo = tiempo(key.nextInt());
                // comprobacion de introduccion valida
                if(tiempo != -1){
                    control = true;
                }else{
                    // si la introduccion no es valida muestra un mensaje
                    System.out.println("valor fuera de rango");
                }
                // en el caso de error en la intro por teclado
            }catch(InputMismatchException in){
                System.out.println("error en la introduccion");
                key.nextLine();
            }catch(Exception ex){
                System.out.println("error inesperado");
            }
        }while(!control);
        // introduccion del modelo
        System.out.println("introduce el modelo o identificador del coche");
        modelo = key.next();
        Coche coche = new Coche(tam, modelo, tiempo);
        return coche;
    }
}