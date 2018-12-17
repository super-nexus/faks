import java.util.Scanner;

public class DN05_63180178 {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int arrayLength = sc.nextInt();
        // int[] arrayOfPeople = populateArray(sc, arrayLength);
        method2(arrayLength, sc);

        // method1(arrayLength, arrayOfPeople);
    }

    private static void method2(int arrayLength, Scanner sc) {

        long sum = 0;
        int counter = 1;
        boolean matchFound = false;
        int currentMax = 0;
        int[] holder = new int[arrayLength];

        for (int i = 0; i < arrayLength; i++) {

            int currentHeight = sc.nextInt();
            holder[i] = currentHeight;

            if (currentMax < currentHeight) {
                sum += i + 1;
                currentMax = currentHeight;
                continue;
            }

            for (int m = i - 1; m >= 0; m--) {

                if (currentHeight < holder[m]) {
                    sum += counter;
                    counter = 1;
                    matchFound = true;
                    break;
                }
                counter++;
            }

            counter = 1;

            if (!matchFound) {
                sum += i + 1;
            }

            matchFound = false;
        }

        System.out.println(sum);

    }
}