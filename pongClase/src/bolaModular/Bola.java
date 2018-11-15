/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolaModular;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


/**
 *
 * @author likendero
 */
public class Bola {
    private int x = 0,y = 0,dx = 1,dy = 1;
    private Juego juego;
    /**
     * metodo constructor de la 
     * bola
     */
    public Bola(Juego juego){
        this.juego = juego;
    }
    /**
     * metodo que pinta la bola
     * @param g2d 
     */
    public void paint(Graphics2D g2d){
        g2d.setColor(Color.PINK);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(x, y, 30, 30);
    }
    /**
     * metodo que realiza la operacion de 
     * mover
     */
    public void mover(){
        // comprobacion coordenada x
        if((x + dx < 0) || (x + dx > 400-30)){
            dx = -dx;
        }
        // comprobacion coordenada y
        if((y + dy < 0) || (y + dy > 500-60)){
            dy = -dy;
        }
        x += dx;
        y += dy;
    }
    /**
     * metodo para modificar los parametros de la bola
     * @param x
     * @param y
     * @param dx
     * @param dy 
     */
    public void modificarParametros(int x, int y , int dx , int dy){
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }
    // getters setters
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
