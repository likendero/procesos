/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejcardlayout;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

/**
 *
 * @author paco
 */
public class Panel extends JPanel {
    private PanelBotones pb1;
    private PanelTexto pt1;
   
    
    public Panel(PanelBotones p1, PanelTexto t1){
        pb1=p1;
        pt1=t1;
        
        iniciaComponentes();
    }
    //--------------------------------------------------------------------------
    public void iniciaComponentes(){
        
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        BoxLayout bl = new BoxLayout(this,BoxLayout.PAGE_AXIS);
        this.setLayout(bl);
        this.setPreferredSize(new Dimension(400,180));
        pb1.setAlignmentX((float)0.5);
        pt1.setAlignmentX((float)0.5);
        this.add(pt1);
        this.add(pb1);
        
        
    }
    //--------------------------------------------------------------------------

    public PanelBotones getPb1() {
        return pb1;
    }

    public PanelTexto getPt1() {
        return pt1;
    }

   
    
   
    
}
