import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class DN01_63180178{

    final static String cross = "+";
    final static String line = "-";
    final static String vertical_line = "|";
    final static String new_line = "\n";
    final static String space = " ";

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

      // print("Enter the number of periods");
        int periods = sc.nextInt();
        
      //  print("Enter wavelength:");
        int wavelength = sc.nextInt();

     //  print("Enter the amplitude");
        int amplitude = sc.nextInt();

     //   print("Enter the phase shift");
        int phaseShift = sc.nextInt();

        wavelength = ((wavelength % 2 == 0)? wavelength : wavelength + 1);

        //print(strToPrint);
        printGraph(periods, wavelength, amplitude, phaseShift);

    }

    private static void printGraph(int period,int wavelength,int amplitude,int offset){

        String top = "";
        String middle = "";
        String bottom = "";

        int counter = 0;
        int offsetCounter = 0;

        int deposit = offset != 0 ? 1 : 0; 

        if(offset > 0){
            if(offset < (wavelength / 2)){
                offset--;
            }
        }

        for(int i = 0; i < ((period * wavelength) + period + offset + deposit); i++){

            if(offset > 0 && offsetCounter <= offset){
                counter++;
                offsetCounter++;
                continue;
            }

            if(counter < ((wavelength / 2) - 1)){
                top += line;
                middle += space;
                bottom += space;
            }
            else if(counter == ((wavelength / 2)) || counter == wavelength){
                top += cross;
                middle += vertical_line;
                bottom += cross;
            }
            else if(counter > (wavelength / 2)){
                top += space;
                middle += space; 
                bottom += line;
            }

            if(counter == wavelength){
                counter = 0;
            }
            else{
                counter++;
            }
    
        }
        
        top += new_line;

        middle += new_line;
        middle = middle.repeat(amplitude - 1);

        System.out.println(top + middle + bottom);

    }

}