/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reloj;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author paco
 */
public class Panel2 extends JPanel {
    JButton btnStart, btnStop, btnSalir;
    public Panel2(){
        iniciaComponentes();
    }
    public void iniciaComponentes(){
        btnStart=new JButton("START");
        btnStop=new JButton("STOP");
        btnSalir=new JButton("SALIR");
        btnStart.setPreferredSize(new Dimension(120,50));
        btnStop.setPreferredSize(new Dimension(120,50));
        btnSalir.setPreferredSize(new Dimension(120,50));
        FlowLayout fl=new FlowLayout(5);
        this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        this.setMaximumSize(new Dimension(400, 80));
        this.setLayout(fl);
        this.add(Box.createGlue());
        this.add(btnStart);
        this.add(btnStop);
        this.add(btnSalir);
        this.add(Box.createGlue());
        
        
    }
    //--------------------------------------------------------------------------

    public JButton getBtnStart() {
        return btnStart;
    }

    public JButton getBtnStop() {
        return btnStop;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }
    
    
}
