
package ficherosSeparados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Javier Gonzalez Rives
 */
public class Cifrar {
    
    
    /**
     * metodo que cifra una frase y la devuelve en base 64 
     * usando el metodo 3des
     * @return 
     */
    public static String cifrarTresDes64(String frase,String clave){
        String salida = null;
        try{
            //transformacion de la cadena clave
            // funciona solo con bytes de 24 de longitud
            byte[] bClave = Arrays.copyOf(clave.getBytes("UTF-8"),24);
            // creacion del objeto que representa la clave
            SecretKey key = new SecretKeySpec(bClave,"DESede");
            // instanciacion de l cipher que realiza la encriptacion
            Cipher cifrador = Cipher.getInstance("DESede");
            // se indica el modo encriptado
            cifrador.init(Cipher.ENCRYPT_MODE, key);
            // paso a bytes de la frase
            byte[] palabraByte = frase.getBytes("UTF-8");
            byte[] palabraCifrada = cifrador.doFinal(palabraByte);
            salida = CadenasBase64.codificar(palabraCifrada);// se crea la salida en base 64
            
        }catch(UnsupportedEncodingException un){
            System.out.println("codificacion no sopoertada");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return salida;
    }
    
    /**
     * metodo que cifra una frase y la devuelve en base 64 
     * usando el metodo AES128
     * @return 
     */
    public static String cifrarAes12864(String frase,String clave){
        String salida = null;
        try{
            //transformacion de la cadena clave
            // funciona solo con bytes de 24 de longitud
            byte[] bClave = Arrays.copyOf(clave.getBytes("UTF-8"),16);
            // creacion del objeto que representa la clave
            SecretKey key = new SecretKeySpec(bClave,"AES");
            // instanciacion de l cipher que realiza la encriptacion
            Cipher cifrador = Cipher.getInstance("AES/ECB/PKCS5Padding");
            // se indica el modo encriptado
            cifrador.init(Cipher.ENCRYPT_MODE, key);
            // paso a bytes de la frase
            byte[] palabraByte = frase.getBytes("UTF-8");
            byte[] palabraCifrada = cifrador.doFinal(palabraByte);
            salida = CadenasBase64.codificar(palabraCifrada);// se crea la salida en base 64
            
        }catch(UnsupportedEncodingException un){
            System.out.println("codificacion no sopoertada");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return salida;
    }
    /**
     * metodo que cifra una frase y la devuelve en base 64 
     * usando el metodo AES 256
     * @return 
     */
    public static String cifrarAes25664(String frase,String clave){
        String salida = null;
        
        try{
            //transformacion de la cadena clave
            // funciona solo con bytes de 24 de longitud
            byte[] bClave = Arrays.copyOf(clave.getBytes("UTF-8"),32);
            // creacion del objeto que representa la clave
            SecretKey key = new SecretKeySpec(bClave,"AES");
            // instanciacion de l cipher que realiza la encriptacion
            Cipher cifrador = Cipher.getInstance("AES/ECB/PKCS5Padding");
            // se indica el modo encriptado
            cifrador.init(Cipher.ENCRYPT_MODE, key);
            // paso a bytes de la frase
            byte[] palabraByte = frase.getBytes("UTF-8");
            byte[] palabraCifrada = cifrador.doFinal(palabraByte);
            salida = CadenasBase64.codificar(palabraCifrada);// se crea la salida en base 64
            
        }catch(UnsupportedEncodingException un){
            System.out.println("codificacion no sopoertada");
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return salida;
    }
    // cifrado para ficheros ///////////////////////////////////////////////////
    /**
     * metodo que cifra un fichero 
     * @param tipoCifrado 1 AES128 2 AES256 3 3DES
     */
    public static void cifrarFichero(File ficheroEntrada, File ficheroSalida, String clave, int tipoCifrado){
        if(ficheroEntrada != null && ficheroSalida != null)
        // selector de tipo de encriptado
        switch(tipoCifrado){
            case 1:
                cifrarFichero128(ficheroEntrada, ficheroSalida, clave);
                break;
            case 2:
                cifrarFichero256(ficheroEntrada, ficheroSalida, clave);
                break;
            case 3:
                cifrarFichero3Des(ficheroEntrada, ficheroSalida, clave);
                break;
        }
    }
    /**
     * cifrar el fichero en modo AES256
     */
    private static void cifrarFichero128(File ficheroEntrada,File ficheroSalida,String clave){
        
        try{
            // copntrasenna
            byte[] bitClave = Arrays.copyOf(clave.getBytes(), 16);
            SecretKey key = new SecretKeySpec(bitClave, "AES");
            // creacion del cipher
            Cipher cip = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cip.init(Cipher.ENCRYPT_MODE, key);
            // creaciond del bucle de lectura y escritura
            FileInputStream entrada = new FileInputStream(ficheroEntrada);
            CipherOutputStream salida = new CipherOutputStream(new FileOutputStream(ficheroSalida),cip);
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
     * cifrar el fichero en modo AES256
     */
    private static void cifrarFichero256(File ficheroEntrada,File ficheroSalida,String clave){
        
        try{
            // copntrasenna
            byte[] bitClave = Arrays.copyOf(clave.getBytes(), 32);
            SecretKey key = new SecretKeySpec(bitClave, "AES");
            // creacion del cipher
            Cipher cip = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cip.init(Cipher.ENCRYPT_MODE, key);
            // creaciond del bucle de lectura y escritura
            FileInputStream entrada = new FileInputStream(ficheroEntrada);
            CipherOutputStream salida = new CipherOutputStream(new FileOutputStream(ficheroSalida),cip);
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
     * cifrar el fichero en modo AES128
     */
    private static void cifrarFichero3Des(File ficheroEntrada,File ficheroSalida,String clave){
        
        try{
            // copntrasenna
            byte[] bitClave = Arrays.copyOf(clave.getBytes(), 24);
            SecretKey key = new SecretKeySpec(bitClave, "DESede");
            // creacion del cipher
            Cipher cip = Cipher.getInstance("DESede");
            cip.init(Cipher.ENCRYPT_MODE, key);
            // creaciond del bucle de lectura y escritura
            FileInputStream entrada = new FileInputStream(ficheroEntrada);
            CipherOutputStream salida = new CipherOutputStream(new FileOutputStream(ficheroSalida),cip);
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
