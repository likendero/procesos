/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.card;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *  
 * @author linuxdiurno
 */
public class PanelTexto extends JPanel {
    private JTextField texto;
    private Color color;
    /**
     * metodo constructor
     */
    public PanelTexto(String texto, Color color){
        super();
        setBackground(color);
        init();
        this.texto.setText(texto);
    }
    /**
     * metodo que incicializa todos los componentes del panel
     */
    private void init(){
        // inicializacion del campo de texto
        texto = new JTextField();
        // configuracion del recuadro
        texto.setSize(100, 40);
        texto.setFont(new Font("Arial", Font.ITALIC, 20));
        texto.setBackground(Color.BLACK);
        // add
        add(texto);
    }
}
