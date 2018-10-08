/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo3;
import javax.swing.JPanel;
import javax.swing.JButton;
/**
 *
 * @author likendero
 */
public class PanelReset extends JPanel {
    private JButton btnReset;
    /**
     * constructor principal
     */
    public PanelReset(){
        super();
        inicio();
    }
    /**
     * metodo que inicializa los elementos del panel
     */
    public void inicio(){
        btnReset = new JButton("reset");
        this.add(btnReset);
    }
    /**
     * metodo que devuelve el boton reset
     * @return 
     */
    public JButton getBtnReset(){
        return btnReset;
    }
}
