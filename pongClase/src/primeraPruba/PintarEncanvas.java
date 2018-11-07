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
import javax.swing.JFrame;

/**
 *
 * @author likendero
 */
public class PintarEncanvas extends Canvas {

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // instanciacion del objeto grafics 2d
        Graphics2D g2d = (Graphics2D)g;
        
        // cambio de color
        g2d.setColor(Color.MAGENTA);
        // pinar un circulo
        g2d.fillOval(50, 50, 60, 60);
        g2d.drawOval(120, 50, 90, 90);
        // pintar cuadradinnos
        g2d.fillRect(300, 300, 100, 100);
    }
    /**
     * metodo principal
     * @param args 
     */
    public static void main(String[] args) {
        JFrame ven = new JFrame();
        ven.setSize(500, 500);
        ven.add(new PintarEncanvas());
        ven.setVisible(true);
        ven.setResizable(false);
        ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
