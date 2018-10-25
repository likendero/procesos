/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardejercicio;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *  clase que crea una ventana con un card layout
 *  en esta se podra cambiar entre uno y otro pulsando 
 *  en las teclas izquierda y derecha
 * @author likendero
 */
public class Ventanuco extends JFrame {
    private Paneluco panel[];
    private CardLayout card;
    
    /**
     * metodo constructor de la ventana
     */
    public Ventanuco(){
        super();
        // tamanno
        setBounds(100, 100, 400, 400);
        // cerrado
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
    }
    /**
     * metodo que inicaliza los elementos de la 
     * ventana
     */
    private void init(){
        panel = new Paneluco[4];
        // bucle que isntancia los paneles 
        for(int i = 0; i < panel.length; i++) {
            panel[i] = new Paneluco("panel " + i ,generateColor());
        }
        // creacion del Card layout
        card = new CardLayout();
        // defincion del layout
        setLayout(card);
        // annadir controlador a la ventana
        Controlador control = new Controlador(getContentPane(), card);
        // anndair el Key lsitener
        addKeyListener(control);
        // annadir paneles a la ventana
        for(int i = 0; i < panel.length; i++){
            // annadir panel de 1 en 1
            add(panel[i]);
        }
    }
    /**
     * metodo que genera de forma aleatoria
     * un color
     * @return Color generado aleatoriamente
     */
    private Color generateColor(){
        int rgb[] = new int[3];
        // bucle que genera los tres numeros de color aleatoriamente
        for(int i = 0; i < rgb.length;i++){
            // se genera un numero entre 0 y 255
            rgb[i] = (int)(Math.random()*256);
        }
        Color color = new Color(rgb[0], rgb[1], rgb[2]);
        return color;
    }
}
