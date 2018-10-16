
package ejercicio.relog;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author linuxdiurno
 */
public class PanelBotones extends JPanel {
    private JButton btnInicio, btnParar;
    /**
     * metodo constructor para el panel con botones
     */
    public PanelBotones(){
        super();
        init();
    }
    /**
     * metodo que incializa los elementos del panel
     */
    public void init(){
        btnInicio = new JButton("inicio");
        btnParar = new JButton("parar");
        
        // cambio de color de los botones
        btnInicio.setBackground(Color.BLUE);
        btnParar.setBackground(Color.BLUE);
        
        btnInicio.setForeground(Color.RED);
        btnParar.setForeground(Color.RED);
        // cambio del tamaño
        btnInicio.setSize(60, 30);
        btnParar.setSize(60, 30);
        
        // adds
        add(btnInicio);
        add(btnParar);
    }
    /**
     * metodo que devuelve el boton para el incio
     * @return 
     */
    public JButton getBtnInicio(){
        return btnInicio;
    }
    /**
     * metodo que devuelve el boton de parar
     * @return 
     */
    public JButton getBtnParar(){
        return btnParar;
    }
}
