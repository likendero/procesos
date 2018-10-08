/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaConBotones;

import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author likendero
 */
public class PanelDerecho extends JPanel {
    private JTextArea txtIntro;
    /**
     * metodo constructor principal
     */
    public PanelDerecho(){
        super();
        init();
    }
    /**
     * metodo que inicializa el cuadro de texto
     */
    private void init(){
        // instanciacion del cuadro 20filas 50 columnas
        txtIntro = new JTextArea(20,50);
        // annadir el texto
        add(txtIntro);
    }
    /**
     * metodo que devueleve el cuadro de texto
     * @return 
     */
    public JTextArea getTxtIntro(){
        return txtIntro;
    }
}
