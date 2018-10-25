/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardejercicio;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author likendero
 */
public class Paneluco extends JPanel {
    private JLabel lbActual;
    /**
     * metodo constructor que crea el panel con un color de fondo
     * y un texto
     */
    public Paneluco(String texto,Color color){
        super();
        init();
        // valores
        lbActual = new JLabel(texto);
        lbActual.setAlignmentY(JLabel.CENTER_ALIGNMENT);
        // cambio del fondo
        setBackground(color);
        // add
        add(lbActual,BorderLayout.CENTER);
    }
    /**
     * metodo que incializa los elementos del panel
     */
    private void init(){
        // creacion del layout
        BorderLayout ly = new BorderLayout();
        setLayout(ly);
        
    }
    
    
}
