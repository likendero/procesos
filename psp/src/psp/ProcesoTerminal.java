/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author likendero
 */
public class ProcesoTerminal {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("ls", "/home/likendero");
        try{
            Process p = pb.start();
            InputStream in = p.getInputStream();
            InputStreamReader inp = new InputStreamReader(in);
            BufferedReader re = new BufferedReader(inp);
            String line;
            while((line = re.readLine()) != null){
                System.out.println(line);
            }
        }catch(IOException io){
            System.out.println("error");
        }
    }
}
