/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherosSeparados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Javier Gonzalez Rives
 */
public class Descifrar {
    /**
     * metod que desencripta la clabe en base 64
     * @param clave la clave para el descifrado
     * @param frase mensaje que se va a descifrar
     * @return 
     */
    public static String descifrarTresDes64(String frase,String clave){
        String salida = null;
        try{
            // paso de la clave a array de bytes
            byte[] bitClave = Arrays.copyOf(clave.getBytes("UTF-8"), 24);
            // objeto clave
            SecretKey key = new SecretKeySpec(bitClave, "DESede");
            Cipher cip = Cipher.getInstance("DESede");
            // indicamos la operacion que va a realiza el objeto para el desencriptado
            cip.init(cip.DECRYPT_MODE, key);
            byte[] bitFrase = CadenasBase64.descodificar(frase);
            byte[] bitSalida = cip.doFinal(bitFrase);
            salida = new String(bitSalida);
            
        }catch(Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
        
        return salida;
    }
    /**
     * metod que desencripta la clabe en base 64
     * @param clave la clave para el descifrado
     * @param frase mensaje que se va a descifrar
     * @return 
     */
    public static String descifrarAes25664(String frase,String clave){
        String salida = null;
        try{
            // paso de la clave a array de bytes
            byte[] bitClave = Arrays.copyOf(clave.getBytes("UTF-8"), 32);
            // objeto clave
            SecretKey key = new SecretKeySpec(bitClave, "AES");
            Cipher cip = Cipher.getInstance("AES/ECB/PKCS5Padding");
            // indicamos la operacion que va a realiza el objeto para el desencriptado
            cip.init(cip.DECRYPT_MODE, key);
            byte[] bitFrase = CadenasBase64.descodificar(frase);
            byte[] bitSalida = cip.doFinal(bitFrase);
            salida = new String(bitSalida);
            
        }catch(Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
        
        return salida;
    }
    /**
     * metod que desencripta la clabe en base 64
     * @param clave la clave para el descifrado
     * @param frase mensaje que se va a descifrar
     * @return 
     */
    public static String descifrarAes12864(String frase,String clave){
        String salida = null;
        try{
            // paso de la clave a array de bytes
            byte[] bitClave = Arrays.copyOf(clave.getBytes("UTF-8"), 16);
            // objeto clave
            SecretKey key = new SecretKeySpec(bitClave, "AES");
            Cipher cip = Cipher.getInstance("AES/ECB/PKCS5Padding");
            // indicamos la operacion que va a realiza el objeto para el desencriptado
            cip.init(cip.DECRYPT_MODE, key);
            byte[] bitFrase = CadenasBase64.descodificar(frase);
            byte[] bitSalida = cip.doFinal(bitFrase);
            salida = new String(bitSalida);
            
        }catch(Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
        }
        
        return salida;
    }
    
    public static void descifrarFichero(File ficheroEntrada, File ficheroSalida, String clave, int tipoCifrado){
        if(ficheroEntrada != null && ficheroSalida != null)
        // selector de tipo de encriptado
        switch(tipoCifrado){
            case 1:
                descifrarFichero128(ficheroEntrada, ficheroSalida, clave);
                break;
            case 2:
                descifrarFichero256(ficheroEntrada, ficheroSalida, clave);
                break;
            case 3:
                descifrarFichero3Des(ficheroEntrada, ficheroSalida, clave);
                break;
        }
    }
    /**
     * metodo que desencripta para el metodo aes 128
     * @param ficheroEntrada
     * @param ficheroSalida
     * @param clave 
     */
    private static void descifrarFichero128(File ficheroEntrada,File ficheroSalida,String clave){
        
        try{
            // copntrasenna
            byte[] bitClave = Arrays.copyOf(clave.getBytes(), 16);
            SecretKey key = new SecretKeySpec(bitClave, "AES");
            // creacion del cipher
            Cipher cip = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cip.init(Cipher.DECRYPT_MODE, key);
            // creaciond del bucle de lectura y escritura
            CipherInputStream entrada = new CipherInputStream(new FileInputStream(ficheroEntrada),cip);
            FileOutputStream salida =new FileOutputStream(ficheroSalida);
            byte[] buffer = new byte[1024];
            int numeroLeido;
            // bucle de lectura y escritura
            while((numeroLeido = entrada.read(buffer)) > 0){
                // escritura con escritor cifrador
                salida.write(buffer, 0, numeroLeido);
            }
            salida.close();
            entrada.close();
        }catch(Exception ex){
            System.out.println("ha sucedido un error: " + ex.getMessage());
        }
    }
    /**
     * metodo que desencripta para el metodo aes 128
     * @param ficheroEntrada
     * @param ficheroSalida
     * @param clave 
     */
    private static void descifrarFichero256(File ficheroEntrada,File ficheroSalida,String clave){
        
        try{
            // copntrasenna
            byte[] bitClave = Arrays.copyOf(clave.getBytes(), 32);
            SecretKey key = new SecretKeySpec(bitClave, "AES");
            // creacion del cipher
            Cipher cip = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cip.init(Cipher.DECRYPT_MODE, key);
            // creaciond del bucle de lectura y escritura
            CipherInputStream entrada = new CipherInputStream(new FileInputStream(ficheroEntrada),cip);
            FileOutputStream salida =new FileOutputStream(ficheroSalida);
            byte[] buffer = new byte[1024];
            int numeroLeido;
            // bucle de lectura y escritura
            while((numeroLeido = entrada.read(buffer)) > 0){
                // escritura con escritor cifrador
                salida.write(buffer, 0, numeroLeido);
            }
            salida.close();
            entrada.close();
        }catch(Exception ex){
            System.out.println("ha sucedido un error: " + ex.getMessage());
        }
    }
    private static void descifrarFichero3Des(File ficheroEntrada,File ficheroSalida,String clave){
        
        try{
            // copntrasenna
            byte[] bitClave = Arrays.copyOf(clave.getBytes(), 24);
            SecretKey key = new SecretKeySpec(bitClave, "DESede");
            // creacion del cipher
            Cipher cip = Cipher.getInstance("DESede");
            cip.init(Cipher.DECRYPT_MODE, key);
            // creaciond del bucle de lectura y escritura
            CipherInputStream entrada = new CipherInputStream(new FileInputStream(ficheroEntrada),cip);
            FileOutputStream salida =new FileOutputStream(ficheroSalida);
            byte[] buffer = new byte[1024];
            int numeroLeido;
            // bucle de lectura y escritura
            while((numeroLeido = entrada.read(buffer)) > 0){
                // escritura con escritor cifrador
                salida.write(buffer, 0, numeroLeido);
            }
            salida.close();
            entrada.close();
        }catch(Exception ex){
            System.out.println("ha sucedido un error: " + ex.getMessage());
        }
    }
}
