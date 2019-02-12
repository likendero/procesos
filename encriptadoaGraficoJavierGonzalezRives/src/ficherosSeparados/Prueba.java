/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficherosSeparados;

/**
 *
 * @author Javier Gonzalez Rives
 */
public class Prueba {
    public static void main(String[] args) {
        String frase = "hola que tal";
        String clave = "clave";
        String resultado = "";
        System.out.println(frase);
        resultado = Cifrar.cifrarAes25664(frase, clave);
        System.out.println(resultado);
        resultado = Descifrar.descifrarAes25664(resultado, clave);
        System.out.println(resultado);
    }
}
