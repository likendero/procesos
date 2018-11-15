import java.net.*;
import java.util.*;
import java.io.IOException;
class Servidor1{
	public static void main(String[] args) {
		final int PTO=9000;
		byte [] mensaje;
		DatagramSocket conexion=null;
		try{
			//Abrimos conexion (udp) en el puerto 9000 con timeout de 3m
			conexion = new DatagramSocket(PTO);
			System.out.println("      -------------------------------      ");
			System.out.println("!!->> SERVIDOR UDP ACTIVO DURANTE 3m. <<-!!");
			System.out.println("      -------------------------------      ");
			conexion.setSoTimeout(180000);
			//bucle iinfunito para escuchar conexiones entrantes
			while(true){
				//si nos llega una peticion la guardamos en un datagrampacket lo creamos, lo usamos y mostramos
				DatagramPacket recibido = new DatagramPacket(new byte[1024], 1024);
				conexion.receive(recibido); //recibido ya tiene los datos de la peticion
				System.out.println("1.- Petición recibida, datos de la peticion: ");
				System.out.println("\td1.- Direccion IP: " +  recibido.getAddress());
				System.out.println("\td2.- Puerto: " + recibido.getPort());
				//preparamos la respuesta
				System.out.println("\nPreparando Respuesta.....");
				String respuesta=new String("Hora del Servidor: " + new Date());
				//lo pasamos a array de bytes
				byte [] respuesta_b=respuesta.getBytes();
				//Preparamos el datagrama a enviar
				DatagramPacket enviado = new DatagramPacket(respuesta_b, respuesta_b.length, recibido.getAddress(), recibido.getPort());
				//Lo enviamos
				conexion.send(enviado);
				System.out.println("---> RESPUESTA ENVIADA...\n");

			}
		}catch(SocketException ex){
			System.err.println("Error, imposible abrir conexion en el puerto: "+ PTO);
		}catch(IOException ex){
			System.out.println("Imposble enviar mensaje !!!!");
		}finally{
			conexion.close();
		}
	}
}
