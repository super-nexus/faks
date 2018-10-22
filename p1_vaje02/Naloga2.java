import java.util.Scanner;

public class Naloga2{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int givenNumber = sc.nextInt();
        
        int s = givenNumber;
        int counter = 0;

        while(s > 0){
            
            s /= 10;
            counter++;

        }
        System.out.println(counter);
    }

}