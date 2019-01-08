package tcp3;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente implements Runnable {
    // variables
    private Socket socket;
    private String nombre;
    private BufferedReader bufRed;
    private PrintWriter pWriter;
    /**
     * constructor de cliente
     */
    public Cliente (Socket socket, String nombre){
        super();
        // captura del socket
        this.socket = socket;
        // captura del nombre 
        this.nombre = nombre;
        // creaciond de los flujos de la conexion
        try{
            // Creacion flujo de entrada
            BufferedReader bufAux;
            bufAux = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // creacion del flujo de salida
            PrintWriter pwAux;
            pwAux = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            // captura de los flujos por la clase
            
        }catch(){}
    }

}