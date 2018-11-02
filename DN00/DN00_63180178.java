import java.util.Scanner;

public class DN00_63180178{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int numberOfCandy = sc.nextInt();
        int numberOfPeople = sc.nextInt();

        int candyPerPerson = numberOfCandy / numberOfPeople;

        System.out.println(candyPerPerson);
        System.out.println(numberOfCandy - (candyPerPerson * numberOfPeople));

        sc.close();
    }

}