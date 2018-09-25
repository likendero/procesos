/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp;

import java.io.IOException;

/**
 *
 * @author likendero
 */
public class LanzarUnproceso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        String progran = "firx";
        Process p;
        try{
            p = rt.exec("opera");
        }catch(IOException io){
            System.out.println("error");
        }
    }
    
}
