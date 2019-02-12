/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;

import mensaje.ParteFichero;

/**
 *
 * @author paco
 */
public class HiloServidor implements Runnable {
    private String nArchivo="nokia-tune-original.mp3";
    private Socket conexion;
    private File fichero;
    //private ObjectInputStream OIS;
    private ObjectOutputStream OOS;
    private BufferedInputStream BIS;
    public HiloServidor(Socket c){
        conexion=c;
        System.out.println("Llego una peticion, maquina remota: "+ c.getRemoteSocketAddress());

    }
    @Override
    public void run() {
        URL  url=getClass().getResource(nArchivo);
        fichero=new File(url.getPath());
        if(!fichero.exists()){
            System.err.println("Error: Imposible abrir fichero para envio!!!!!");
            System.exit(-1);
        }
        try(
            ObjectOutputStream oos = new ObjectOutputStream(conexion.getOutputStream());
           // ObjectInputStream ois = new ObjectInputStream(conexion.getInputStream());
            InputStream is= new FileInputStream(fichero);
            BufferedInputStream bis = new BufferedInputStream(is);
                )
        {
            System.out.println("TODO ABIERTO!!!!!!");
           // OIS=ois;
            OOS=oos;
            BIS=bis;
            System.out.println("\t1. Mandando Fichero a cliente: "+conexion.getRemoteSocketAddress());
            mandarFichero();
        }catch(IOException ex){
            System.err.println("Error en hiloServidor al mandar fichero, mensaje: "+ex.getMessage());
        }
    }
    //_-------------------------------------------------------------------------
    public void mandarFichero(){
        String saludo="Procediendo a subir el archivo: "+nArchivo;
        try{
            OOS.writeObject(saludo);
        }catch(IOException ex){

        }
        int leidos=0;
        ParteFichero pFich;
        try{
            do{
                pFich=new ParteFichero();
                pFich.setNombreFichero(nArchivo);
                leidos=BIS.read(pFich.getParte());
                if(leidos<0) break;
                pFich.setBytesValidos(leidos);
                if(leidos<1024){
                    pFich.setUltimaParte(true);
                }
                else{
                    pFich.setUltimaParte(false);
                }
                OOS.writeObject(pFich);
                
            }while(!pFich.isUltimaParte());
             System.out.println("Fichero Enviado, Transmision OK............");
        }catch(Exception ex){
            System.out.println("Error al mandar partes del fichero");
            System.out.println("Mensaje de error: "+ex.getMessage());
        }
        
    }
    
}
