/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.EventListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * clase que muestra un temporizador ;D
 * @author Javier Gonzalez Rives
 */
//1º Creacion del componente
public class BeansTemporizador extends JLabel implements Serializable, ActionListener {
    
/**
 *
 * @author usuario
 */
    // define la interfaz con los metodos a generar cuando se crea un evento
public class FinCuentaAtrasEvent extends java.util.EventObject
{
    // constructor
    public FinCuentaAtrasEvent(Object source)
    {
        super(source);
    }
}

//Define la interfaz para el nuevo tipo de evento
public interface FinCuentaAtrasListener extends EventListener
{
    void capturarFinCuentaAtras(FinCuentaAtrasEvent ev);
}

    // 2º Annadir las propiedades (propertis)
    private int tiempo;

    public static final String PROP_TIEMPO = "tiempo";
    private FinCuentaAtrasListener receptor;
    /**
     * Get the value of tiempo
     *
     * @return the value of tiempo
     */
    public int getTiempo() {
        return tiempo;
    }

    /**
     * Set the value of tiempo
     *
     * @param tiempo new value of tiempo
     */
    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
        setText(Integer.toString(tiempo));
        repaint();
    //}
        int oldTiempo = this.tiempo;
        this.tiempo = tiempo;
        propertyChangeSupport.firePropertyChange(PROP_TIEMPO, oldTiempo, tiempo);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    // implementar el comportamiento :D:D:D:D:D:D:D:
    public BeansTemporizador() {
        //propertySupport = new PropertyChangeSupport(this);
        tiempo = 5;
        t = new Timer (1000, this); 
        setText(Integer.toString(tiempo));
        setActivo(true);
    }
    private Timer t;

    //Activo es en si mismo una propiedad (sin atributo subyacente)
    //Gestiona si el temporizador está funcionado o no.
    public final void setActivo(boolean valor) {
        if (valor == true)
            t.start();
        else
            t.stop();
    }
    public boolean getActivo() {
        return t.isRunning();
    }

    //Constructor sin argumentos. Se establece como tiempo por defecto 5 segundos.
   

    //Accion que se realiza cada vez que se cumplen los 1000 milisegudos establecidos
    //para t. se modifica el valor del texto de la etiqueta, se repinta y se disminuye
    //en un segundo el tiempo restante.
    //Cuando el tiempo llega a cero se para el Timer y se muestra un mensaje de tiempo
    //terminado.
    public void actionPerformed(ActionEvent e)
    {
        // Aquí el código que queramos ejecutar.
        setText(Integer.toString(tiempo));
        repaint();
        tiempo--;
        if(tiempo == 0){
            setActivo(false);
            JOptionPane.showMessageDialog(null, "Terminado", "Aviso",
            JOptionPane.INFORMATION_MESSAGE);
            receptor.capturarFinCuentaAtras( new FinCuentaAtrasEvent(this));
        }
    }
      
}
