/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import mensaje.ParteFichero;

/**
 *
 * @author paco
 */
public class Cliente {
    static File fichero;
    static ObjectInputStream OIS;
    static String nomFichero;
    public static void main(String [] args){
        InetAddress dip=null;
        int pto=0;
        

        if(args.length!=2){
            System.err.println("Error se esperaba Dirección Ip y Puerto: ");
            System.out.println("USO \"java Cliente dirIP Puerto\"");
            System.exit(-1);
        }
        //Convertimos la dirección a formato InetAdress y el puerto a int
        String cad=args[0];
        try {
            dip =InetAddress.getByName(cad);
            pto=Integer.parseInt(args[1]);
        } catch (UnknownHostException ex) {
            System.err.println("Formato de Dirreción IP Errorneo o Desconocido");
            System.exit(-1);
        }catch(NumberFormatException ex){
            System.err.println("Formato Puerto Erroneo!!!!");
            System.exit(-1);
        }
        System.out.println("Parte 1.-");
        //---------------------------------------------------------------------
        try(
                Socket con=new Socket(dip, pto);
                //ObjectOutputStream oos=new ObjectOutputStream(con.getOutputStream());
                ObjectInputStream ois=new ObjectInputStream(con.getInputStream())
                )
        {
            OIS=ois;
            //recibo el saludo
            String saludo=(String)OIS.readObject();
            System.out.println(saludo);
            recibirFichero();
        }catch(IOException ex){
            System.err.println("Error al recibir el fichero!!!!!");
            System.err.println("Mensaje: "+ex.getMessage());
            System.exit(-1);
        }catch(ClassNotFoundException ex){

    }
    }
    //-------------------------------------------------------------------------
    public static void recibirFichero(){
      System.out.println("Estoy en recibirFichero");  
       Object aux;
       ParteFichero pFich;
       FileOutputStream fos=null;
       boolean creado=false;
       do{
           pFich=new ParteFichero();
           try {
               aux=OIS.readObject();
              // System.out.println("Leida parte");
               if(aux instanceof ParteFichero){
                   //casting a aux 
                   pFich=(ParteFichero)aux;
                   //si le fichero aun no lo hemos creado lo creamos con el mismo nombre
                   if(!creado){
                       nomFichero=pFich.getNombreFichero();
                       fichero=new File(nomFichero);
                       creado=true;
                       fos=new FileOutputStream(fichero);
                       System.out.println("Crado FileOutputStream y Fichero");
                   }
                   fos.write(pFich.getParte(), 0, pFich.getBytesValidos());
               }
               else{
                    // Si no es del tipo esperado, se marca error y se termina el bucle
                    System.err.println("Mensaje no esperado " + aux.getClass().getName());
                    break;
               }
           } catch (IOException ex) {
               System.out.println("Error recibiendo Fichero!!!!!");
               System.exit(-1);
           }catch(ClassNotFoundException ex){

           }
       }while(!pFich.isUltimaParte());
       
    }
} 
