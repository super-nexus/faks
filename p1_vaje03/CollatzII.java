import java.util.Scanner;

public class CollatzII{

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] currentMax = {a, collatzLength(a)};
        for(int i = a + 1; i <= b ; i++){
            int collatzLength = collatzLength(i);
            if(currentMax[1] < collatzLength){
                currentMax[0] = i;
                currentMax[1] = collatzLength;
            }
        }

        System.out.println(currentMax[0] + "\n" + currentMax[1]);

    }

    static int collatzLength(int givenNum){

        int counter = 1;

        while(givenNum > 1){
            if(givenNum % 2 == 0){
                givenNum /= 2;
            }
            else{
                givenNum = givenNum * 3 + 1;
            }
            counter++;
        }
        return counter;
    }

}