package Constraint;

import javax.swing.*;
import java.awt.*;

/**
 * metodo que inicia el programa
 */
public class pruebaConstraint {
    public static void mostrar(){
        Ventana2 ven = new Ventana2();
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
                mostrar();
            }
        });
    }
}

/**
 * clase que crea una ventana de prueba
 */
class Ventana2 extends JFrame {


    /**
     * metodo constructor para la ventana
     */
    public Ventana2(){
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
        PanelEjemplo2 panel = new PanelEjemplo2();
        // add();
        add(panel);
    }
}

/**
 * clase que crea un panel con Spring layout para enseñar como funciona
 *
 */
class PanelEjemplo2 extends JPanel{
    private JLabel lbTexto;
    private JTextField tfEjemplo;
    private JButton btnEjemplo;
    private SpringLayout ly;
    private Container con;
    /**
     * cosntructor para el panel
     */
    public PanelEjemplo2(){
        super();
        // creacion del layout
        ly = new SpringLayout();
        // cambio de layout para el panel
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
        /*
        las distancias no tienen valor absoluto por lo que
        dependiendo de la posicion de los elementos es necesario
        indicarlo de forma negativa o positiva
         */
        // union de la etiqueta al texto
        ly.putConstraint(SpringLayout.EAST,lbTexto,-10,SpringLayout.WEST,tfEjemplo);
        ly.putConstraint(SpringLayout.SOUTH,lbTexto,-15,SpringLayout.SOUTH,tfEjemplo);
        // union del texto los bordes
        ly.putConstraint(SpringLayout.EAST,tfEjemplo,-10,SpringLayout.EAST,this);
        ly.putConstraint(SpringLayout.NORTH,tfEjemplo,20,SpringLayout.NORTH,this);
        // union del contenedor al texto
        /*
        para que el cuadro de texto aumente conforme a la ventana
        es necesario vincular el borde de la ventana propiamente dicho
        al cuadro de texto
         */
        ly.putConstraint(SpringLayout.SOUTH,this,10,SpringLayout.SOUTH,tfEjemplo);

        // adds
        add(lbTexto);
        add(tfEjemplo);
        add(btnEjemplo);
    }
}