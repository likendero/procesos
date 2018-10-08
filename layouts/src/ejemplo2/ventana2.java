/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author likendero
 */
public class ventana2 extends JFrame{
    // instanciacion de las variables de clase (los elementos de la ventana)
    private panelBotones pb;
    private panelTexto pt;
    private PanelTitulo ptit;
    private JButton btnSaludo;
    private JTextField mensaje;
    
    public ventana2(){
        super();
        inicio();
    }
    public void inicio(){
        pb = new panelBotones();
        pt = new panelTexto();
        ptit = new PanelTitulo();
        btnSaludo = pb.getBtnSaludar();
        mensaje = pt.getTxtTexto();
        // creo un contenedor salido de la ventana
        Container lienzo = this.getContentPane();
        // creaciom de un layout con espacios
        BorderLayout bl = new BorderLayout(5, 5);
        // cambio de layout
        lienzo.setLayout(bl);
        // annado todos los elementos
        lienzo.add(ptit, BorderLayout.PAGE_START);
        lienzo.add(pt, BorderLayout.CENTER);
        lienzo.add(pb, BorderLayout.PAGE_END);
        lienzo.setPreferredSize(new Dimension(450, 200));
        btnSaludo.addActionListener(e->saludo());
        pack();
    }
    /**
     * coge el texto y despues saluda
     */
    public void saludo(){
        try{
            String text = mensaje.getText().trim();
            if(text.length() > 0){
                JOptionPane.showMessageDialog(this, "hola " + mensaje.getText());
            }else{
                JOptionPane.showMessageDialog(this, "escribe algo por favor");
            }
        }catch(Exception ex){
            System.out.println("error");
        }
    }
}
