/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaConBotones;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author likendero
 */
public class Ventana extends JFrame {
    PanelDerecho pD;
    PanelIzquierdo pI;
    JTextArea txtIntro;
    /**
     * metodo constructor de la ventana
     */
    public Ventana(String titulo){
        super(titulo);
        setBounds(100, 100, 820, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
    }
    
    private void init(){
        pI = new PanelIzquierdo();
        pD = new PanelDerecho();
        // instanciacion de los botones que necesitan funcionalidad
        txtIntro = pD.getTxtIntro();
        JButton btnA = pI.getBtnA();
        JButton btnS = pI.getBtnS();
        // annadir paneles
        add(pI,BorderLayout.LINE_START);
        add(pD,BorderLayout.LINE_END);
        
        // anndir funcionalidades
        btnA.addActionListener(e->quitarA());
        btnS.addActionListener(e->quitarS());
    }
    /**
     * metodo que borra todos los caracteres A o a del cuadro de texto
     */
    private void quitarA(){
        if(txtIntro.getText().length() > 0){
            // combertir en array de caracteres la cadena original
            char[] caracteres = txtIntro.getText().trim().toCharArray();
            String aux = new String();
            // recorrido para copmprobar caracteres
            for(int i = 0; i < caracteres.length; i++){
                // comprobacion de si el caracter es A
                if(caracteres[i] != 'a' && caracteres[i] != 'A'){
                    aux += caracteres[i];
                }
            // cambio del cuadro de texto
            txtIntro.setText(aux);
            }
        }else{
            // si el cuadro esta bacio se escriube un mensaje
            JOptionPane.showMessageDialog(this, "escribe algo en el cuadro de texto", "escribe", JOptionPane.ERROR_MESSAGE);
            
        }
    }
    /**
     * metodo que quita los caracteres s o S del cuadro de texto
     */
    private void quitarS(){
    if(txtIntro.getText().length() > 0){
            // combertir en array de caracteres la cadena original
            char[] caracteres = txtIntro.getText().trim().toCharArray();
            String aux = new String();
            // recorrido para copmprobar caracteres
            for(int i = 0; i < caracteres.length; i++){
                // comprobacion de si el caracter es A
                if(caracteres[i] != 's' && caracteres[i] != 'S'){
                    aux += caracteres[i];
                }
            // cambio del cuadro de texto
            txtIntro.setText(aux);
            }
        }else{
            // si el cuadro esta bacio se escriube un mensaje
            JOptionPane.showMessageDialog(this, "escribe algo en el cuadro de texto", "escribe", JOptionPane.ERROR_MESSAGE);
            
        }
    }
}
