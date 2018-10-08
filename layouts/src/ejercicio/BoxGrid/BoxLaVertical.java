/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.BoxGrid;

import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author linuxdiurno
 */
public class BoxLaVertical {
    public static void mostrar(){
        VentanaVertical ven = new VentanaVertical();
        ven.setVisible(true);
        ven.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * metodo principal
     * @param args 
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                mostrar();
            }
        });
    }
}
/**
 * ventana
 * @author linuxdiurno
 */
class VentanaVertical extends JFrame{
    private PanelVertical panel;
    public VentanaVertical()  {
        super("ventana vertical");
        setBounds(100,100,400,400);
        init();
    }
    /**
     * metodo que inicializa los elementos de la ventana
     */
    public void init(){
        panel = new PanelVertical();
        add(panel);
    }
}
/**
 * panel con box layout vertical centrado
 * @author linuxdiurno
 */
class PanelVertical extends JPanel implements ActionListener{
    private JButton uno,dos,tres,cuatro;
    public PanelVertical(){
        super();
        init();
    }
    /**
     * metodo que incializa los elementos del panel
     */
    private void init(){
        // creacion del boxlayout
        BoxLayout la = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(la);
        // instanciacion elementos
        uno = new JButton("boton 1");
        dos = new JButton("boton 2");
        tres = new JButton("boton 3");
        cuatro = new JButton("boton 4");
        // alineacion de los botones
        uno.setAlignmentX(CENTER_ALIGNMENT);
        dos.setAlignmentX(CENTER_ALIGNMENT);
        tres.setAlignmentX(CENTER_ALIGNMENT);
        cuatro.setAlignmentX(CENTER_ALIGNMENT);
        // annadir
        add(uno);
        add(dos);
        add(tres);
        add(cuatro);
        // acciones
        uno.addActionListener(this);
        dos.addActionListener(this);
        tres.addActionListener(this);
        cuatro.addActionListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // caso 1
        if(e.getSource() == uno){
            JOptionPane.showMessageDialog(this, "has pulsado el botton uno");
        }
        // caso 2
        if(e.getSource() == dos){
            JOptionPane.showMessageDialog(this, "has pulsado el botton dos");
        }
        // caso 3
        if(e.getSource() == tres){
            JOptionPane.showMessageDialog(this, "has pulsado el botton tres");
        }
        // caso 4
        if(e.getSource() == cuatro){
            JOptionPane.showMessageDialog(this, "has pulsado el botton cuatro");
        }
    }
}