/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lifegame;

import java.util.Random;

/**
 *
 * @author ellui
 */
public class LifeGame {

    static int ms = 12;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int matriz[][] = new int[ms][ms];
        int matrizAuxiliar[][] = new int[ms][ms];
        Random generator = new Random();
        for (int row = 0; row < ms; row++) {
            for (int col = 0; col < ms; col++) {
                double number = generator.nextDouble() * 1;
                matriz[row][col] = (int) Math.round(number);
                System.out.print(matriz[row][col]);
            }
            System.out.println("");
        }

        for (int generation = 0; generation < 1000; generation++) {

            for (int row = 0; row < ms; row++) {
                for (int col = 0; col < ms; col++) {
                    matrizAuxiliar[row][col] = checkConditions(matriz, row, col);
                }
            }
            
            System.out.println("");
            System.out.println("Generación "+generation);
            for (int row = 0; row < ms; row++) {
                for (int col = 0; col < ms; col++) {
                    double number = generator.nextDouble() * 1;
                    matriz[row][col] = matrizAuxiliar[row][col];
                    System.out.print(matriz[row][col]);
                }
                System.out.println("");
            }
        }
        
        
    }

    static public int checkConditions(int[][] matriz, int currentRow, int currentCol) {
        /////check neigbords
        int aliveCells = 0;
        int row = currentRow;
        int col = currentCol;
        //midlet cells
        if (row != 0 && row != ms - 1 && col != 0 && col != ms - 1) {
            if (matriz[row - 1][col - 1] == 1) {
                aliveCells++;
            }
            if (matriz[row - 1][col] == 1) {
                aliveCells++;
            }
            if (matriz[row - 1][col + 1] == 1) {
                aliveCells++;
            }

            //same row 
            if (matriz[row][col - 1] == 1) {
                aliveCells++;
            }
            if (matriz[row][col + 1] == 1) {
                aliveCells++;
            }

            //under
            if (matriz[row + 1][col - 1] == 1) {
                aliveCells++;
            }
            if (matriz[row + 1][col] == 1) {
                aliveCells++;
            }
            if (matriz[row + 1][col + 1] == 1) {
                aliveCells++;
            }

        }

        /// left corner  top
        if (row == 0 && col == 0) {

            //top
            if (matriz[ms - 1][ms - 1] == 1) {
                aliveCells++;
            }
            if (matriz[ms - 1][0] == 1) {
                aliveCells++;
            }
            if (matriz[ms - 1][1] == 1) {
                aliveCells++;
            }

            //same row 
            if (matriz[row][ms - 1] == 1) {
                aliveCells++;
            }
            if (matriz[row][col + 1] == 1) {
                aliveCells++;
            }

            //under
            if (matriz[row + 1][ms - 1] == 1) {
                aliveCells++;
            }
            if (matriz[row + 1][col] == 1) {
                aliveCells++;
            }
            if (matriz[row + 1][col + 1] == 1) {
                aliveCells++;
            }

        }

        ///rigth corner top
        if (row == 0 && col == ms - 1) {

            //top
            if (matriz[ms - 1][col - 1] == 1) {
                aliveCells++;
            }
            if (matriz[ms - 1][col] == 1) {
                aliveCells++;
            }
            if (matriz[ms - 1][0] == 1) {
                aliveCells++;
            }

            //same row 
            if (matriz[row][col - 1] == 1) {
                aliveCells++;
            }
            if (matriz[row][0] == 1) {
                aliveCells++;
            }

            //under
            if (matriz[row + 1][col - 1] == 1) {
                aliveCells++;
            }
            if (matriz[row + 1][col] == 1) {
                aliveCells++;
            }
            if (matriz[row + 1][0] == 1) {
                aliveCells++;
            }

        }

        ///left corner down
        if (row == ms - 1 && col == 0) {

            //top
            if (matriz[row - 1][ms - 1] == 1) {
                aliveCells++;
            }
            if (matriz[row - 1][col] == 1) {
                aliveCells++;
            }
            if (matriz[row - 1][col + 1] == 1) {
                aliveCells++;
            }

            //same row 
            if (matriz[row][ms - 1] == 1) {
                aliveCells++;
            }
            if (matriz[row][col + 1] == 1) {
                aliveCells++;
            }

            //under
            if (matriz[0][ms - 1] == 1) {
                aliveCells++;
            }
            if (matriz[0][col] == 1) {
                aliveCells++;
            }
            if (matriz[0][col + 1] == 1) {
                aliveCells++;
            }

        }

        ///rigth corner down
        if (row == ms - 1 && col == ms - 1) {

            //top
            if (matriz[row - 1][col - 1] == 1) {
                aliveCells++;
            }
            if (matriz[row - 1][col] == 1) {
                aliveCells++;
            }
            if (matriz[row - 1][0] == 1) {
                aliveCells++;
            }

            //same row 
            if (matriz[row][col - 1] == 1) {
                aliveCells++;
            }
            if (matriz[row][0] == 1) {
                aliveCells++;
            }

            //under
            if (matriz[0][col - 1] == 1) {
                aliveCells++;
            }
            if (matriz[0][col] == 1) {
                aliveCells++;
            }
            if (matriz[0][0] == 1) {
                aliveCells++;
            }

        }

        ///// borde central superior
        if (row == 0 && col != 0 && col != ms - 1) {
            if (matriz[ms - 1][col - 1] == 1) {
                aliveCells++;
            }
            if (matriz[ms - 1][col] == 1) {
                aliveCells++;
            }
            if (matriz[ms - 1][col + 1] == 1) {
                aliveCells++;
            }

            //same row 
            if (matriz[row][col - 1] == 1) {
                aliveCells++;
            }
            if (matriz[row][col + 1] == 1) {
                aliveCells++;
            }

            //under
            if (matriz[row + 1][col - 1] == 1) {
                aliveCells++;
            }
            if (matriz[row + 1][col] == 1) {
                aliveCells++;
            }
            if (matriz[row + 1][col + 1] == 1) {
                aliveCells++;
            }
        }

        ///// borde central inferior
        if (row == ms - 1 && col != 0 && col != ms - 1) {
            if (matriz[row - 1][col - 1] == 1) {
                aliveCells++;
            }
            if (matriz[row - 1][col] == 1) {
                aliveCells++;
            }
            if (matriz[row - 1][col + 1] == 1) {
                aliveCells++;
            }

            //same row 
            if (matriz[row][col - 1] == 1) {
                aliveCells++;
            }
            if (matriz[row][col + 1] == 1) {
                aliveCells++;
            }

            //under
            if (matriz[0][col - 1] == 1) {
                aliveCells++;
            }
            if (matriz[0][col] == 1) {
                aliveCells++;
            }
            if (matriz[0][col + 1] == 1) {
                aliveCells++;
            }
        }

        // borde izquierdo
        if (col == 0 && row != ms - 1 && row != 0) {
            if (matriz[row - 1][ms - 1] == 1) {
                aliveCells++;
            }
            if (matriz[row - 1][col] == 1) {
                aliveCells++;
            }
            if (matriz[row - 1][col + 1] == 1) {
                aliveCells++;
            }

            //same row 
            if (matriz[row][ms - 1] == 1) {
                aliveCells++;
            }
            if (matriz[row][col + 1] == 1) {
                aliveCells++;
            }

            //under
            if (matriz[row + 1][ms - 1] == 1) {
                aliveCells++;
            }
            if (matriz[row + 1][col] == 1) {
                aliveCells++;
            }
            if (matriz[row + 1][col + 1] == 1) {
                aliveCells++;
            }
        }

        // borde derecho
        if (col == ms - 1 && row != 0 && row != ms - 1) {
            if (matriz[row - 1][col - 1] == 1) {
                aliveCells++;
            }
            if (matriz[row - 1][col] == 1) {
                aliveCells++;
            }
            if (matriz[row - 1][0] == 1) {
                aliveCells++;
            }

            //same row 
            if (matriz[row][col - 1] == 1) {
                aliveCells++;
            }
            if (matriz[row][0] == 1) {
                aliveCells++;
            }

            //under
            if (matriz[row + 1][col - 1] == 1) {
                aliveCells++;
            }
            if (matriz[row + 1][col] == 1) {
                aliveCells++;
            }
            if (matriz[row + 1][0] == 1) {
                aliveCells++;
            }
        }

        int currentCell = matriz[currentRow][currentCol];
        if (currentCell == 1 && aliveCells < 2) {
            return 0;
        }
        if (currentCell == 1 && aliveCells > 3) {
            return 0;
        }
        if (currentCell == 1 && (aliveCells >= 2 || aliveCells <= 3)) {
            return 1;
        }

        if (currentCell == 0 && aliveCells == 3) {
            return 1;
        }
        return 0;
    }
}
