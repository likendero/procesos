/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.relog;

import javax.swing.JPanel;

/**
 *
 * @author linuxdiurno
 */
public class PanelContenedor extends JPanel {
    private PanelRelog panelRelog;
    private PanelBotones panelBotones;
    
    public PanelContenedor (){
        super();
        
    }
    /**
     * metodo para inicializar los elementos del panel
     * en este caso solo son paneles
     */
    public void init(){
        // inicializar paneles
        panelBotones = new PanelBotones();
        panelRelog = new PanelRelog();
        
        
        
    }
}
