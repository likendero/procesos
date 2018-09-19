/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.PageAttributes;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * ejemplo de creacion de ventana
 * @date 19-7-2018
 * @author likendero
 */
public class Ventana extends JFrame {
    private JButton btnSalir, btnSaludo;
    private JTextField txtSaludo;
    private JLabel lbSuo, lbInf;
    /**
     * construcotor principal
     *
     * @param titulo 
     */
    public Ventana(String titulo){
        super(titulo);
        iniciaComponente();
    }
    /**
     * metodo que inicia los componentes
     */
    public void iniciaComponente(){
        btnSalir = new JButton("SALIR");
        btnSaludo = new JButton("SALUDO");
        // txt
        txtSaludo = new JTextField();
        // etiquetas
        lbInf = new JLabel("encabezado de mi ventana");
        lbSuo = new JLabel("pie de mi ventana");
        
        // cambio colores botones
        btnSaludo.setBackground(Color.BLUE);
        btnSalir.setBackground(Color.red);
        // cambiar colores etiquetas
        
        lbInf.setBackground(Color.BLACK);
        lbInf.setForeground(Color.GREEN);
        
        // colocacion de los componentes
        Container lienzo = this.getContentPane();
        // definicion del tamanno de la ventana
        lienzo.setPreferredSize(new Dimension(400,200));
        // texto
        lienzo.add(lbSuo,BorderLayout.PAGE_END);
        lienzo.add(lbInf,BorderLayout.PAGE_START);
        // botones
        lienzo.add(btnSalir,BorderLayout.LINE_END);
        lienzo.add(btnSaludo,BorderLayout.LINE_START);
        
        // texto
        lienzo.add(txtSaludo,BorderLayout.CENTER);
        
        // introduccion de acciones en los botones
        
        btnSalir.addActionListener(e-> salir());
        btnSaludo.addActionListener(e-> saludo());
    }
    /**
     * metodo que cierra el programa
     */
    public void salir(){
        // salida del programa correcta
        System.exit(0);
    }
    /**
     * metodo que envia un mensaje de saludo
     */
    public void saludo(){
        // comprobacion si hay texto
        if(txtSaludo.getText().trim().length()== 0){
            JOptionPane.showMessageDialog(this, "no hay texto");
        }else{
            String salida = "hola " + txtSaludo.getText();
            JOptionPane.showMessageDialog(this, salida);
        }
    }
}
