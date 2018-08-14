#include <bits/stdc++.h>

using namespace std;

int **createMatrix(int m, int n){
    int **matrix = (int**)malloc(m * sizeof(int*));  //Asigna la primer columna de m FILAS
    matrix[0]=(int*)malloc(m*n*sizeof(int));
    for(unsigned i=1; i<m; i++)
        matrix[i]=matrix[i-1]+n;
    return matrix;
}

void freeMatrix(int **matrix){
    free(matrix[0]);
    free(matrix);
}

void generateMatrix(int m, int n, int** matrix){
    for (int i = 0; i <(int)m; i++){
      for(int j=0;j<(int)n;j++){
          matrix[i][j]=(int)(rand());
      }
    }
}

int getNeighbours(int i, int j, int **m, int n){

        if(i==0){
            if( j==0 ){                                 //Caso 1
                return ( m[i][j+1] + m[i+1][j]+ m[i+1][j+1]+ m[i][n-1]+ m[n-1][j]+ m[i+1][n-1]+ m[n-1][j+1]+ m[n-1][n-1] );

            }else if( j==n-1 ){                 //Caso 2
                return (  m[i][j-1] + m[i+1][j-1]+ m[i+1][j]+  m[n-1][j]+ m[n-1][ j-1]   + m[i][0]+ m[i+1][0] + m[i][0]+ m[n-1][0]);

            }else if( j>=1 || j<=n-2){          //Caso 3
                int sum=0;
                for(int k=j-1;k<=j+1;k++){
                    for(int l=i;l<=i+1;l++){
                        if(i!=l && j!=k)
                            sum+=m[l][k];
                    }
                    sum+=m[n-1][k];
                }
                return sum;
            }
        }else if(i==n-1){
            if( j==0 ){         //Caso 4
                return (  m[i-1][j-1] + m[i-1][j]+ m[i-1][j+1]+ m[i][j+1]+ m[0][j+1]+ m[0][j]+ m[0][j-1]+ m[i][j-1]);
            }else if( j==n-1 ){
                return (  m[i-1][j-1] + m[i-1][j]+ m[i-1][0]+ m[i][j-1]+ m[i][0]+ m[0][0]+ m[0][j]+ m[0][j-1]);
            }else if( j>=1 || j<=n-2){
                int sum=0;
                for(int k=j-1;k<=j+1;k++){
                    for(int l=i-1;l<=i;l++){
                        if(i!=l && j!=k)
                            sum+=m[l][k];
                    }
                    sum+=m[0][k];
                }
                return sum;
            }
        }else{
            if( j==0 ){
                int sum=0;
                for(int l=i-1;l<=i+1;l++){
                    for(int k=j;k<=j+1;k++){
                        if(i!=l && j!=k)
                            sum+=m[l][k];
                    }
                    sum+=m[l][n-1];
                }
                return sum;
            }else if( j==n-1 ){
                int sum=0;
                for(int l=i-1;l<=i+1;l++){
                    for(int k=j-1;k<=j;k++){
                        if(i!=l && j!=k)
                            sum+=m[l][k];
                    }
                    sum+=m[l][0];
                }
                return sum;
            }else if( j>=1 || j<=n-2){
                int sum=0;
                for(int l=i-1;l<=i+1;l++){
                    for(int k=j-1;k<=j+1;k++){
                        if(i!=l && j!=k)
                            sum+=m[l][k];
                    }
                }
                return sum;
            }
        }
}

int gameRules(int **m, int i,int j, int n){
        int nc=getNeighbours(i, j, m, n);
        switch(m[i][j]){
            case 0:
                if(nc==3)
                    return 1;
                break;
            case 1:
                if(nc<2)
                    return 0;
                else if( 2 || 3)
                    return 1;
                else
                    return 0;
                break;
        }

}

void updateM(int **m, int **mm, int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                mm[i][j]=gameRules(m, i, j, n);
            }
        }
        m=mm;
}

void printMat(int **m, int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                printf("\t%d",m[i][j]);
            }
            printf("\n");
        }
}
int main(){
    srand (time(NULL));
    int n=12, ex=0;
    int **mat, **mat_new;
    generateMatrix(n,n, mat);
    printMat(mat,n);
    while(ex<100){
        updateM(mat, mat_new, n);
        printMat(mat,n);
        ex++;
    }
    return 0;
}
