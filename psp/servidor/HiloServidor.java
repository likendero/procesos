package servidor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
public class HiloServidor implements Runnable{

    private static Scanner key = new Scanner(System.in);
    private ArrayList<Cliente> clientes;
    private boolean control;
    /**
     * constructor del hilo para inciciar la escucha del server
     */
    public HiloServidor(ArrayList<Cliente> clientes){
        super();
        this.clientes = clientes;
        this.control = true;
    }
    // METODOS ////////////////////////////////////////////////////
    /**
     * metodo que comprueba si se trata de un comado
     * @param mensaje de entrada a comprobar
     * @return true si se trata de un mensaje false else
     */
    private boolean comandos(String mensaje){
        mensaje = mensaje.trim();
        
        // si es un comando empieza por barra
        if(!mensaje.isEmpty() && mensaje.charAt(0) == '\\'){
            String[] cadenas = mensaje.split(" ",2);
            // ejecucion segun el comando
            switch(cadenas[0]){
                case "\\exit":
                    System.out.println("fin del servidor");
                    System.exit(0);
                break;
                case "\\help":
                    System.out.println("");
                break;
                case "\\b":
                    try{
                        int id = Integer.parseInt(cadenas[1]);
                        boolean exito = false;
                        // recorrido
                        for(int i = 0; i < clientes.size(); i++){
                            // comprobacion del id
                            if(clientes.get(i).getId() == id){
                                /*
                                    el remove se puede hacer segun objeto, esto hace posible
                                    el borrado a trabes de un for each.
                                */
                                clientes.remove(i);
                                exito = true;
                            }
                        }
                        // mensaje de baneao realizado o no
                        System.out.println(exito? "se ha baneado el usuario correctamente":
                        "no se ha encontrado el usuario");
                    }catch(InputMismatchException in){
                        System.out.println(" el id debe ser numerico");
                    }
                break;

                default: 
                    System.out.println("no es un comando valido");
                break;
            }
            return true;
        }
        return false;

    }
    // CONTROL HILO ///////////////////////////////////
    @Override
    public void run() {
        // bucle del hilo
        while(control){
            System.out.print("Servidor: ");
            String entrada = key.nextLine();
            
            // se manda un mensaje si la entrada no es un comando
            if(!comandos(entrada)){
                // el mensaje se manda por cada Cliente
                for(Cliente cli: clientes){
                    try{
                        // PrintWriter escritor = cli.getPw();
                        cli.getPw().println(entrada);
                        cli.getPw().flush();
                        //System.out.println(entrada.trim());
                    }catch(Exception ex){
                        System.out.println("Ha ocurrido un error: ");
                        ex.printStackTrace();
                    }
                }
            }
        }
    }


}