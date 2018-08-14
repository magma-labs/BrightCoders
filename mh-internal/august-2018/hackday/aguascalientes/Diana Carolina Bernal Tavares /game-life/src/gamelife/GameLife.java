/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamelife;

import java.util.Random;

/**
 *
 * @author Diana
 */
public class GameLife {
    
    int matriz [][];
    boolean vivo;
    boolean muere;
    Random aleatorio;           
    
    public GameLife() {
        matriz = new int [12][12];
        vivo = true;
        muere = false;        
    }
    
    public boolean insertar(){
        boolean num;
        this.aleatorio = new Random();        
        // Producir nuevo int aleatorio entre 0 y 9
        
        int intAletorio = this.aleatorio.nextInt(9);        
        if(intAletorio%2==0) {
            num = true;    
        }
        else{
            num = false;
        }
        return num;
    } 
    
    public void generacion0(){
        int cont = 0; 
        boolean llenar;
        
        System.out.println("Generacion 0");
        for(int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if(cont<10)
                {    
                    llenar = insertar();
                    if(llenar==true)
                        matriz[i][j]=1;
                    else 
                        matriz[i][j]=0;
                } 
                System.out.print(matriz[i][j]);       
            }
            System.out.println("");
        }
    }
    
    public void evaluarTabla(int i, int j){
        int cont=0;
        if(matriz[i-1][j-1]==1){
            cont++;
            if(matriz[i-1][j]==1){
                cont++;
                if(matriz[i-1][j+1]==1){
                    cont++;
                    if(matriz[i][j-1]==1){
                        cont++;
                        if(matriz[i][j+1]==1){
                            cont++;
                            if(matriz[i+1][j-1]==1){
                                cont++;
                                if(matriz[i+1][j]==1){
                                    cont++;                                       
                                }
                            }
                        }
                    }
                }
            }
        }
            
        if(cont<2 && cont>3)
            matriz[i][j] = 0;
        else{
            if(cont==2 || cont==3)
            {
                matriz[i][j] = 1;
            }
        }

        if(cont==3 && matriz[i][j]==0)
        {
            matriz[i][j]=1;
        }
    }
    
    public void imprimir(){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j]);
            }            
            System.out.println("");
        }
    }
    
    public static void main(String[] args) {
        GameLife game = new GameLife();
        
        //Primera Generacion 
        game.generacion0();
        
        //Generaciones Consecutivas
        for (int c=1; ; c++) {
            System.out.println("Generacion " + c);
            for(int i = 0; i < game.matriz.length; i++) {
                for(int j = 0; j < game.matriz.length; j++) {
                    if((i>0 && j>0) && (i<11 && j<11)){
                        game.evaluarTabla(i, j);
                    }                    
                }  
            } 
            game.imprimir();
        }
    }    
}
