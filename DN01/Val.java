import java.util.Scanner;

public class Val{

    final static String cross = "+";
    final static String line = "-";

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        print("Enter the number of periods");
        int periods = sc.nextInt();
        
        print("Enter wavelength:");
        int wavelength = sc.nextInt();

        print("Enter the amplitude");
        int amplitude = sc.nextInt();

        print("Enter the phase shift");
        int phaseShift = sc.nextInt();

        String strToPrint = "";

        for(int i = 0; i < periods; i++){

            String holderString = "";
            String upperString = line;
            String bottomString = "|\n";

            upperString = upperString.repeat((wavelength / 2) - 1);
            upperString += cross;

            bottomString = bottomString.repeat(amplitude - 1);
            bottomString += cross;

            strToPrint += upperString;
            strToPrint += bottomString;
            
        }

        print(strToPrint);


    }

    private static void print(String message){
        System.out.println(message);
    }

}