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
import javax.swing.ImageIcon;
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
    private final int NUMEROMINAS = 8;
    private int matrizBanderas[][];
    private JTextField marcadorContadorBanderas;
    /**
     * metodo constructor de la logica de minas
     * @param botones 
     */
    public ControlJuego(JButton[][] botones,JTextField contador,Semaforo semaforo){
        super();
        this.botones = botones;
        this.semaforo = semaforo;
        this.marcadorContadorBanderas = contador;
        /// init
        matriz = new MatrizMinas(8, 8);
        matriz.setNumMinas(NUMEROMINAS);
        matriz.ponerMinas();
        matriz.completarMatriz();
        // matriz banderas
        matrizBanderas = new int[8][8];
        initMatrizBanderas();
        funcionando = false;
        contBanderas = 0;
        contMinas = 0;
        // posiciones
        col = 0;
        row = 0;
        /// add acciones 
        accionesMatrizBotones();
        matriz.pintarMatriz();
        // primera actualizacion del contador
        actualizarMarcadorContador();
    }
    /**
     * metodo que inicializa la matriz de banderas 
     */
    private void initMatrizBanderas(){
        //recorrido de la matriz banderas
        for(int i = 0; i < matrizBanderas.length; i++){
            for(int j = 0; j < matrizBanderas.length; j++){
                // se inicializan todos los elementos a 0
                matrizBanderas[i][j] = 0;
            }
        }
    }
    /**
     * matriz que annade las acciones a la
     * matriz de botones
     */
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
    /**
     * metodo que busca en que posiciones se encuentra el 
     * boton
     */
    private void encontrarPosicion(MouseEvent e){
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
            botones[row][col].setIcon(new ImageIcon(getClass().getResource("/imgp/minasexpult.png")));
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
            if(botones[row][col].getIcon() == null){
            // comprobacion de tal boton en la matriz de minas
            contrasteMatrizMinas();
            }
            // cambio de color
            cambioInactivos();
        }
    }
    /**
     * metodo que realiza la accion de pulsar en la matriz banderas
     */
    private void pulsacionMatrizBanderas(){
        int valor = matrizBanderas[row][col];
        
        switch(valor){
            case 0:
                if(contBanderas < NUMEROMINAS){
                    // cambio de valor matriz banderas
                    matrizBanderas[row][col] = valor+1;
                    // cambio de icono botones
                    botones[row][col].setIcon(new ImageIcon(getClass().getResource("/imgp/bandera.jpg")));
                    contBanderas++;
                }
                break;
            case 1:
                // cambio de valor matriz banderas
                matrizBanderas[row][col] = valor+1;
                // cambio de icono botones
                botones[row][col].setIcon(new ImageIcon(getClass().getResource("/imgp/bandera2.jpg")));
                contBanderas--;
                break;
            case 2:
                // cambio de nuevo el valor a 0
                matrizBanderas[row][col] = 0;
                // quitar la imagen
                botones[row][col].setIcon(null);
                break;
        }
        // se actualiza el numero de minas detectadas
        actualizarMinasDetectadas();
    }
    /**
     * metodo que acutualiza el texto del cuadro
     * del contdor
     */
    private void actualizarMarcadorContador(){
        marcadorContadorBanderas.setText(contBanderas + "/" + NUMEROMINAS);
    }
    /**
     * metodo que comprueba la matriz de banderas,
     * cada posicion =1 que coincida con una bomba sumara 1 al contador
     */
    private void actualizarMinasDetectadas(){
        int aux = 0;
        // recorrido matriz banderas 
        // TODO revisar como se establece el tamanno la matriz Banderas
        for(int i = 0; i < matrizBanderas.length; i++){
            for(int j = 0 ; j < matrizBanderas[i].length; j++){
                if(
                        matrizBanderas[i][j] == 1 &&
                        matriz.getMatrizMinas()[i][j] == 9
                        ){
                    aux++;
                }
            }
        }
        // se actualiza el valor de la variable
        contMinas = aux;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(funcionando && e.getButton() == MouseEvent.BUTTON3) {
            // captura de la psicion de la accion
            encontrarPosicion(e);
            // comprobacion que se trata de un boton pulsable
            if(botones[row][col].isEnabled()){
                pulsacionMatrizBanderas();
            }
            actualizarMarcadorContador();
            if(contMinas == NUMEROMINAS){
                semaforo.setActivo(false);
            }
        }
        
        
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
                    inactivosBanderas();
                }
            }
        }
        actualizarMarcadorContador();
    }
    /**
     * metodo que se encarga de quitar las banderas de
     * los botones que se desactiven
     */
    private void inactivosBanderas(){
        // recorrido de la matriz banderas
        for(int i = 0 ; i < matrizBanderas.length ; i++){
            for(int j = 0; j < matrizBanderas[i].length; j++){
                // comprobacion que se halla desactivado un boton que 
                // tubiese una bandera
                if(!botones[i][j].isEnabled() && matrizBanderas[i][j] > 0){
                    // se quita el icono de ese boton
                    botones[i][j].setIcon(null);
                    // si era una bandera se quita el icono
                    if(matrizBanderas[i][j] == 1){
                        contBanderas--;
                    }
                }
            }
        }
    }
    /**
     * metodo que resetea el juego
     */
    public void reiniciar(){
        // reseteo estado de los botones
        setAllInit();
        // reseteo de la matriz
        matriz = new MatrizMinas(8, 8);
        matriz.setNumMinas(NUMEROMINAS);
        matriz.ponerMinas();
        matriz.completarMatriz();
        // cambio del estado del semaforo
        semaforo.setActivo(true);
        // eliminar actividad de los botones
        setFuncionando(false);
        // formatear matriz banderas
        initMatrizBanderas();
        contBanderas = 0;
        actualizarMarcadorContador();
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
                botones[i][j].setBackground(new Color(0,199,212));
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
    
    
    /**
     * devuelve el estado de funcionando que controla si se pueden
     * pulsar botones
     * @return 
     */
    public boolean isFuncionando() {
        return funcionando;
    }
    /**
     * cambiar el estado de funcionando
     * @param funcionando 
     */
    public void setFuncionando(boolean funcionando) {
        this.funcionando = funcionando;
    }
    /**
     * devuelve el estado del semaforo
     * @deprecated 
     * @return 
     */
    public Semaforo getSemaforo() {
        return semaforo;
    }
    /**
     * devuelve el contador con las minas acertadas
     * @return 
     */
    public int getContMinas() {
        return contMinas;
    }
    /**
     * devuelve el contador con el numero de minas
     * @return 
     */
    public int getContBanderas() {
        return contBanderas;
    }
    /**
     * metodo que devuelve el numero de minas
     * del jeugo
     * @return 
     */
    public int getNUMEROMINAS() {
        return NUMEROMINAS;
    }
    
}
