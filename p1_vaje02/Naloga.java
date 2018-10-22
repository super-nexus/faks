import java.util.Scanner;

public class Naloga{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int lowerBound = sc.nextInt();
        int upperBound = sc.nextInt();

        for(int i = lowerBound; i <= upperBound; i++){

            System.out.println(i*i);

        }

    }

}