package tcp3;
import java.net.ServerSocket;

import tcp2.Semaforo;
/**
 * clase que define un servidor en el 
 * que se conectaran una serie de usuarios
 */
public class Servidor implements Runnable{
    // variable que contiene el puerto
    private final int PORT = 15555;
    private ServerSocket socket;
    private Semaforo controlServer;
    /**
     * metodo constructor para el servidor
     */
    public Servidor(int tiempoVida,Semaforo control) {
        super();
        // creacion del socket
        this.socket = new ServerSocket(PORT);
        /// elmentos de control de server
        this.controlServer = control;
        // tiempo de vida para el servidor
        this.socket.setSoTimeout(tiempoVida);
    }

    @Override
    public void run() {
        // bucle que controla el hilo
        /*
        los casos en los que se termian el servidor es con:
        comando exit desde el administrador y el fin del tiempo
        */
        while(controlServer.isEstado() && !socket.isClosed()){
            try{
                
            }catch(Exception ex){}
        }
        
    }
}