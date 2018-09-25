/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo2;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author likendero
 */
public class panelTexto extends JPanel {
    private JTextField txtTexto;
    public panelTexto(){
        inicio();
    }
    public void inicio(){
        txtTexto = new JTextField("EJEMPLO PANELOIDES");
        FlowLayout fl = new FlowLayout(FlowLayout.CENTER);
        this.setLayout(fl);
        this.add(txtTexto);
        
    }
    /**
     * guecito
     * @return 
     */
    public JTextField getTxtTexto() {
        return txtTexto;
    }
}
