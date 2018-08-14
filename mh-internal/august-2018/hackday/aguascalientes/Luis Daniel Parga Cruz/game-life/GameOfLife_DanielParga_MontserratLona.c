/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include<stdio.h>
#include<stdlib.h>
#include <time.h>
#include<unistd.h>

#define DIM 40


void showPopulation(int matrix[DIM][DIM]){
    int row, col;

    for(row = 0; row < DIM; row++){
        for(col = 0; col < DIM; col++){
            if(matrix[row][col] == 1)
                printf("@  ");
            else
            printf("  " );
        }// for col
            printf("\n");
    }// for row


}//initPopulation

void countNeig(int matrixNeig[DIM][DIM], int matrix[DIM][DIM]){
    // int matrixNeig[10][10];
    int row1, col1, row2, col2;
    int x1,x2, y1,y2;
    for(row1 = 0; row1 < DIM; row1++){
        for(col1 = 0; col1 < DIM; col1++){
            // Matriz de vecinos se inicializa de esta forma para evitar que la celda a analizar se cuente como vecino
            if(matrix[row1][col1] == 1){ matrixNeig[row1][col1] = -1; }
            else{ matrixNeig[row1][col1] = 0; }

          x1 = col1-1; x2 = col1+1;
          y1 = row1-1; y2 = row1+1;
          if(x1 == -1){ x1 = 0;}
          if(y1 == -1){ y1 = 0;}
          if(x2 == DIM){ x2 = DIM-1;}
          if(y2 == DIM){ y2 = DIM-1;}

            for(row2 = y1; row2 <= y2; row2++){
                for(col2 = x1; col2 <= x2; col2++){
                    if(matrix[row2][col2] == 1){ matrixNeig[row1][col1]++;}
                }// for col2

            }// for row2
        }// for col1
    }// for row1
}

void evolution(int population[DIM][DIM], int matrixNeig[DIM][DIM]){
    int row, col;

    for(row = 0; row < DIM; row++){
        for(col = 0; col < DIM; col++){
            // VIVA
            if(population[row][col] == 1){
                //
                if(matrixNeig[row][col] < 2){population[row][col] = 0;}
                else if(matrixNeig[row][col] > 3){population[row][col] = 0;}
            }else{
                if(matrixNeig[row][col] == 3){ population[row][col] = 1;}
            }//_ estado
        }// for col
    }// for row
}//_evolution


int main()
{
    srand(time(NULL));

    int dim = 10;
    int row, col;
    int population[DIM][DIM];
    int matrixVecinos[DIM][DIM];

    for(row = 0; row < DIM; row++){
        for(col = 0; col < DIM; col++){
            population[row][col] = (rand() % (2));
        }// for col
    }// for row


    int c=0, C, d;

    system("clear");
    while(1){
        showPopulation(population);
        countNeig(matrixVecinos, population);
        evolution(population, matrixVecinos);
        usleep(1000000);
        system("clear");
    }

    return 0;
}
