import java.net.*;
import java.util.*;
import java.io.IOException;
class Cliente1{
	public static void main(String[] args) {
		if(args.length<2){
			System.out.println("ERROR, debe especificar Dirección Ip y Puerto del Servidor!!!!");
			System.out.println("#javac Cliente1 Dir_IP PTO  ");
			System.exit(0);
		}
		//recojemos el string de dir ip y lo convertimos a inetadress y elpuerto y lo convertimos a int
		InetAddress destino=null;
		try{
			 destino = InetAddress.getByName(args[0]);
		}catch(UnknownHostException ex){
			System.err.println("Imposible Verificar IP, formato incorrecto!!!!");
			System.exit(0);
		}
		int pto=0;
		try{
			pto = Integer.parseInt(args[1]);
		}catch(NumberFormatException ex){
			System.out.println("Error, puerto Erroneo!!!!!");
			System.exit(0);
		}
		//Montamos todo para enviar peticion y recibir respuesta ---------------------------------
		DatagramSocket conexion=null;
		DatagramPacket dp1;
		byte [] msj_p = new byte[1024];


		try{
			//preparamos conexion, datagrama y enviamos
			conexion=new DatagramSocket();
			dp1=new DatagramPacket(msj_p, msj_p.length, destino, pto);
			conexion.send(dp1);
			System.out.println("PETICION ENVIADA, ESPERANDO RESPUESTA....");
			//Preparamos la respuesta
			DatagramPacket dp_r = new DatagramPacket(new byte[1024], 1024);
			conexion.receive(dp_r);
			System.out.println("Repuesta recibida de : " + dp_r.getAddress() + ", Puerto: " + dp_r.getPort() + ", La respuesta es: ");
			String res= new String(dp_r.getData());
			System.out.println("\t\""+res+"\"");

		}catch(SocketException ex){
			System.err.println("Error abrindo Conexion!!!!!");
			System.exit(0);
		}catch(IOException ex){
				System.out.println("Error al recibir la respuesta!!!!!!!");
		}
	}
}

//Arriba
