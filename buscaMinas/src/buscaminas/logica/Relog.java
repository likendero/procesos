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

import javax.swing.JTextField;

/**
 *
 * @author Javier Gonzalez Rives
 */
public class Relog extends Thread{
    private JTextField txRelog;
    private int segundos,minutos;
    private Semaforo semaforo;
    
    
    public Relog(JTextField cuadro,Semaforo semaforo){
        super();
        segundos = 0;
        minutos = 0;
        txRelog = cuadro;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        while(true){
            while(semaforo.isActivo()){
                txRelog.setText(minutos + ":" + segundos);
                esperar();
                incrementar();
            }
            System.out.println("");
        }
    }
    /**
     * metodo que realiza la espera de un segundo
     */
    private void esperar(){
        try{
            sleep(1000);
        }catch(InterruptedException in){
            
        }
    }
    /**
     * metodo que incrementa en 1 segundo el tiempo
     */
    public void incrementar(){
        if(segundos < 60){
            segundos++;
        }
        else if(minutos < 99){
            segundos = 0;
            minutos++;
        }else{
            minutos = 0;
            segundos = 0;
        }
    }

    public Semaforo getSemaforo() {
        return semaforo;
    }
    /**
     * reinciar
     */
    public void reiniciar(){
        segundos = 0;
        minutos = 0;
    }
    
}
