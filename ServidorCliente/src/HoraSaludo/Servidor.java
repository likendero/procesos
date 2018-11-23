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
package HoraSaludo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *  servidor
 * @author Javier Gonzalez Rives
 */
public class Servidor {
    private static final int puerto = 12000; 
    public static void main(String[] args) {
        DatagramSocket servidor = null;
        // inicio del servidor
        try{
            // creacion del servicio en el puerto
            servidor = new DatagramSocket(puerto);
            System.out.println("inicio del servidor");
            servidor.setSoTimeout(300000);
            
            // la gran bucle
            while(true){
                // data gram paquetuelo
                DatagramPacket data = new DatagramPacket(new byte[1024], 1024);
                // recepcion 
                servidor.receive(data);
                // 
                
            }
        }catch(SocketException soc){
            System.out.println("error en la creacion del servidor");
        }catch(IOException io){
        }
        
        
    }
}
