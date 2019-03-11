#include<stdio.h>

int main(){

    int n = getchar() - '0';
    getchar();

    int equal = 1;
    int first = 1;

    int current, prev;

    for(int i = 0; i < n - 1; i++){

        if(first == 1){
            prev = getchar() - '0';
            getchar();
            first = 0;
        }

        current = getchar() - '0';
        getchar();

        if(current != prev){
            equal = 0;
        }

        prev = current;
    }

    putchar(equal + '0');
    putchar('\n');

    return 0;
}