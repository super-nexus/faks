import java.util.Scanner;

public class Naloga4{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int givenNum = sc.nextInt();

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
        System.out.println(counter);

    }
}