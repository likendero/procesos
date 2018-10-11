package animacion;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.lang.Thread;

import javax.swing.JPanel;

public class PanelPintar extends JPanel implements Runnable{
    private int posX,posY;
    /**
     * metodo constructor
     */
    public PanelPintar(){
        super();
        init();
    }
    /**
     * metodo que incicaliza las variables
     */
    public void init(){
        posX = 25;
        posY = 25;
    }
    @Override
    public void run() {
        // bucle que mantiene la animacion
        while(true){
            animacion();
            super.repaint();
        }
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        Ellipse2D elip = new Ellipse2D.Double(posX,posY,50,50);
        g2d.fill(elip);
        g2d.draw(elip);
    }
    // metodo que realiza las operaciones de la animacion
    private void animacion(){
        try{
            // se hace una pausa de medio segundo
            Thread.sleep(100);
            // se comprueba la posicion actual
            if(posX < 375){
                // se muebe el elemento en 5
                posX += 5;
            }
            else{
                // una vez que llega al final se vuelve al principio
                posX = 25;
            }
        }catch(InterruptedException it){
            it.printStackTrace();
        }
    }

}