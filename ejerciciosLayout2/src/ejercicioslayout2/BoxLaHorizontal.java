
package ejercicioslayout2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *  clase para el ejercicio con una ventana y un boxlayout horizontal
 * @author linuxdiurno
 */
public class BoxLaHorizontal {
    /**
     * metodo que instancia la ventana y la muestra
     */
    public static void mostrar(){
        VentanaHorizontal ven = new VentanaHorizontal();
        ven.setVisible(true);
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
 * clase que crea una ventana para el ejercicio
 * @author linuxdiurno
 */
class VentanaHorizontal extends JFrame{
    PanelHorizontal panel;
    /**
     * metodo constructor principal
     */
    public VentanaHorizontal(){
        super("estos es una ventana con u BoxLayout");
        init();
    }
    /**
     * metodo que define e inicializa las caractersiticas
     * de la ventana
     */
    private void init(){
        // inicializacion del panel
        panel = new PanelHorizontal();
        // annadir el panel
        add(panel);
        setBounds(100,100,400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    }
}
/**
 * clase que sirve para definir el panel con el BoxLayout
 * @author linuxdiurno
 */
class PanelHorizontal extends JPanel{
    JButton btnHola,btnSorpresa,btnSalir;
    public PanelHorizontal(){
        super();
        init();
    
    }
    
    private void init(){
        // creacion del layout
        BoxLayout boxi = new BoxLayout(this, BoxLayout.X_AXIS);
        
        setLayout(boxi);
        
        // inicializacion de los botones
        btnHola = new JButton("Hola");
        btnSorpresa = new JButton("Sorpresa");
        btnSalir = new JButton("Salir");
        
        // annadir botones al panel
        add(btnHola);
        add(btnSorpresa);
        add(btnSalir);
        
        // annadir las acciones
        
        btnHola.addActionListener(e->Hola());
        btnSorpresa.addActionListener(e->sorpresa());
        // boton de salir
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
    }
    /**
     * metod que se ejecuta cuando se pulsa el boton
     * de HOLA
     */
    private void Hola(){
        // se muestra un mensaje de saludo
        JOptionPane.showMessageDialog(
                null,
                "te saludo aunque no me apetezca\n lasmaquinas dominaremos el mundo",
                "saludito",
                JOptionPane.WARNING_MESSAGE
        );
    }
    /**
     * metodo que muestra una sorpresa al que lo ejecuta
     */
    private void sorpresa(){
        // ventana de dialogo para preguntar al usuario
        JOptionPane.showMessageDialog(
                null,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean vitae urna ut diam tempor fermentum. Duis vitae lorem consequat, bibendum neque in, aliquet ipsum. Pellentesque luctus aliquet nisi, eu ullamcorper ante tempus eu. Duis ac fringilla justo. Quisque consequat sem sit amet porttitor malesuada. Nulla et dapibus neque, ultrices fringilla ligula. Nam auctor maximus lorem, vitae tempus nisl mollis ac. Phasellus ultrices sed elit scelerisque eleifend. Phasellus sit amet tincidunt velit. Nam vel nisl semper, euismod ex consequat, suscipit libero. Morbi sollicitudin ac elit quis mattis. Morbi eget gravida augue, nec sollicitudin eros. ",
                "juas juas",
                JOptionPane.INFORMATION_MESSAGE
                
        );
    }
}
