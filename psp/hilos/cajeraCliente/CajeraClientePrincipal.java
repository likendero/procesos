package cajeraCliente;

import cajeraCliente.Cajera;
import cajeraCliente.Clientes;

/**
 * clase que inicia la ejecucion de las cajera
 */
public class CajeraClientePrincipal{

    public static void main(String[] args) {
        // control del tiempo
        long ti = System.currentTimeMillis();
        // creacion de los clientes
        Clientes juan = new Clientes("juan",new int[] {2,4,1,5});
        Clientes maria = new Clientes("maria",new int[] {2,4,6,7} );
        Clientes ronaldo = new Clientes("ronaldo", new int[] {4,5,5,2,5,6});
        // creacion Cajeras
        Cajera cajera1 = new Cajera(juan);
        Cajera cajera2 = new Cajera(maria);
        Cajera cajera3 = new Cajera(ronaldo);
        // inicio procesos
        cajera1.start();
        cajera2.start();
        cajera3.start();

        try{
            cajera1.join();
            cajera2.join();
            cajera3.join();
 
        }catch(InterruptedException in){
            in.printStackTrace();
        }
    }

}