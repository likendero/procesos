/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Javier Gonzalez Rives
 */
public class Conexion {
    private Connection conexion;
    private final String NOMBRE = "usuario";
    private final String PASS = "usuario";
    /**
     * metodo constructor con el que se crea la conexion
     */
    public Conexion()throws SQLException{
        this.conexion = DriverManager.getConnection("jdbc:mysql://localhost/empresa?useSSL=false",NOMBRE,PASS);
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
}
