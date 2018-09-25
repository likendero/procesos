/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author likendero
 */
public class ventana2 extends JFrame{
    private panelBotones pb;
    private panelTexto pt;
    private PanelTitulo ptit;
    private JButton btnSalir;
    private JTextField mensaje;
    
    public ventana2(){
        
    }
    public void inicio(){
        pb = new panelBotones();
        pt = new panelTexto();
        ptit = new PanelTitulo();
        btnSalir = pb.getBtnSaludar();
        mensaje = pt.getTxtTexto();
    }
}
