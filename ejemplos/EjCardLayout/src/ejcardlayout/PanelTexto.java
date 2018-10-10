/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejcardlayout;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author paco
 */
public class PanelTexto extends JPanel{
    private JTextField cajaTexto;
    private String s;
    public PanelTexto(String s, Color c){
        iniciaComponentes(s, c);
    }
    public void iniciaComponentes(String s, Color c){
        cajaTexto=new JTextField(15);
        cajaTexto.setMaximumSize(new Dimension(150,50));
        cajaTexto.setText(s);
        cajaTexto.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
        cajaTexto.setHorizontalAlignment(JTextField.CENTER);
        cajaTexto.setEditable(false);
        cajaTexto.setBackground(Color.black);
        cajaTexto.setForeground(Color.green);
        this.setPreferredSize(new Dimension(400,80));
        this.add(cajaTexto);
        this.setBackground(c);
        
    }   
    //-------------------------------------------------------------------------

    public JTextField getCajaTexto() {
        return cajaTexto;
    }
    
    
}
