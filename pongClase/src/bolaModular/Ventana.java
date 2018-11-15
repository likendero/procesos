/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolaModular;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author likendero
 */
public class Ventana extends JFrame {
    private Juego juego;
    /**
     * clase constructora de la ventana
     */
    public Ventana(){
        super();
        setSize(400, 500);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
    }
    /**
     * metodo que incicializa los elemetos del panel
     */
    private void init(){
        juego = new Juego(this.getSize());
        add(juego);
        (new Thread(juego)).start();
    }
    /////////////////////// estaticos
    private static void mostrar(){
        Ventana ven = new Ventana();
        ven.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mostrar();
            }
        });
    }
}
