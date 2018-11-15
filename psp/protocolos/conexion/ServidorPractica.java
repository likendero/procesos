import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * clase que crea un servidor que devuelve un 
 * paquete con texto
 */
public class ServidorPractica{
    /**
     * metodo principal que incia el servidor
     * @param args
     */
    public static void main(String[] args) {
        // definicion variables servidor
        final int puerto = 7777;
        byte[] datos;
        DatagramSocket canal = null;
        /// inicio
        try{
            // creacion de conexion a trabes del puerto establecido
            canal = new DatagramSocket(puerto);
            System.out.println("SE HA INICIADO EL SERVIDOR");
            canal.setSoTimeout(180000);

            // inicio del bucle para escuchar entradas
            while(true){
                // detagramPacket para guardar la informacion de entrada
                DatagramPacket recepcion = new DatagramPacket(new byte[1024], 1024);
                // recepcion a trabes de canal
                canal.receive(recepcion);
                // mensaje de la conexion
                System.out.println("conexion de " + recepcion.getAddress() + ":" + recepcion.getPort());
                // creacion de la respuesta
                System.out.println("creando respuesta");
                String respuesta = new String("eres tonto o que te pasa");
                // paso a bytes la salida
                datos = respuesta.getBytes();
                // creacion del datagramPacket de salida
                DatagramPacket salida = new DatagramPacket(datos, datos.length,recepcion.getAddress(),recepcion.getPort());
                // envio
                canal.send(salida);
                System.out.println("\t respuesta enviada\n");
            }

        }catch(IOException io){
            System.out.println("error en la entrada salida de datos");
        }catch(Exception ex){
            System.out.println("error inseperado");
        }
    }

}