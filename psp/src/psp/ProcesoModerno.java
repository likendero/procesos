package psp;


import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author likendero
 */
public class ProcesoModerno {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("gedit","prueba.txt");
        try{
            Process p = pb.start();
            
        }catch(IOException ex){
            System.out.println("sfsf");
        }
    }
}
