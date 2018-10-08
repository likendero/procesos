/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo3;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author likendero
 */
public class PanelResultado extends JPanel {
    private JButton btnResultado;
    /**
     * metodo constructor
     */
    public PanelResultado(){
        super();
        inicio();
    }
    /**
     * metodo que inicializa los elementos del JPanel
     */
    public void inicio(){
        btnResultado = new JButton("resultado");
        add(btnResultado);
    }
    /**
     * devuelve el metodo
     * @return 
     */
    public JButton getBtnResultado(){
        return btnResultado;
                
    }
}
