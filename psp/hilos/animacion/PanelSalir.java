package animacion;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelSalir extends JPanel{
    JButton btnSalir;
    /**
     * constructor que prepara un panel con un boton 
     * para salir del programa
     */
    public PanelSalir(){
        super();
        init();
    }
    /**
     * metodo que incializa los elementos del panel
     */
    public void init(){
        // instanciacion del boton
        btnSalir = new JButton("salir");
        // cambio de color
        btnSalir.setBackground(Color.BLACK);
        btnSalir.setForeground(Color.GREEN);
        // annadir boton
        btnSalir.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
            }
        });

        // ADDS
        add(btnSalir);
    }
}