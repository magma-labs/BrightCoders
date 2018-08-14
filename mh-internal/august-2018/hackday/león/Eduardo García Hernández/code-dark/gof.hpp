#include <iostream>

using namespace std;

class GameOfLife{

    public:
        bool **grid;
        int size;

    GameOfLife(int n){
        size = n;
        grid = new bool* [size];
        for (int i=0; i<size; i++)
            grid[i] = new bool[size];    
    }

    ~GameOfLife(){
        for (int i = 0; i < size; ++i)
            delete [] grid[i];
        delete [] grid;
    }

    void display();
    void tick();
};

void GameOfLife::display(){
    for(int i=0; i<size; i++){
        for(int j=0; j<size; j++)
            cout << grid[i][j] << " ";
        cout << endl;
    }            
}

void GameOfLife::tick(){
    for(int i=0; i<size; i++)
        for(int j=0; j<size; j++){
            //Count neighbors 
        }            
}