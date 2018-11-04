/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reloj;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author paco
 */
public class Control implements ActionListener {
    Ventana mv;
    Thread t;
    public Control(Ventana v){
        mv=v;
        t = new Thread(mv.hilo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==mv.bt3){
            System.exit(0);
        }
        else if(e.getSource()==mv.bt1){
            mv.bt1.setEnabled(false);
            mv.bt2.setEnabled(true);
            mv.testigo.setPausado(false);
            if(!t.isAlive()) t.start();
        }
        else{
            mv.bt1.setEnabled(true);
            mv.bt2.setEnabled(false);
            mv.testigo.setPausado(true);
            
        }
    }
    
}
