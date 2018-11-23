/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolaModular;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

/**
 *
 * @author likendero
 */
public class Juego extends Canvas implements Runnable, KeyListener{
    private Semaforo semaforo;
    private Bola bola/*,bola2,bola3,bola4*/;
    private Raqueta raqueta;
    private Dimension dim;
    private Image imaux;
    private Graphics gaux;
    private long segundos;
    private long tiempoJuego;
    /**
     * metodo constructor del juego
     */
    public Juego (Dimension dim){
       bola = new Bola(this);
       raqueta = new Raqueta();
       this.setFocusable(true);
       this.addKeyListener(this);
       this.semaforo = new Semaforo();
       // control del tiempo
       this.segundos = 0;
       this.tiempoJuego = System.currentTimeMillis();
       /*bola2 = new Bola(this);
       bola3 = new Bola(this);
       bola4 = new Bola(this);
       */
       
       // cambio de valores
       /*bola2.modificarParametros(100, 200, -1, 1);
       bola3.modificarParametros(100, 200, 1, -1);
       bola4.modificarParametros(100, 200, -1, -1);
       */
       // dimension
       this.dim  = dim;
    }
    /**
     * mover las bolas
     */
    private void mover(){
        bola.mover();
        raqueta.moverRaqueta();
       /* bola2.mover();
        bola3.mover();
        bola4.mover();
        */
    }
    @Override
    public void paint(Graphics g) {
        update(g);
    }

    @Override
    public void update(Graphics g) {
        if(gaux == null && imaux == null){
            imaux = createImage(dim.width,dim.height);
            gaux = imaux.getGraphics();
        }
        super.paint(gaux); 
        Graphics2D g2d = (Graphics2D)gaux;
        // bola que se mueve
        bola.paint(g2d);
        raqueta.pintarRaqueta(g2d);
        /*bola2.paint(g2d);
        bola3.paint(g2d);
        bola4.paint(g2d);*/
        g.drawImage(imaux, 0, 0, this);
    }

    @Override
    public void run() {
        while(semaforo.isEstado()){
            // movimiento de la bola
            mover();
            // repintado de la pantalla
            repaint();
            // comprobacion del estado de la bola
            comprobarBola();
            try{
                Thread.sleep(10);
            }catch(InterruptedException in){
                System.out.println("error");
            }
            this.segundos = (System.currentTimeMillis()-tiempoJuego)/1000;
            System.out.println("SEGUNDOS: " + segundos);
            if(this.segundos == 10){ 
                // reseteo de los segundos
                this.segundos = 0;
                //reseteo de la referencia de tiempo
                tiempoJuego = System.currentTimeMillis();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            raqueta.accionDerecha();
        }else
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            raqueta.accionIzquierda();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        raqueta.sinAccion();
    }
    
    /**
     * metodo que comprueba la posicion de la bola
     */
    private void comprobarBola(){
        if(this.bola.getY() == 500-65){
            Sonido.SOUNDGAMEOVER.play();
            JOptionPane.showMessageDialog(null,"fin del juego","fin",JOptionPane.INFORMATION_MESSAGE);
            semaforo.setEstado(false);
        }
    }
    // GETTERS SETTERS
    public Raqueta getRaqueta() {
        return raqueta;
    }
    
    public void setRaqueta(Raqueta raqueta) {
        this.raqueta = raqueta;
    }

    public long getSegundos() {
        return segundos;
    }

    public void setSegundos(long segundos) {
        this.segundos = segundos;
    }
    
    
    
}
