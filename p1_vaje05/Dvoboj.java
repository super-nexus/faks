
import java.util.Scanner;
import java.util.Random;

public class Dvoboj {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int seed = sc.nextInt();
        int numberOfGames = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        Random generator = new Random(seed);
        String strToPrint = "";

        int aWins = 0;
        int bWins = 0;

        while(true){

            int randomNum = generator.nextInt(100);

            if(randomNum < a){
                strToPrint += "A";
                aWins++;
            }
            else if(randomNum >= a && randomNum < (a+b)){
                strToPrint += "B";
                bWins++;
            }
            else{
                strToPrint += "-";
            }

            if(aWins == numberOfGames || bWins == numberOfGames){
                break;
            }

        }

        System.out.println(strToPrint);

    }
}
