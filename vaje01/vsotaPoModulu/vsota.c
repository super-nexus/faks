#include<stdio.h>


int main(){

    int a, b, rez;

    a = getchar() - '0';
    getchar();
    b = getchar() - '0';
    //getchar();

    rez = (a+b)%10;

    putchar('0' + rez);
    putchar('\n');

    return 1;
}