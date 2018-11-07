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
public class pintarMovimiento extends Canvas {
    private int x = 0,y = 0;
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
        ven.setSize(500, 500);
        pintarMovimiento mov = new pintarMovimiento();
        ven.add(mov);
        ven.setVisible(true);
        ven.setResizable(false);
        ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while(true){
            mov.mover();
            mov.repaint();
            Thread.sleep(10);
            
        }
        
    }
    
    ////////////////
    /**
     * 
     */
    private 
         void mover(){
        x++;
        y++;
    }
}
