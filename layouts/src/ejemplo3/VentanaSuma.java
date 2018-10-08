/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo3;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author likendero
 */
public class VentanaSuma extends JFrame implements KeyListener{
    private PanelCalcular pCalcular;
    private PanelReset pReset;
    private PanelResultado pResultado;
    private PanelSolucionSalir pSolSal;
    private JButton btnReset,btnResultado;
    private JTextField txtNum1,txtNum2,txtResultado;
    /**
     * metodo principal
     */
    public VentanaSuma(){
        super("ventanuco");
        setBounds(100, 100, 400 , 400);
        inicio();
    }
    /**
     * inicializacion de los elementos
     */
    public void inicio(){
        // instanciacion de los paneles
        pCalcular = new PanelCalcular();
        pReset = new PanelReset();
        pSolSal = new PanelSolucionSalir();
        pResultado = new PanelResultado();
        // elementos que despues necesitaran funcionalidad
        btnReset = pReset.getBtnReset();
        btnResultado = pResultado.getBtnResultado();
        txtNum1 = pCalcular.getTxtNum1();
        txtNum2 = pCalcular.getTxtNum2();
        txtResultado = pSolSal.getTxtResultado();
        
        // nuevo border layout con separaciones
        BorderLayout bord = new BorderLayout(5,5);
        
        // Annadiendo paneles a la ventana
        // panel de la izquierda que resetea
        this.add(pReset, bord.LINE_START);
        // panel de la derecha soluciona
        this.add(pResultado, bord.LINE_END);
        // el panel central se introducen los datos
        this.add(pCalcular, bord.CENTER);
        // panel de abajo con boton salir y muestra el resultado
        this.add(pSolSal, bord.PAGE_END);
        
        txtNum1.addKeyListener(this);
        txtNum2.addKeyListener(this);
        btnReset.addActionListener(e->reset());
        btnResultado.addActionListener(e->resultado());
    }
    private void resultado(){
        String s1 = txtNum1.getText();
        String s2 = txtNum2.getText();
        if(s1.length() > 0 && s2.length() > 0){
            txtResultado.setText("" + (Integer.parseInt(s1) + Integer.parseInt(s2)));
        }
        
    }
    private void reset(){
        txtNum1.setText("");
        txtNum2.setText("");
    }
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource() == txtNum1 || e.getSource() == txtNum2){
            char c = e.getKeyChar();
            if(c<'0' || c>'9'){
                e.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
