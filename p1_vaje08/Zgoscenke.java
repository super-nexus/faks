import java.util.Scanner;
import java.util.Arrays;


public class Zgoscenke{

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int numberOfCds = sc.nextInt();
        int memoryPerCD = sc.nextInt();

        int[] arrayOfCDs = populateArray(numberOfCds);
        int length = arrayOfCDs.length;

        int lowest = 0;
        int lowestIndex = 0;
        while(sc.hasNext()){

            int current = sc.nextInt();

           // System.out.printf("Lowest: %d, lowestIndex: %d", lowest, lowestIndex);

            for(int i = 0; i < length; i++){

                if(arrayOfCDs[i] < lowest){
                    lowest = arrayOfCDs[i];
                    lowestIndex = i;
                }

            }

            if((lowest + current) <= memoryPerCD){
                arrayOfCDs[lowestIndex] = arrayOfCDs[lowestIndex] + current;
                lowest = arrayOfCDs[lowestIndex];
                printChange(lowestIndex, current, arrayOfCDs);
            }
            else{
                break;
            }

        }

    }

    private static void printChange(int index, int amount, int[] array){

        System.out.printf("%d EP -> zgoscenka %d %s\n", amount, index + 1, Arrays.toString(array));

    }


    private static int[] populateArray(int numberOfCds){
        int[] holder = new int[numberOfCds];
        for(int i = 0; i < numberOfCds; i++){
            holder[i] = 0;
        }

        return holder;

    }   

}