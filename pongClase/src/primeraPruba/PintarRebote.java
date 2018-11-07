/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primeraPruba;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;

/**
 *
 * @author likendero
 */
public class PintarRebote extends Canvas {
    private int x = 0,y = 0;
    private int dx = 1, dy = 1;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // instanciacion del objeto grafics 2d
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // cambio de color
        g2d.setColor(Color.MAGENTA);
        // pinar un circulo
        g2d.fillOval(x, y, 60, 60);
       
    }
    /**
     * metodo principal
     * @param args 
     */
    public static void main(String[] args) throws InterruptedException {
        JFrame ven = new JFrame();
        ven.setSize(400, 500);
        PintarRebote mov = new PintarRebote();
        ven.add(mov);
        ven.setVisible(true);
        ven.setResizable(false);
        ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while(true){
            mov.mover();
            mov.repaint();
            Thread.sleep(1);
            
        }
        
    }
    
    ////////////////
    /**
     * 
     */
    private void mover(){
        // caso de la x
        if(x > 340){
            dx = -1;
        }else if(x < 0){
            dx = 1;
        }
        // caso de la y
        if(y > 410){
            dy = -1;
        }else if(y < 0){
            dy = 1;
        }
        // operacion
        x = x + dx;
        y = y + dy;
    }
}
