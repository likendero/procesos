/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.card;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author linuxdiurno
 */
public class PanelBotones extends JPanel {
    private JButton[] botones;
    /**
     * constructor para el panel botones
     */
    public PanelBotones(){
        super();
    }
    private void init(){
        botones = new JButton[4];
        // instancaicion de los botones
        botones[0] = new JButton("primero");
        botones[0] = new JButton("atras");
        botones[0] = new JButton("siguiente");
        botones[0] = new JButton("ultimo");
        // creacion de un nuevo flowLayout
        FlowLayout fl = new FlowLayout(10);
        
    }
    
}
