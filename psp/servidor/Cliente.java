package servidor;
/**
 * @author Javier Gonzalez Rives
 */

import java.io.BufferedReader;
import java.io.PrintWriter;

public class Cliente{
    private int id;
    private String nombre;
    private BufferedReader rd;
    private PrintWriter pw;
    

    public Cliente(int id, String nombre, BufferedReader bf, PrintWriter pw){
        super();
        this.id = id;
        this.nombre = nombre;
        this.rd = bf;
        this.pw = pw;
    }
    @Override
    public String toString(){
        return "cliente" + id;
    }
    // GETTERS SETTERS //////////////////////////////////////////////////////////////
    public int getId(){
        return id;
    }
    public void serId(int id){
        this.id = id;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public BufferedReader getRd(){
        return rd;
    }
    public void setRd(BufferedReader rd){
        this.rd = rd;
    }
    public PrintWriter getPw(){
        return this.pw;
    }
    public void setPw(PrintWriter pw){
        this.pw = pw;
    }
}