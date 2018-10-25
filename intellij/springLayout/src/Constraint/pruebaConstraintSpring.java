package Constraint;

import javax.swing.*;
import java.awt.*;

/**
 * metodo que inicia el programa
 */
public class pruebaConstraintSpring {
    public static void mostrar2(){
        Ventana ven = new Ventana();
        ven.setVisible(true);
    }

    /**
     * metodo principal
     * @param args
     */
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mostrar2();
            }
        });
    }
}

/**
 * clase que crea una ventana de prueba
 */
class Ventana extends JFrame {
    //private Container contenedor;

    /**
     * metodo constructor para la ventana
     */
    public Ventana(){
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100,100,200,100);
        init();

    }

    /**
     * metodo que incializa los elementos
     */
    public void init(){
        // creacion del panel
        PanelEjemplo panel = new PanelEjemplo(this.getContentPane());
        // add();
        add(panel);
    }
}

/**
 * clase que crea un panel con Spring layout para enseñar como funciona
 */
class PanelEjemplo extends JPanel{
    private JLabel lbTexto;
    private JTextField tfEjemplo;
    private JButton btnEjemplo;
    private SpringLayout ly;
    private Container con;
    /**
     * cosntructor para el panel
     */
    public PanelEjemplo(Container con){
        super();
        ly = new SpringLayout();
        this.con = con;
        setLayout(ly);
        init();
    }

    /**
     * metodo que incializa los elementos del
     * panel
     */
    private void init(){
        // instanciacion de los elementos
        lbTexto = new JLabel("un cuadro de texto:");
        tfEjemplo = new JTextField(10);
        btnEjemplo = new JButton("boton");
        // definicion parametros
        tfEjemplo.setMinimumSize(new Dimension(10,20));
        tfEjemplo.setMinimumSize(new Dimension(100,50));
        //tfEjemplo.setSize(30,20);
        //  Uniones
        // union de la etiqueta al texto
        ly.putConstraint(SpringLayout.EAST,lbTexto,-10,SpringLayout.WEST,tfEjemplo);
        ly.putConstraint(SpringLayout.SOUTH,lbTexto,-15,SpringLayout.SOUTH,tfEjemplo);
        // union del texto los bordes
        ly.putConstraint(SpringLayout.EAST,tfEjemplo,-10,SpringLayout.EAST,this);
        ly.putConstraint(SpringLayout.NORTH,tfEjemplo,20,SpringLayout.NORTH,this);
        // union del contenedor al texto
        ly.putConstraint(SpringLayout.WEST,this,20,SpringLayout.WEST,tfEjemplo);

        // adds
        add(lbTexto);
        add(tfEjemplo);
        add(btnEjemplo);
    }
}