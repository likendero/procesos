/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reloj;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author paco
 */
public class Ventana extends JFrame {
    Semaforo testigo;
    PanelReloj pr;
    Panel1 p1;
    Panel2 p2;
    JTextField txt;
    JButton bt1, bt2, bt3;
    Control mc;
    Hilo hilo;
    public Ventana(){
        iniciaComponentes();
    }
    //--------------------------------------------------------------------------
    public void iniciaComponentes(){
        testigo=new Semaforo(true);
        p1=new Panel1();
        p2=new Panel2();
        pr=new PanelReloj(p1, p2);
        txt=p1.getPantalla();
        hilo = new Hilo(txt,testigo); 
        bt1=p2.getBtnStart();
        bt2=p2.getBtnStop();
        bt3=p2.getBtnSalir();
        bt2.setEnabled(false);
        Container lienzo=this.getContentPane();
        lienzo.add(pr);
        pack();
        mc=new Control(this);
        bt1.addActionListener(mc);
        bt2.addActionListener(mc);
        bt3.addActionListener(mc);
    }
    
}
