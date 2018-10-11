package animacion;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import animacion.PanelPintar;
import animacion.PanelSalir;

public class Ventana extends JFrame{
    PanelPintar panelPintar;
    public Ventana(){
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);
        init();
        // inicio de la animacion
        Thread hilo = new Thread(panelPintar);
        hilo.start();
    }
    public void init(){
        // incicializacion de los paneles
        PanelSalir panelSalir = new PanelSalir();
        panelPintar = new PanelPintar();
        // annadir paneles
        add(panelSalir,BorderLayout.PAGE_END);
        add(panelPintar,BorderLayout.CENTER);
    }

}