/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardejercicio;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author likendero
 */
public class Controlador implements KeyListener {
    private Container cont;
    private CardLayout card;
    /**
     * metodo constructor del controlador
     * @param contenedor de la ventana que se quiere controlar
     * @param card layout que se quiere manejar
     */
    public Controlador(Container contenedor, CardLayout card){
        super();
        // card layout para controlar el panel visible
        this.card = card;
        // container para controlar el contenedor
        this.cont = contenedor;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // deteccion flecha hacia arriba primera posicion
        if(e.getKeyCode() == KeyEvent.VK_UP){
            card.first(cont);
        }
        // tecla abajo ultiam posicion
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            card.last(cont);
        }
        // tecla derecha siguiente
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            card.next(cont);
        }
        // flecha izquierda anterior
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            card.previous(cont);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
       
    }
    
}
