/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reloj;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author paco
 */
public class Hilo implements Runnable {
    JTextField txt;
    Semaforo testigo;
    public Hilo(JTextField t, Semaforo f){
        txt=t;
        testigo=f;
        
    }

    @Override
    public void run() {
        String tiempo="";
        int cent=0;
        int seg=0;
        int min=0;
        String scent="00";
        String sseg="00";
        String smin="00";
        while(true){
            while(testigo.isPausado()){
               txt.setText("");
               parar(500);
               txt.setText(tiempo);
               parar(500);
            }
            parar((long)10);
            
            cent++;
            if(cent<10){
                scent="0"+cent;
            }
            if(cent>=10 && cent <99){
                scent=""+cent;
            }
            if(cent==100){
                cent=0;
                seg++;
            }
            if(seg<10){
                sseg="0"+seg;
            }
            if(seg>=10 && seg<60){
                sseg=""+seg;
            }
            if(seg==60){
                seg=0;
                min++;
            }
            if(min<10){
                smin="0"+min;
            }
            if(min>=10){
               smin=""+min; 
            }
            tiempo=smin+":"+sseg+":"+scent;
            txt.setText(tiempo);
           // System.out.println(tiempo);
            
        }
    }
    //--------------------------------------------------------------------------
    public void parar(long t){
        try {  
                sleep(t);
        } catch (InterruptedException ex) {}
    }
    //-------------------------------------------------------------------------
}
