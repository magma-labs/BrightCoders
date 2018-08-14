#include <iostream>
#include "gof.hpp"
using namespace std;

int main(){
    int size;
    bool step = 1;    
    //Delimit grid
    GameOfLife game(20);
    game.display();
    //Inputs
    
    while(step == 1){
        game.tick();
        cin >> step;
    }   
    return 0;
}