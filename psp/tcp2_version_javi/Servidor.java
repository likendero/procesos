package tcp2;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.ArrayList;

import tcp2.HiloConexion;

public class Servidor {
    private static final int PUERTO = 15555;
    private static int numCliente = 1;
    private static ArrayList<PrintWriter> flujosSalida;
    public static void main(String[] args) {
        flujosSalida = new ArrayList<PrintWriter>();
        // creacion conexion envevida
        try(
            ServerSocket cocnexion = new ServerSocket(PUERTO);
        ){
            Hablar hablar = new Hablar(flujosSalida);
            (new Thread(hablar)).start();
            // bucle para las conexiones
            while(true){
                HiloConexion hiloConexion = new HiloConexion(cocnexion.accept(), numCliente++);
                System.out.println("nuevo cliente " + (numCliente-1));
                OutputStreamWriter out = new OutputStreamWriter(hiloConexion.getSocket().getOutputStream());
                PrintWriter escritor = new PrintWriter(out,true);
                flujosSalida.add(escritor);
                hiloConexion.setEscritor(escritor);
                (new Thread(hiloConexion)).start();
            }
            //cocnexion.close();
        }catch(IOException io){
            io.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static ArrayList<PrintWriter> getFlujos(){
        return flujosSalida;
    }
}