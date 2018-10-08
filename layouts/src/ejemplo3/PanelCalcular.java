/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo3;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 *  
 * @author likendero
 */
public class PanelCalcular extends JPanel {
    // variables
    private JLabel lbSuma;
    private JTextField txtNum1,txtNum2;
    
    public PanelCalcular(){
        super();
        inicio();
    }
    public void inicio(){
        lbSuma = new JLabel("+");
        txtNum1 = new JTextField(10);
        txtNum2 = new JTextField(10);
        // tamanno lbsuma
        lbSuma.setFont(new Font("liberation mono", Font.BOLD,20));
        // annadir elementos
        
        add(txtNum1);
        add(lbSuma);
        add(txtNum2);
        
        
    }
    /**
     * devuelve txtNum1
     */
    public JTextField getTxtNum1(){
        return txtNum1;
    }
    /**
     * devuelve txtNum2
     * @return 
     */
    public JTextField getTxtNum2(){
        return txtNum2;
    }
}
