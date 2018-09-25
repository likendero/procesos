/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo2;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author likendero
 */
public class PanelTitulo extends JPanel{
    private JLabel lbTitulo;
    public PanelTitulo(){
        inicio();
    }
    public void inicio(){
        lbTitulo = new JLabel("EJEMPLO PANELOIDES");
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        this.setLayout(fl);
        this.add(lbTitulo);
    }
}
