import java.util.Scanner;

public class Analiza{

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int u = sc.nextInt();

        switch(u){

            case 1:
                System.out.println(sc.nextInt());
                break;          
            case 2:
                returnLastElement(sc);
                break;
            case 3:
                returnSumOfLastTwoElements(sc);
                break;
            case 4:
                returnLenghtOfFirstRun(sc);
                break;
            case 5:
                returnGreatestDistinctEelements(sc);
                break;

        }


    }

    private static void returnLastElement(Scanner scanner){

        int currentNumber = 0;

        while(scanner.hasNext()){
            currentNumber = scanner.nextInt();
        }

        System.out.println(currentNumber);

    }

    private static void returnSumOfLastTwoElements(Scanner scanner){

        int currentNumber = 0;
        int previousNumber = 0;
        boolean firstTime = true;

        while(scanner.hasNext()){

            if(firstTime){
                currentNumber = scanner.nextInt();
                firstTime = false;
                continue;
            }

            previousNumber = currentNumber;
            currentNumber = scanner.nextInt();

        }

        int sum = previousNumber + currentNumber;
        
        System.out.println(sum);
    }

    private static void returnLenghtOfFirstRun(Scanner scanner){

        int currentNumber = 0;
        int previousNumber = 0;
        boolean first = true;
        int counter = 1;

        while(scanner.hasNext()){

            if(first){
                currentNumber = scanner.nextInt();
                first = false;
                continue;
            }

            previousNumber = currentNumber;
            currentNumber = scanner.nextInt();

            if(currentNumber >= previousNumber){
                counter++;
            }
            else{
                System.out.println(counter);
                break;
            }

        }

    }

    private static void returnGreatestDistinctEelements(Scanner scanner){

        
        int currentNumber = 0;
        int previousNumber = 0;
        int currentHighest = 1;
        int differenceCounter = 1;
        boolean first = true;
        int counter = 1;

        while(scanner.hasNext()){

            if(first){
                currentNumber = scanner.nextInt();
                first = false;
                continue;
            }

            previousNumber = currentNumber;
            currentNumber = scanner.nextInt();

            if(currentNumber >= previousNumber){
                if(currentNumber != previousNumber){
                    differenceCounter++;
                }
                counter++;
            }
            else{
                if(currentHighest < differenceCounter){
                    currentHighest = differenceCounter;
                }
                counter = 1;
                differenceCounter = 1;
            }        
        }

        if(differenceCounter > currentHighest){
            currentHighest = differenceCounter;
        }

        System.out.println(currentHighest);
    }

}