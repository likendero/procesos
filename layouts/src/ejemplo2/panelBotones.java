/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author likendero
 */
public class panelBotones extends JPanel {
    private JButton btnSalir, btnSaludo;
    public panelBotones(){
        inicio();
    }
    public void inicio(){
        btnSalir = new JButton("salir");
        btnSaludo = new JButton("saludo");
        
        // colores
        btnSalir.setBackground(Color.BLUE);
        btnSaludo.setBackground(Color.red);
        btnSaludo.setForeground(Color.BLUE);
        btnSalir.setPreferredSize(new Dimension(100,60));
        btnSaludo.setPreferredSize(new Dimension(100,60));
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        // le asignamos el layout a nuestro panel
        this.setLayout(fl);
        this.add(btnSaludo);
        this.add(btnSalir);
        
        // listeners
        btnSalir.addActionListener(e->salir());
    }
    /**
     * metodo qeu saca el boton 
     * @return 
     */
    public JButton getBtnSaludar(){
        return btnSaludo;
    }
    /**
     * meto que finaliza el programa
     */
    private void salir(){
        System.exit(0);
    }
}
