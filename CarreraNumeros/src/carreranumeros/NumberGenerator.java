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
package carreranumeros;

/**
 *
 * @author likendero
 */
public class NumberGenerator {
    private int numInicial;
    private int velocidad;
    /**
     * metodo constructor
     * genera un numero al azar entre 10 y 40 para num inicial
     * genera
     */
    public NumberGenerator(){
        super();
        numInicial = randomNumber();
        velocidad = randomVelocidad();
    }
    /**
     * metodo para generar de forma aleatoria un numero
     * @return 
     */
    public int randomNumber(){
        int num;
        num = (int)(Math.random()*30+10);
        return num;
    }
    /**
     * metodo que genera la velocidad aleatoriamente
     * la velocidad puede ir de medio segundo (500) hasta un segundo (1000)
     * @return 
     */
    public int randomVelocidad(){
        int vel;
        vel = (int)(Math.random()*500+500);
        return vel;
    }
    /**
     * metodo que devuelve el numero inicial
     * @return 
     */
    public int getNumInicial() {
        return numInicial;
    }
    /**
     * metodo que devuelve la velocidadad
     * @return 
     */
    public int getVelocidad() {
        return velocidad;
    }
    
}
