package servidor;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class HiloClientes implements Runnable{
    private ArrayList<Cliente> clientes;
    private Cliente cliente;
    private BufferedReader lector;
    private PrintWriter escritor;
    boolean control = true;
    /**
     * metodo que construye la escucha con los clienes
     */
    public HiloClientes(ArrayList<Cliente> clientes, Cliente cliente){
        this.clientes = clientes;
        this.cliente = cliente;
        this.lector = cliente.getRd();
        this.escritor = cliente.getPw();
    }
    // METODOS //////////////////////////////////////////////////////////
    /**
     * metodo que recibe el mensaje del cliente
     */
    private String recibirMensaje(){
        String entrada = "";    
        try{
            entrada = lector.readLine();
        }catch(Exception ex){}
        entrada = entrada.trim();
        return entrada;
    }
    /**
     * metodo que comprueba si el mensaje entrado es un comando
     */
    private boolean comando(String mensaje){
        mensaje = mensaje.trim();
        if(!mensaje.isEmpty() && mensaje.charAt(0) == '\\'){
            String[] partes = mensaje.split(" ",2);
            // selector de comandos
            switch(partes[0]){
                case "\\exit":
                    control = false;
                    clientes.remove(cliente);
                break;
            }
            return true;
        }
        return false;
    }
    /**
     * metodo que envia el mensaje mandado por un cliente a todo el resto
     */
    private void enviarMensaje(String mensaje){
        System.out.println(cliente.toString() +": " +  mensaje);

        try{
            for(Cliente cli: clientes){
                PrintWriter escritor = cli.getPw();
                escritor.println(cliente.toString() +": " +  mensaje);
            }
        }catch(Exception ex){

        }
    }
    // HILO /////////////////////////////////////
    @Override
    public void run() {
        // bucle control del hilo
        try{
            while(control){
                
                String mensaje = recibirMensaje();
                // tratamiento del mensaje
                if(!comando(mensaje)){
                    enviarMensaje(mensaje);
                }
            }
        }catch(Exception ex){

        }   
    }
}