
package carreranumeros;

import javax.swing.SwingUtilities;

/**
 *
 * @author likendero
 */
public class CarreraNumeros {
    public static void mostrar(){
        Ventana ven = new Ventana();
        ven.setVisible(true);
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
