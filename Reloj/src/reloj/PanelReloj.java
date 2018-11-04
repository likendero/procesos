/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reloj;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author paco
 */
public class PanelReloj extends JPanel {
    Panel1 p1;
    Panel2 p2;
    public PanelReloj(Panel1 p, Panel2 q){
        p1=p;
        p2=q;
        iniciaComponentes();
    }
    //--------------------------------------------------------------------------
    public void iniciaComponentes(){
        BoxLayout bl = new BoxLayout(this, BoxLayout.PAGE_AXIS);
        this.setLayout(bl);
        this.setPreferredSize(new Dimension(400, 280));
        this.setMaximumSize(new Dimension(400, 280));
        p1.setAlignmentX((float)0.5);
        p2.setAlignmentX((float)0.5);
        this.add(p1);
        this.add(p2);
    }
    //---------------------------
}
