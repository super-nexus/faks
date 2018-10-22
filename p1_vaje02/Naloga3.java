import java.util.Scanner;

public class Naloga3{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        long givenNumber = sc.nextLong();
        
       // int counter = 0;

        while(givenNumber > 0){
            
            short digit = (short)(givenNumber % 10);
            System.out.println(digit);
            givenNumber /= 10;
            // counter++;

        }
    }

}