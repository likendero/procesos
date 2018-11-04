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
package buscaminas.principal;
import buscaminas.interfaz.Ventana;
import javax.swing.SwingUtilities;
/**
 *
 * @author likendero
 */
public class Main {
    /**
     * metodo que crea y hace visible la ventana
     */
    public static void mostrar(){
        Ventana ventana = new Ventana();
        //ventana.pack();
        ventana.setVisible(true);
    }
    /**
     * metodo principal incio del programa
     * @param args 
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
