/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calendario;

import org.joda.time.LocalDate;

/**
 *
 * @author Javier Gonzalez Rives
 */
public class Calendario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LocalDate dia = new LocalDate();
        System.out.println(dia.toString());
    }
    
}
