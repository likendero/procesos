/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejcardlayout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author paco
 */
public class Ventana extends JFrame{
    private Panel [] paneles;
    PanelBotones [] pb;
    JButton[][] misBotones;
    CardLayout cl;
    Control miControl;
    public Ventana(){
        iniciaComponentes();
    }
    //--------------------------------------------------------------------------
    public void iniciaComponentes(){
        
        paneles = new Panel[3];
        pb = new PanelBotones[3];
        misBotones = new JButton[3][4];
       for(int i=0; i<paneles.length; i++){
           pb[i]=new PanelBotones();
           paneles[i]=new Panel(pb[i], new PanelTexto("## PANEL: " + i +"  ##", new Color(100*i, 100+20*i, 50+60*i)));
           misBotones[i]=pb[i].getBotones();
        }
        Container lienzo=this.getContentPane();
        cl = new CardLayout();
        
        lienzo.setLayout(cl);
        for(int i=0; i<paneles.length; i++){
            lienzo.add(paneles[i], "panel"+i);
        }
        lienzo.setPreferredSize(new Dimension(400,300));
        miControl=new Control(this);
        for(int p=0; p<3; p++){
            for(int j=0; j<4; j++){
                misBotones[p][j].addActionListener(miControl);
            }
        }
         pack();
    }
    //--------------------------------------------------------------------------
    
}
    