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
package buscaminas.logica;

import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author likendero
 */
public class Utilities {
    /**
     * metodo que devuelve el icono indicado
     * @param dir
     * @return
     * @throws MalformedURLException 
     */
    public static Icon getIcon(String dir){
        Object obj = new Object();
        // creacion del imageIcon con el url de la imagen
        ImageIcon icon = new ImageIcon(obj.getClass().getResource(dir));
        //ImageIcon icon = new ImageIcon(dir);
        return icon;
    }
}
