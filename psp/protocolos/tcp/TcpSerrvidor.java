import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * clase que crea un servidor para ... enviar mensajes
 */
public class TcpSerrvidor{
    private static final int PUERTO = 15001;
    /**
     * metodo principal
     */
    public static void main(String[] args) {
        try(
            // creacion del servidor en el puerto
            ServerSocket server = new ServerSocket(PUERTO);
            // aceptacion de la tuberia
            Socket conexion = server.accept();
            // creacion del flujo de entrada
            BufferedReader IN = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
            // creacion del flujo de salida
            PrintWriter OUT = new PrintWriter(conexion.getOutputStream(),true);
        ){
            // mensaje de bienvenida
            OUT.println("Bienvenido: " + conexion.getInetAddress() + ":" + conexion.getPort());
            while(true){
                String cad = IN.readLine();
                System.out.println(cad);
                if(cad.toLowerCase().trim().equals("exit")){
                    System.exit(0);
                }
            }

        }catch(IOException io){
            System.out.println("error entrada salida");
        }
    }

}