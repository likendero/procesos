/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo3;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author likendero
 */
public class PanelSolucionSalir extends JPanel {
    private JLabel lbResultado;
    private JTextField txtResultado;
    private JButton btnSalir;
    public PanelSolucionSalir(){
        super();
        inicio();
    }
    /**
     * metodo que inicia todos los elementos del panel
     */
    public void inicio(){
        // instanciacion de las variables
        lbResultado = new JLabel("el resultado es: ");
        txtResultado = new JTextField(20);
        btnSalir = new JButton("salir");
        txtResultado.setEditable(false);
        // annadir elementos
        this.add(lbResultado);
        this.add(txtResultado);
        this.add(btnSalir);
        // evento salir
        btnSalir.addActionListener(e->salir());
    }
    /**
     * metodo que cierra el porgrama
     */
    public void salir(){
        System.exit(0);
    }
    /**
     * metodo que devuelve la caja de texto 
     * @return 
     */
    public JTextField getTxtResultado(){
        return txtResultado;
    }
}
