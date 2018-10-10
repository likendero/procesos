/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejcardlayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author paco
 */
public class Control implements ActionListener {
    Ventana miVentana;
    public Control(Ventana v){
        miVentana=v;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<3; i++){
            for (int j=0; j<4; j++){
                if(e.getSource()==miVentana.misBotones[i][j]){
                    switch (j){
                        case 0:
                            miVentana.cl.show(miVentana.getContentPane(), "panel0");
                            break;
                        case 1:
                            miVentana.cl.previous(miVentana.getContentPane());
                            break;
                        case 2:
                            miVentana.cl.next(miVentana.getContentPane());
                            break;
                        default :
                            miVentana.cl.show(miVentana.getContentPane(), "panel2");
                    }
                }
            }
        }
    
    }
    //------------------------------------------------------------------------
}
