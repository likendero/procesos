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

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Javier Gonzalez Rives
 */
public class PanelMinas extends JPanel {
    // ancho y alto de la matriz de minas
    private int alto,ancho;
    // matriz que contiene el numero de minas
    private JButton btnMinas[][];
    /**
     * panel minas por defecto
     * construye la matriz de las minas en 8*8 por defecto
     */
    public PanelMinas(){
        super();
        this.alto = 8;
        this.ancho = 8;
    }
    /**
     * metodo constructor que define las dimensiones de 
     * la matriz de minas
     * @param alto alto de la matriz de minas
     * @param ancho ancho de la matriz de minas
     */
    public PanelMinas(int alto,int ancho){
        super();
        this.alto = alto;
        this.ancho = ancho;
    }
    /**
     * metodo que define la matriz de minas de forma cuadrada, 
     * con un solo numero
     * @param dimCuadrada 
     */
    public PanelMinas(int dimCuadrada){
        super();
        this.alto = dimCuadrada;
        this.ancho = dimCuadrada;
    }
    /**
     *  metodo que incializa todos los elementos del panel
     *  a partir del ancho y alto indicado en el constructor
     */
    private void init(){
        // definicion de la matriz de minas
        btnMinas = new JButton[alto][ancho];
        // recorrido filas
        for(int i = 0; i < alto ; i++){
            //recorrido columnas
            for(int j = 0; j < ancho ; j++){
                // instanciacion de los botones
                btnMinas[i][j] = new JButton();
                // cambio del color
                btnMinas[i][j].setBackground(new Color(0,199,212));
            }
        }
        // cambio del grid layout
        GridLayout ly = new GridLayout(alto, ancho,2,2);
        setLayout(ly);
        // annadir elementos
        // recorrido filas
        for(int i = 0; i < alto ; i++){
            //recorrido columnas
            for(int j = 0; j < ancho ; j++){
                // annadir minas al panel
                add(btnMinas[i][j]);
            }
        }
    }
    /**
     * metodo que devuelve uno de los botones en la
     * posicion indicada
     * @return 
     */
    public JButton getBtnMina(int alto,int ancho)throws IndexOutOfBoundsException{
        // control que las dimensiones de la matriz son correctas
        if(alto >= this.ancho || ancho >= this.ancho || alto < 0 || ancho < 0){
            throw new IndexOutOfBoundsException("fuera del limite de la matriz");
        }
        return this.btnMinas[alto][ancho];
    }
}
