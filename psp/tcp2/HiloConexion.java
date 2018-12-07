package tcp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import tcp2.Semaforo;
import tcp2.Servidor;

public class HiloConexion implements Runnable{
    private Socket socket;
    private int numCliente;
    private Semaforo semaforo;
    private PrintWriter escritor;
    /**
     * metodo constructor
     */
    public HiloConexion(Socket socket,int numCliente){
        super();
        // captura de los valores
        this.socket = socket;
        this.numCliente = numCliente;
        this.semaforo = new Semaforo();
    }

    @Override
    public void run() {
        // bucle que rige el hilo
       
            // control de entrada
            try(
                // creacion de un flujo de lectura
                BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ){
                while(this.semaforo.isEstado()){
                    String lectura = lector.readLine();
                    lectura = lectura.trim();
                    // accion del hilo
                    // comprobacion comando de salida
                    if(lectura.toLowerCase().equals("exit")){
                        eliminarFlujo();
                        semaforo.setEstado(false);
                    }
                    // en el caso que no sea comando de salida
                    else{
                        // sale por pantalla el mensaje
                        System.out.println("cliente " + numCliente +": " + lectura);
                        redistribuir(lectura);
                    }
                }
            }catch(IOException io){
                io.printStackTrace();
            }catch(NullPointerException nu){
                System.out.println("salida inesperada");
            }catch(Exception ex){
                ex.printStackTrace();
            }
            
        
    }
    /**
     * clase  que redistribuye un mensaje 
     * sin re enviarlo al propio usuario
     * @param mensaje
     */
    private void redistribuir(String mensaje){
        // recorrido de salidas
        for(PrintWriter pr: Servidor.getFlujos()){
            // comprobacion de salida
            if(!this.escritor.equals(pr)){
                // salida
                pr.println("cliente " + numCliente + ": " + mensaje);
            }
        }
    }
    /**
     * metodo que elimina el flujo del cliente que 
     * ha salido
     */
    private void eliminarFlujo(){
        ArrayList<PrintWriter> lista = Servidor.getFlujos();
        lista.remove(escritor);
    }
    /**
     * devuelve el semaforo que maneja el estado de la conexion
     * @return
     */
    public Semaforo getSemaforo(){
        return this.semaforo;
    }
    /**
     * el socket de la conexion
     * @return
     */
    public Socket getSocket(){
        return this.socket;
    }
    /**
     * escritor
     */
    public void setEscritor(PrintWriter escritor){
        this.escritor = escritor;
    }
}