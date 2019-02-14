/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import modelo.Conexion;

/**
 *
 * @author Javier Gonzalez Rives
 */
public class main {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Conexion con = new Conexion();
        }catch(Exception ex){
            System.out.println("error " + ex.getMessage());
        }
    }
}
