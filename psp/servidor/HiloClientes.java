package servidor;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class HiloClientes implements Runnable{
    private ArrayList<Cliente> clientes;
    private Cliente cliente;
    private BufferedReader lector;
    private PrintWriter escritor;
    private Cliente chatPrivadoCli; // mientras que no se crea un chat privado es null
    private boolean chatPrivado;
    boolean control = true;
    /**
     * metodo que construye la escucha con los clienes
     */
    public HiloClientes(ArrayList<Cliente> clientes, Cliente cliente){
        this.clientes = clientes;
        this.cliente = cliente;
        this.lector = cliente.getRd();
        this.escritor = cliente.getPw();
        this.chatPrivadoCli = null;
        this.chatPrivado = false;
    }
    // METODOS //////////////////////////////////////////////////////////
    /**
     * metodo que recibe el mensaje del cliente
     */
    private String recibirMensaje(){
        String entrada = "";    
        try{
            entrada = lector.readLine();
        
        }catch(Exception ex){

        }
        entrada = entrada.trim();
        return entrada;
    }
    /**
     * metodo que comprueba si el mensaje entrado es un comando
     */
    private boolean comando(String mensaje){
       
        if(mensaje.charAt(0) == '\\'){
            String[] partes = mensaje.split(" ",2);
          
            // selector de comandos
            switch(partes[0]){
                case "\\exit":
                    control = false;
                    clientes.remove(cliente);
                break;
                case "\\help":
                    escritor.println("\\h Ayuda\n\\"
                    + "\\l Listar Clientes\n"
                    +"\\p Chat privado con cliente\n"
                    +"\\s Chat privado con servidor\n"
                    +"\\z Salir de Chat Privado (Cliente o Servidor)\n"
                    +"\\x salir \n"
                    +"el comando p requiere de un sgundo argumento");
                    escritor.flush();
                break;
                case "\\l":
                    String listado = new String();
                    // una sola cadena con el nombre de todos los clientes
                    for(Cliente cli: clientes){
                        // incluyo el del propietario tambien
                        listado += cli.getNombre() + '\n';
                    }
                    escritor.println(listado);
                    escritor.flush();
                break;
                case "\\p":
                System.out.println("paso por chat privado");
                    // para este metodo se necesita de un segundo argumento
                    if(partes[1].equals("")){
                        escritor.println("falta un argumento <nombre cliente>");
                        escritor.flush();
                        // no debe existir otro maldito chat previamente
                    }else if(chatPrivado){
                        escritor.println("termina primero el chat privado");
                        escritor.flush();
                    }else{
                        for(Cliente cli: clientes){
                            // busqueda del cliente y captura
                            if(cli.getNombre() == partes[1]){
                                chatPrivadoCli = cli;
                                chatPrivado = true;
                            }
                        }
                        
                    }

                break;
                case "\\s":
                    // parecido al chat privado normal
                    if(chatPrivado){
                        escritor.println("termina primero el chat privado");
                        escritor.flush();
                    }else{
                        chatPrivadoCli = null;
                        chatPrivado = true;
                    }
                break;
                case "\\z":
                    chatPrivado = false;
                    chatPrivadoCli = null;
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
        // si es privado se manda unicamnete al cliente
        if(chatPrivado && chatPrivadoCli != null){
            chatPrivadoCli.getPw().println(mensaje);
            chatPrivadoCli.getPw().flush();
        }else if(!chatPrivado){
            try{
                for(Cliente cli: clientes){
                   // cli.getPw().println(mensaje);
                    
                    cli.getPw().println(cliente.toString() +": " +  mensaje);
                    cli.getPw().flush();
                }
            }catch(Exception ex){
                System.out.println("error en el envio");
            }
        }
    }
    // HILO /////////////////////////////////////
    @Override
    public void run() {
        // bucle control del hilo
        try{
            while(control){
                
                String mensaje = recibirMensaje();
                if(mensaje != null){
                    // tratamiento del mensaje
                    if(!comando(mensaje)){
                        enviarMensaje(mensaje);
                    }
                }
            }
        }catch(Exception ex){

        }   
    }
}