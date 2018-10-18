
package taller.springLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author linuxdiurno
 */
public class Principal {
    
    /**
     * metodo que crea una ventana y despues la muestra
     */
    public static void  mostrar(){
        
        JFrame ven = new JFrame("Spring");
        PanelBotones panel = new PanelBotones(ven.getContentPane());
        ven.setBounds(100, 100, 400, 400);
        ven.setDefaultCloseOperation(ven.EXIT_ON_CLOSE);
        ven.add(panel);
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
