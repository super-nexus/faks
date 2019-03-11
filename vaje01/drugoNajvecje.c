#include<stdio.h>


int main(){

    int n = getChar();

    

    return 0;
}


int getChar(){
    int toReturn = getchar() - '0';
    getchar();
    return toReturn;
}