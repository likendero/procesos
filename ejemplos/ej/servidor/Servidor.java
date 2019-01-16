/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author paco
 */
public class Servidor {
    public static final int PTO=15000;
    public static void main(String []args){
        try(
                ServerSocket conex=new ServerSocket(PTO);                )
        {
            banner();
            do{
                (new Thread(new HiloServidor(conex.accept()))).start();
                
            }while(true);
        }catch(Exception ex){
            System.err.println("Error en Servidor, mensaje: "+ex.getMessage());
            System.exit(-1);
        }
    }
    //--------------------------------------------------------------------------
    public static void banner(){
        System.out.println("+------------------------------------------------------+");
        System.out.println("|                                                      |");
        System.out.println("|    **** Servidor de Archivos V 1.0 Iniciado ****     |");
        System.out.println("|    ****    Puerto 15000     ****                     |");
        System.out.println("|                                                      |");
        System.out.println("+------------------------------------------------------+\n");
        
    }
    
}
