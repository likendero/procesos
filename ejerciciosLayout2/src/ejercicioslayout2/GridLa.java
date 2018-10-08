/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioslayout2;

import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author likendero
 */
public class GridLa {
    public static void mostrar(){
        VentanaGrid ven = new VentanaGrid();
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
class VentanaGrid extends JFrame{
    private PanelGrid panel;
    public VentanaGrid()  {
        super("ventana Grid");
        setBounds(100,100,400,400);
        init();
    }
    /**
     * metodo que inicializa los elementos de la ventana
     */
    public void init(){
        panel = new PanelGrid();
        add(panel);
    }
}
class PanelGrid extends JPanel{
    private JButton uno,dos,tres,cuatro,cinco,seis;
    public PanelGrid(){
        super();
        init();
    }
    
    public void init(){
        // instanciacion de los botones
        uno = new JButton("uno");
        dos = new JButton("dos");
        tres = new JButton("tres");
        cuatro = new JButton("cuatro");
        cinco = new JButton("cinco");
        seis = new JButton("seis");
        // creacion layout
        GridLayout la = new GridLayout(3, 2);
        setLayout(la);
        // annadir botones
        add(uno);
        add(dos);
        add(tres);
        add(cuatro);
        add(cinco);
        add(seis);
        
        
    }
}