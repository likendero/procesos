/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherosSeparados;

import java.util.Base64;

/**
 *
 * @author Javier Gonzalez Rives
 */
public class CadenasBase64 {
    public static String codificar(byte[] palabra){
        Base64.Encoder codificador = Base64.getEncoder();
        String vuelta = codificador.encodeToString(palabra);
        return vuelta;
    }
    public static byte[] descodificar(String frase){
        Base64.Decoder decodificador = Base64.getDecoder();
        byte[] palabra = decodificador.decode(frase);
        return palabra;
    }
}
