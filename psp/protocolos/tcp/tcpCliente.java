import java.net.InetAddress;
import java.net.Socket;

/**
 * clase que crea un cliente que se comunica con un servidor tcp
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
        InetAddress ip;
        try{
            ip = InetAddress.getByName();
        }catch(){

        }
        try(
            Socket conexion = new Socket();
            ){
            

        }
    }

}