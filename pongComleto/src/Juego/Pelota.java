/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 *  clase que define los parametros de la bola dentro 
 * del juego y aporta los parametros de accion y dibujado
 * @author Javier Gonzalez Rives
 */
public class Pelota  {
    private Juego juego;
    private int x,y,dx,dy;
    private final int CUADRADO = 60;
    private int toques;
    /**
     * metodo contructor de la pelota
     * @param juego en el que basa sus parametros
     * @param x posicion inicial de la pelota en x
     * @param y posicion inicial de la pelota en y
     */
    public Pelota(Juego juego,int x, int y){
        super();
        this.juego = juego;
        // definicion de la posicion
        this.x = x;
        this.y = y;
        this.toques = 0;
        // direccion de movimiento
        direccionAletatoria();
    }
    /**
     * metodo constructor de la pelota sin posicionamineto
     * @param juego objeto en que basa sus paramentros
     */
    public Pelota(Juego juego){
        super();
        this.juego = juego;
        // posicionamiento
        this.x = 0;
        this.y = 0;
        this.toques = 0;
        // direccion de movimiento
        direccionAletatoria();
    }
    /**
     * metodo que define de forma aleatora la direccion
     * a la que se mueve la bola
     */
    private void direccionAletatoria(){
        this.dy = 1 ;//(int)(Math.random()*(-1-1)+1);
        this.dx = 1 ; //(int)(Math.random()*(-1-1)+1);
    }
    /**
     * metodo que cambia la posicion de la vola y controla su posicion
     */
    public void movimiento(){
        // caso velocidad en el ejex
        if(x + dx < 0 || x + dx > juego.getWIDTH2()-60){
            // cambio de sentido horizontal
            dx = -dx;
            toques++;
            Sonido.SOUNDPELOTA.play();
        }
        // caso velocidad en el ejey
        if(y + dy < 0 ){
            // cambio de sentido vertical
            dy = -dy;
            toques++;
            Sonido.SOUNDPELOTA.play();
        }
        if(y + dy > juego.getHEIGHT2()-60){
            juego.setControl(false);
            juego.setDerrota(true);
        }
        // cambio en la posicion
        x += dx;
        y += dy;
    }
    /**
     * metodo que dibuaja la pelota
     * @param g2d 
     */
    public void dibujarPelota(Graphics2D g2d){
        // color azul
        g2d.setColor(new Color(229, 2, 212));
        g2d.fillOval(x, y, CUADRADO, CUADRADO);
    }
    /**
     * metodo que devuelve el rectangulo de la pelota
     * @return 
     */
    public void colision(Rectangle rectangulo2){
        Rectangle cajaPelota = new Rectangle(x,y,CUADRADO,CUADRADO);
        // comprobacion si las cajas de colsion se tocan
        if(cajaPelota.intersects(rectangulo2)){
            // cambio de sentido en caso de contacto
            dy = -dy;
            dx = -dx;
            toques++;
            Sonido.SOUNDPELOTA.play();
        }
        
    }
    // GETTERS SETTERS
    public int getToques() {
        return toques;
    }

    public void setToques(int toques) {
        this.toques = toques;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    
    
}
