package tcp2;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class Hablar implements Runnable {
    // lectura de teclado
    private Scanner key;
    private ArrayList<PrintWriter> flujosEscritura;
    /**
     * constructor del elemento para hablar
     */
    public Hablar(ArrayList<PrintWriter> flujos){
        super();
        this.flujosEscritura = flujos;
        this.key = new Scanner(System.in);
    }


    @Override
    public void run() {
        String mensaje = "";
        while(true){
            // captura de telcado del mensaje escrito
            mensaje = key.nextLine();
            if(!mensaje.trim().toLowerCase().equals("exit")){
                // salida del mensaje escrito
                for(PrintWriter pr:flujosEscritura){
                    pr.println("servidor: " + mensaje);
                    System.out.println("enviado");
                }
                // caso de orden de cierre
             }else{
                System.exit(0);
             }
        }
    }

}