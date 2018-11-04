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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Javier Gonzalez Rives
 */
public class ControlJuego implements ActionListener,MouseListener {
    private MatrizMinas matriz;
    private JButton botones[][];
    private int contMinas,contBanderas;
    private int col,row;
    private Semaforo semaforo;
    private boolean funcionando;
    /**
     * metodo constructor de la logica de minas
     * @param botones 
     */
    public ControlJuego(JButton[][] botones,JTextField contador,Semaforo semaforo){
        super();
        this.botones = botones;
        this.semaforo = semaforo;
        /// init
        matriz = new MatrizMinas(8, 8);
        matriz.setNumMinas(6);
        matriz.ponerMinas();
        matriz.completarMatriz();
        funcionando = false;
        contBanderas = 0;
        contMinas = 0;
        // posiciones
        col = 0;
        row = 0;
        /// add acciones 
        accionesMatrizBotones();
        matriz.pintarMatriz();
    }
    private void accionesMatrizBotones(){
        for(int i = 0; i < botones.length; i++){
            for(int j = 0; j < botones[0].length;j++){
                botones[i][j].addActionListener(this);
                botones[i][j].addMouseListener(this);
            }
        }
    }
    /**
     * metodo que busca en que posiciones se encuentra el 
     * boton
     */
    private void encontrarPosicion(ActionEvent e){
            boolean encontrado = false;
            // control para descubrir que boton se ha pulsado
            for(int i = 0 ; i < botones.length && !encontrado; i++){
                for (int j = 0; j < botones[i].length && !encontrado; j++) {
                    // comprobacion de los botones
                    if(botones[i][j] == e.getSource()){
                        // i corresponde a columna
                        row = i;
                        // j a la fila
                        col = j;
                        encontrado = true;
                    }
                }
        }   
    }
    public void vaciar(int col,int row){
         /*
            limRow = limite inferior filas
            supRow = limite superior filas
            limcol = limite inferior columnas
            supcol = limite superior columnas
        */
        int valor = -1;
        boolean limCol,limRow,supCol,supRow;
        // capturad de los limites
        limCol = limiteInferiorCol(col);
        limRow = limiteInferiorRow(row);
        supCol = limiteSuperiorCol(col);
        supRow = limiteSuperiorRow(row);
        //------------------------------------
        // se cambia el valor a 0 ya que no es una mina
                   
        // esquina superior izquierda
        if(limCol && supRow){
            valor = matriz.getMatrizMinas()[row-1][col-1];
            // comprovacion de hueco vacio
            if(valor == 0){
                if(botones[row-1][col-1].isEnabled()){
                    botones[row-1][col-1].setEnabled(false);
                    vaciar(col-1,row-1);
                }
            }else{
                // caso de numero no 0
                // desabilitar boton
                botones[row-1][col-1].setEnabled(false);
                // cambio del valor
                botones[row-1][col-1].setText(valor + "");
            }
        }
        // centro arriba
        if(supRow){
            valor = matriz.getMatrizMinas()[row-1][col];
            // comprobacion de hueco vacio
            if(valor == 0){
                if(botones[row-1][col].isEnabled()){
                    botones[row-1][col].setEnabled(false);
                    vaciar(col,row-1);
                }
            }else{
                // caso de numero no 0
                // desabilitar boton
                botones[row-1][col].setEnabled(false);
                // cambio del valor
                botones[row-1][col].setText(valor + "");
            }
        }
        // esquina superior derecha
        if(supCol && supRow){
            valor = matriz.getMatrizMinas()[row-1][col+1];
            // comprobacion de hueco vacio
            if(valor == 0){
                if(botones[row-1][col+1].isEnabled()){
                    botones[row-1][col+1].setEnabled(false);
                    vaciar(col+1,row-1);
                }
                
            }else{
                // caso de numero no 0
                // desabilitar boton
                botones[row-1][col+1].setEnabled(false);
                // cambio del valor
                botones[row-1][col+1].setText(valor + "");
            }
        }
        // centro izquierda
        if(limCol){
            valor = matriz.getMatrizMinas()[row][col-1];
            // comprobacion de hueco vacio
            if(valor == 0){
                if(botones[row][col-1].isEnabled()){
                    botones[row][col-1].setEnabled(false);
                    vaciar(col-1,row);
                }
                
            }else{
                // caso de numero no 0
                // desabilitar boton
                botones[row][col-1].setEnabled(false);
                // cambio del valor
                botones[row][col-1].setText(valor + "");
            }
        }
        // centro derecha ciudadanos
        if(supCol){
            valor = matriz.getMatrizMinas()[row][col+1];
            // comprobacion de hueco vacio
            if(valor == 0){
                if(botones[row][col+1].isEnabled()){
                    botones[row][col+1].setEnabled(false);
                    vaciar(col+1,row);
                }
            }else{
                // caso de numero no 0
                // desabilitar boton
                botones[row][col+1].setEnabled(false);
                // cambio del valor
                botones[row][col+1].setText(valor + "");
            }
        }
        // esquina superior izquierda
        if(limCol && limRow){
            valor = matriz.getMatrizMinas()[row+1][col-1];
            // comprobacion de hueco vacio
            if(valor == 0){
                if(botones[row+1][col-1].isEnabled()){
                    botones[row+1][col-1].setEnabled(false);
                    vaciar(col-1,row+1);
                }
                
            }else{
                // caso de numero no 0
                // desabilitar boton
                botones[row+1][col-1].setEnabled(false);
                // cambio del valor
                botones[row+1][col-1].setText(valor + "");
            }
        }
        // centro abajo
        if(limRow){
            valor = matriz.getMatrizMinas()[row+1][col];
            // comprobacion de hueco vacio
            if(valor == 0){
                if(botones[row+1][col].isEnabled()){
                    botones[row+1][col].setEnabled(false);
                    vaciar(col,row+1);
                }
                botones[row+1][col].setEnabled(false);
                vaciar(col,row+1);
            }else{
                // caso de numero no 0
                // desabilitar boton
                botones[row+1][col].setEnabled(false);
                // cambio del valor
                botones[row+1][col].setText(valor + "");
            }
        }
        // esquina inferior derecha
        if(supCol && limRow){
            valor = matriz.getMatrizMinas()[row+1][col+1];
            // comprobacion de hueco vacio
            if(valor == 0){
                if(botones[row+1][col+1].isEnabled()){
                    botones[row+1][col+1].setEnabled(false);
                    vaciar(col+1,row+1);
                }
                botones[row+1][col+1].setEnabled(false);
                vaciar(col+1,row+1);
            }else{
                // caso de numero no 0
                // desabilitar boton
                botones[row+1][col+1].setEnabled(false);
                // cambio del valor
                botones[row+1][col+1].setText(valor + "");
            }
        }
    }
    /**
     * comprobacion y acciones a tomar segun la 
     * casilla que se halla pulsado
     */
    private void contrasteMatrizMinas(){
        // captura del valor
        int valor = matriz.getMatrizMinas()[row][col];
        // caso de 0, hueco blanco
        if(valor == 0){
            vaciar(col,row);
            return;
        }
        // caso de un numero no mina
        if(valor > 0 && valor < 9){
            // se desabilita el boton y se muestra el numero
            botones[row][col].setEnabled(false);
            botones[row][col].setText(valor + "");
            return;
        }
        // caso de pulsar una mina
        if(valor == 9){
            botones[row][col].setEnabled(false);
            botones[row][col].setIcon(Utilities.getIcon("src/imgp/minasexpult.png"));
            // se devuelve indicacion fin del juego
            semaforo.setActivo(false);
            System.out.println("sem " + semaforo.isActivo());
            return;
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(funcionando){
            // busqueda del boton pulsado
            encontrarPosicion(e);
            // comprobacion de tal boton en la matriz de minas
            contrasteMatrizMinas();
            // cambio de color
            cambioInactivos();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    /**
     * se cambia el color de fondo de aquellos
     * botones inactivos
     */
    private void cambioInactivos(){
        for(int i = 0; i < botones.length; i++){
            for(int j = 0; j < botones[0].length;j++){
                if(!botones[i][j].isEnabled()){
                    botones[i][j].setBackground(Color.WHITE);
                }
            }
        }
    }
    /**
     * metodo que resetea el juego
     */
    public void reiniciar(){
        setAllInit();
        matriz = new MatrizMinas(8, 8);
        matriz.setNumMinas(6);
        matriz.ponerMinas();
        matriz.completarMatriz();
        setFuncionando(false);
    }
    /**
     * metodo que cambia el esta
     */
    private void setAllInit(){
        // recorrido de las minas
        for(int i = 0; i < botones.length; i++){
            for(int j = 0; j < botones[0].length;j++){
                botones[i][j].setEnabled(true);
                botones[i][j].setText("");
                botones[i][j].setIcon(null);
            }
        }
    }
    /////
     /**
     * metodo que comprueba el limite inferior de la posicion
     * @param col
     * @return 
     */
    private boolean limiteInferiorCol(int col){
        // caso que haya hueco por debajo
        if(col > 0){
            return true;
        }
        // caso no halla hueco
        else{
            return false;
        }
    }
    /**
     * metodo que comprueba el limite inferor de las filas
     * @return 
     */
    private boolean limiteInferiorRow(int row){
        // caso que haya hueco por debajo
        if(row < this.matriz.getMatrizMinas()[0].length-1){
            return true;
        }
        // caso no halla hueco
        else{
            return false;
        }
    }
    /**
     * metodo que devuelve si la posicion tiene filas por arriba
     * @return 
     */
    private boolean limiteSuperiorCol(int col){
        // si la columno no se pasa
        if(this.matriz.getMatrizMinas().length-1  > col){
            return true;
        }
        // si la columna se pasa
        return false;
    }
    /**
     * metodo que comprueba si la posicion tiene posiciones superiores
     * @return 
     */
    private boolean limiteSuperiorRow(int row){
        // si la columno no se pasa
        if(0 < row){
            return true;
        }
        // si la columna se pasa
        return false;
    }

    public boolean isFuncionando() {
        return funcionando;
    }

    public void setFuncionando(boolean funcionando) {
        this.funcionando = funcionando;
    }

    public Semaforo getSemaforo() {
        return semaforo;
    }
    
}
