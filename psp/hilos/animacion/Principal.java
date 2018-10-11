package animacion;

import javax.swing.SwingUtilities;

import animacion.Ventana;

public class Principal{
    public static void mostrar(){
        Ventana ven = new Ventana();
        ven.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
        
            @Override
            public void run() {
                mostrar();
            }
        });
    }

}