/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.relog;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author linuxdiurno
 */
public class PanelRelog extends JPanel implements Runnable {
    private JTextField relog;
    private int segundos,minutos;
    /**
     * metodo constructor principal para el panel del
     * relog, inicializa un panel con un cuadro de texto
     * que al icluir en un ilo ira contando
     */
    public PanelRelog(){
        super();
    }
    public void init(){
        relog = new JTextField(20);
        segundos = 0;
        minutos = 0 ;
        // boton panel
        relog.setBackground(Color.BLACK);
        relog.setForeground(Color.YELLOW);
    }

    @Override
    public void run() {
        while(true){
            wait();
            incrementar();
            setNuevoTiempo();
        }
    }
    /**
     * metodo que incrementa en 1 segundo el tiempo
     */
    public void incrementar(){
        if(segundos < 60){
            segundos++;
        }
        else if(minutos < 99){
            segundos = 0;
            minutos++;
        }else{
            minutos = 0;
            segundos = 0;
        }
    }
    /**
     * metodo que detiene un segundo el hilo
     */
    public void wait(){
        try{
            Thread.sleep(1000);
        }catch(InterruptedException in){
            System.out.println("error interrupcion");
        }
    }
    /**
     * metodo que cambia el valor del relog 
     */
    public void setNuevoTiempo(){
        this.relog.setText("" + minutos + ":" + segundos);
    }
}
