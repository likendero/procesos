/*
 * Copyright (C) 2018 likendero
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package buscaminas.interfaz;

import buscaminas.logica.Utilities;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Javier Gonzalez Rives
 */
public class PanelMenu extends JPanel {
    /// elementos de la interfaz
    private JLabel lbImagenRelog, lbImagenBandera;
    private JTextField txMarcador, txRelog;
    private JButton btSalir,btStart,btPausaContinuar;
    private Component separacion;
    /**
     * Metodo constructor para el menu
     */
    public PanelMenu(){
        super();
        init();
    }
    /**
     * metodo que inicializa los elementos del panel
     */
    private void init(){
        /// instanciacion de los elementos
        // etiquetas imagen
        lbImagenBandera = new JLabel();
        lbImagenRelog = new JLabel();
        // cuadros de texto
        txMarcador = new JTextField();
        txRelog = new JTextField();
        // instanciacion de los botones
        btPausaContinuar = new JButton("pausa");
        btSalir = new JButton("salir");
        btStart = new JButton("start");
        /// salir
        btSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        // poner las imagenes
        setImage();
        /// cambio de aspecto cuadros de texto
        // cambio fondo
        txMarcador.setBackground(Color.BLACK);
        txRelog.setBackground(Color.BLACK);
        // cambio fuente
        txMarcador.setForeground(Color.YELLOW);
        txRelog.setForeground(Color.YELLOW);
        // cambio tamanno
        txMarcador.setSize(50, 20);
        txRelog.setSize(50, 20);
        // hacerlos no editebles
        txMarcador.setEditable(false);
        txRelog.setEditable(false);
        /// canbio aspecto de los botones
        // cambio de color de letra
        btPausaContinuar.setForeground(Color.BLUE);
        btSalir.setForeground(Color.RED);
        btStart.setForeground(Color.ORANGE);
        
        /// cambio de layout
        GroupLayout gl = new GroupLayout(this);
        setLayout(gl);
        //  creacion de espaciado
        //separacion = Box.createVerticalStrut(100);
        
        // add elemenbtos
        add(lbImagenBandera);
        add(lbImagenRelog);
        add(btPausaContinuar);
        add(btSalir);
        add(btStart);
        add(txMarcador);
        add(txRelog);
        //add(separacion);
        // definicion de la disposicion
        gl.setAutoCreateContainerGaps(false);
        gl.setAutoCreateGaps(false);
        defineGroups(gl);
    }
    /**
     * metodo que define la estructura del group layout
     */
    private void defineGroups(GroupLayout gl){
        // definicion del grupo horizontal
        gl.setHorizontalGroup(
                gl.createParallelGroup()
                .addComponent(lbImagenBandera)
                .addComponent(txMarcador)
                .addComponent(lbImagenRelog)
                .addComponent(txRelog)
                .addComponent(btStart)
                .addComponent(btPausaContinuar)
                .addComponent(btSalir)
        );
        
        // definicon del grupo vertical
        gl.setVerticalGroup(
                gl.createSequentialGroup()
                .addComponent(lbImagenBandera)
                .addComponent(txMarcador)
                .addComponent(lbImagenRelog)
                .addComponent(txRelog)
                .addGap(300)
                .addComponent(btStart)
                .addComponent(btPausaContinuar)
                .addComponent(btSalir) 
        );
        
    }
    /**
     * metodo que define las imagenes de los 
     * elementos del panel menu
     */
    private void setImage(){
        // control de caso de error en la ruta
        
            // imagen para bandera
            lbImagenBandera.setIcon(Utilities.getIcon("src/imgp/bandera.jpg"));
            // imagen para reloj
            lbImagenRelog.setIcon(Utilities.getIcon("src/imgp/reloj1.jpg"));
        /*
            // quitar todos los iconos para poner textos
            lbImagenRelog.setIcon(null);
            lbImagenBandera.setIcon(null);
        */
            // poner texto
            lbImagenBandera.setText("banderas");
            lbImagenRelog.setText("reloj");
        
    }
    // GETTERS //////////////////////////////////////////////////////
    public JLabel getLbImagenRelog() {
        return lbImagenRelog;
    }

    public JLabel getLbImagenBandera() {
        return lbImagenBandera;
    }

    public JTextField getTxMarcador() {
        return txMarcador;
    }

    public JTextField getTxRelog() {
        return txRelog;
    }

    public JButton getBtSalir() {
        return btSalir;
    }

    public JButton getBtStart() {
        return btStart;
    }

    public JButton getBtPausaContinuar() {
        return btPausaContinuar;
    }
    
}
