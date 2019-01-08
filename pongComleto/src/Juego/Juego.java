/*
 * Copyright (C) 2018 Javier Gonzalez Rives
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
package Juego;

import java.awt.Canvas;
import java.awt.Dimension;

/**
 *
 * @author Javier Gonzalez Rives
 */
public class Juego extends Canvas {
    private Pelota pelota;
    private Raqueta raqueta1,raqueta2;
    /**
     * metodo contructor de la clase que gestiona el 
     * juego
     */
    public Juego(){
        super();
        // caracterisiticas terreno de juego
        setPreferredSize(new Dimension(700,200));
        // creacion de los elementos de juego
        
    }
}
