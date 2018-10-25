
package cardejercicio;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author likendero
 */
public class CardEjercicio {
    /**
     * metodo que define la ventana
     */
    public static void mostrar(){
        Ventanuco ven = new Ventanuco();
        ven.setVisible(true);
        JOptionPane.showMessageDialog(
                ven,
                "flecha arriba = ultima\n"
                + "flecha abajo = primera\n"
                + "flecha derecha = siguiente\n"
                + "flecha izquierda = atras"
        );
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mostrar();
            }
        });
    }
    
}
