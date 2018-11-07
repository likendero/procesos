/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolaModular;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 *
 * @author likendero
 */
public class Bola {
    int x = 0,y = 0,dx = 1,dy = 1;
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
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(x, y, 30, 30);
    }
    /**
     * metodo que realiza la operacion de 
     * mover
     */
    public void mover(){
        // comprobacion coordenada x
        if((x + dx < 0) || (x + dx > 500-30)){
            dx = -dx;
        }
        // comprobacion coordenada y
        if((y + dy < 0) || (y + dy > 400-30)){
            dy = -dy;
        }
    }
}
