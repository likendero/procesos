import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import com.sun.beans.util.Cache;

/**
 * clase que crea un cliente que se comunica con un servidor tcp
 * martes dia 4
 * @author Javier Gonzalez Rives
 */
public class tcpCliente{
    /**
     * principal
     * @param args
     */
    public static void main(String[] args) {
        if(args.length < 2){
            System.out.println("faltan campos");
            System.exit(0);
        }
        // variables de la conexion
        InetAddress ip;
        String puerto;
        // captura de los valores
        try{
            ip = InetAddress.getByName(args[0]);
            puerto = args[1];
        }catch(UnknownHostException un){
            System.out.println("no se conoce el servidor");
        }
        try(
            Socket conexion = new Socket(ip,puerto);
            BufferedReader IN = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            ){
            

        }catch(){

        }
    }

}