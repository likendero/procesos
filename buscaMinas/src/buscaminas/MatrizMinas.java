/*
 * Copyright (C) 2018 linuxdiurno
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
package buscaminas;

/**
 *
 * @author likendero
 */
public class MatrizMinas {
    private int[][] matrizMinas;
    private int numeroMinas;
    /**
     * metodo constructor con filas y columnas las bombas se incializan a 0
     * @param row filas que se desean en la matriz
     * @param col columnas de la matriz
     */
    public MatrizMinas(int row,int col)throws IndexOutOfBoundsException{
        super();
        validarMatriz(row, col);
        // creacion de la matriz
        this.matrizMinas = new int[row][col];
        rellenarMatriz();
        this.numeroMinas = 0;
    }
    /**
     * metodo que defina la matriz, crea una matriz 10x10
     * por defecto, las bombas se inicializan a 0
     */
    public MatrizMinas(){
        super();
        // definicion de la matriz
         this.matrizMinas = new int[10][10];
         // Definicion de las minas
         this.numeroMinas = 0;
         rellenarMatriz();
    }
    /**
     * metodo que comprueba las filas y columnas introducidas, 
     * en el caso de no ser validas lanza una excepcion
     * @param row
     * @param col
     * @throws IndexOutOfBoundsException 
     */
    private void validarMatriz(int row,int col)throws IndexOutOfBoundsException{
        // control por debajo
        if(row < 2 || col < 2)
            throw new ArrayIndexOutOfBoundsException("el tamanno de las filas y columnas debeser igual o mayor a 2");
        // control por arriba
        if(row >= 100 || col >= 100)
            throw new IndexOutOfBoundsException("el tamanno de las filas y columnas debe ser igual o menor a 100 ");
    }
    /**
     * metodo que sirve para redefinir los parametros de la matriz
     * @param row
     * @param col
     * @throws IndexOutOfBoundsException 
     */
    public void setMatriz(int row,int col)throws IndexOutOfBoundsException{
        // comprobacion de la validez de los datos introducidos
        validarMatriz(row, col);
        this.matrizMinas = new int[row][col];
    }
    public void setNumMinas(int num)throws IndexOutOfBoundsException{
        int numTotalCasillas = this.matrizMinas.length * this.matrizMinas[0].length;
        if(num < 0){
            throw new IndexOutOfBoundsException("el numero de minas no puede ser negativo");
        }if(numTotalCasillas <= num){
            throw new IndexOutOfBoundsException("el numero de bombas no puede ser igual o mayor al de casillas");
        }
    }
    /**
     * metodo que coje la matriz del buscaminas
     * y pone un -1 en todos los espacios indicando que 
     * ese hueco esta sin usar
     */
    public void rellenarMatriz(){
        // recorrido por las filas de la matriz
        for(int i = 0; i < this.matrizMinas.length;i++){
            // recorrido por las columnas de la matriz
            for(int j = 0; j < this.matrizMinas[i].length;j++){
                // rellenado con -1
                this.matrizMinas[i][j] = -1;
            }
        }
    }
    /**
     * metodo que coloca de forma aleatoria en las minas en el 
     * juego (estas se indican por un 9)
     */
    public void ponerMinas(){
        minasProporcional();
        int row,col;
        int numRow = this.matrizMinas.length;
        int numCol = this.matrizMinas[0].length;
        // bucle que pone el numero indicado de minas
        for(int i = 0; i < this.numeroMinas;i++){
            // definicion al azar de fila
            row = (int)(Math.random()*numRow);
            // Definicion al azar de columna
            col = (int)(Math.random()*numCol);
            // se comprueba que en la posicion no halla bomba
            if(this.matrizMinas[row][col] == -1){
                // si no la hay se cambia el -1 por un 9
                this.matrizMinas[row][col] = 9;
            }else{
                // en caso contrario se reduce la iteracion
                i--;
            }
        }
    }
    /**
     * metodo que en el caso de no estar definido el numero de bombas
     * lo define en un 20% del numero total de casillas
     */
    private void minasProporcional(){
        // comprobacion del numero de minas
        if(this.numeroMinas == 0){
            // en el caso que el numero de minas sea 0 se ponen un 20% del numero de casillas totales
            this.numeroMinas = (int)((this.matrizMinas.length * this.matrizMinas[0].length)*0.2);
        }
    }
    /**
     * una vez annadidas las bombas se completan las casillas con 
     * el numero de bombas que tienen alrededor
     */
    public void completarMatriz(){
    
    }
    /**
     * metodo que saca por pantalla la matriz 
     * generada anteriormente para ver su estado
     */
    public void pintarMatriz(){
        for(int i = 0; i < this.matrizMinas.length; i++){
            // las filas empiezan por un corchete abierto
            System.out.print("[");
            for(int j = 0; j < this.matrizMinas[i].length;j++){
                System.out.print(" " + this.matrizMinas[i][j] + " ");
            }
            // las filas acaban por un corchete cerrado
            System.out.println("]");
        }
    }
}
