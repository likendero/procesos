/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo1;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author paco
 */
public class HablarServidor implements Runnable {
    Scanner teclado= new Scanner(System.in);
    ArrayList<Clientes> clientes;
    boolean salir;
    public HablarServidor(ArrayList<Clientes> c, boolean exit){
        clientes=c;
        salir=exit;
    }
    @Override
    public void run(){
        String cad;
        while(true){
            cad=teclado.nextLine();
            if(cad.trim().equalsIgnoreCase("cerrar") ||cad.trim().equalsIgnoreCase("exit")){
                salir=true;
                break;
            }
            if(clientes.size()!=0){
                for(Clientes c: clientes){
                    c.getSalida().println("[Servidor]>"+cad);
                }
            }
            else{
                System.out.println("\tNingún Cliente Conectado al Chat!!!!!!");
            }
        }
    }
    //--------------------------------------------------------------------------
}
