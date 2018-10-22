import java.util.Scanner;

public class Roman2{

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int distance = sc.nextInt();
        int distancePerDay = sc.nextInt();

       // int numberOfDays = distance/distancePerDay;

       int counter = 1;

        while(distance > 0 ){

            int razlika = distance - distancePerDay;
            int walkedDistance = razlika;
            
            if(razlika < 0){
                walkedDistance = 0;
                distancePerDay = distance;
            }
            
            System.out.printf("%d. dan: %d -> %d (prehodil %d)\n", counter, distance, walkedDistance, distancePerDay);

            distance -= distancePerDay;
            counter++;

        }
        sc.close();
    }

}