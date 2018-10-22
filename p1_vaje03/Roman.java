import java.util.Scanner;

public class Roman{

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int distance = sc.nextInt();
        int distancePerDay = sc.nextInt();

       // int numberOfDays = distance/distancePerDay;

        while(distance > 0 ){
            System.out.println(distance);
            distance -= distancePerDay;
        }

    }

}