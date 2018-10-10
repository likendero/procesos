/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejcardlayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 *
 * @author paco
 */
public class PanelBotones extends JPanel {
    JButton [] botones;
    public PanelBotones(){
        iniciaComponentes();
    }
    //--------------------------------------------------------------------------
    public void iniciaComponentes(){
        botones=new JButton[4];
        botones[0]=new JButton("Primero");
        botones[3]=new JButton("Ultimo");
        botones[2]=new JButton("Siguiente");
        botones[1]=new JButton("Previo");
        FlowLayout fl = new FlowLayout(10);
        this.setLayout(fl);
        this.setBorder(BorderFactory.createTitledBorder("Panel Botones"));
        this.setPreferredSize(new Dimension(400,100));
        this.add(Box.createGlue());
        for(int i=0; i<4; i++){
            this.add(botones[i]);
        }
        this.add(Box.createGlue());
    }
    //--------------------------------------------------------------------------
    public JButton [] getBotones() {
        return botones;
    }

    
}
