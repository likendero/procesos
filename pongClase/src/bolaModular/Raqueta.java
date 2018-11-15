package bolaModular;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/**
 * clase que crea un rectangulo a modo de 
 * requeta que se mantiene fijo en el eje y
 * y se mueve con las teclas el eje x
 * @author Javier Gonzalez Rives
 */
public class Raqueta {
    private int x,dx;
    private final int width = 60 ,height = 15;
    private final int y = 300;
    /**
     *  constructor de la raqueta
     */
    public Raqueta(){
        super();
        init();
    }
    /**
     * metodo que inicializa los valores de
     * la raqueta
     */
    private void init(){
        x = 150;
        dx=0;
    }
    /**
     * metodo que mueve la raqueta
     */
    public void moverRaqueta(){
        // comprobacion que no se va de bareta la raqueta
        if(x + dx > 0  && x + dx < 400-60){
            // cambio de la posicion
            x += dx;
        }
    }
    public void pintarRaqueta(Graphics2D g2d){
        g2d.fillRect(x, y, width, height);
    }
    /**
     * metodo que modifica el valor de dx
     * para movimiento a la izquierda 
     */
    public void accionIzquierda(){
        dx = -2;
    }
    /**
     * metodo que modifica el valor de 
     * dx para movimiento a la derecha
     */
    public void accionDerecha(){
        dx = 2;
    }
    /**
     * metodo que detiene el movimiento
     */
    public void sinAccion(){
        dx=0;
    }
}
