import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class DN07_63180178 {

    private static int sumOfTime = 0;

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int timesLength = sc.nextInt() - 1;

        int[] timeBetweenStations = readTimes(sc, timesLength);

        int startingTimesLength = sc.nextInt();

        int[][] startingTimes = readStartingTimes(sc, startingTimesLength);

        returnSumOfLowestTimes(timeBetweenStations, startingTimes, timesLength, startingTimesLength);

    }

    private static int[] readTimes(Scanner sc, int length) {

        int[] holder = new int[length];

        for (int i = 0; i < length; i++) {

            int currentTime = sc.nextInt();

            holder[i] = currentTime;

            sumOfTime += currentTime;
        }

        return holder;

    }

    private static int[][] readStartingTimes(Scanner sc, int length) {

        int[][] holder = new int[length][2];

        for (int i = 0; i < length; i++) {

            for (int m = 0; m < 2; m++) {
                holder[i][m] = sc.nextInt();
            }

        }

        return holder;

    }

    private static int absoluteDifference(int first, int second) {
        return Math.abs(first - second);
    }

    private static void returnSumOfLowestTimes(int[] times, int[][] startingTimes, int timesLength,
            int startingTimesLength) {

        int sum = 0;

        for (int i = 0; i < startingTimesLength; i++) {

            int[] currentStartingTimes = startingTimes[i];

            int lowest = findLowestTime(times, currentStartingTimes, timesLength);

            sum += lowest;

            // System.out.println(Arrays.toString(currentStartingTimes) + " : " + lowest);
        }

        System.out.println(sum);
    }

    private static int findLowestTime(int[] times, int[] currentStartingTimes, int timesLength) {

        int currentLowest = -1;
        int startingA = currentStartingTimes[0];
        int startingB = currentStartingTimes[1];

        int currentTime = 0;

        if (absoluteDifference(startingA, startingB) >= sumOfTime) {
            return 0;
        }

        for (int time : times) {

            currentTime += time;

            int timeDifference = absoluteDifference(startingA + currentTime, startingB + (sumOfTime - currentTime));

            if (currentLowest == -1 || timeDifference < currentLowest) {
                currentLowest = timeDifference;
            } else {
                return currentLowest;
            }

        }

        return currentLowest;
    }

    private static int findLowestTime2(int[] times, int[] currentStartingTimes, int timesLength) {

        int currentLowest = -1;
        int startingA = currentStartingTimes[0];
        int startingB = currentStartingTimes[1];
        boolean goA = false;
        boolean goB = false;
        int deltaTime = 0;
        int currentTime = 0;

        if (absoluteDifference(startingA, startingB) >= sumOfTime) {
            return 0;
        }

        if (startingA < startingB) {
            deltaTime = startingB - startingA;
            goA = true;
        } else if (startingB < startingA) {
            deltaTime = startingA - startingB;
        }

        if (goA) {
            for (int i = 0; i < timesLength; i++) {
                currentTime += times[i];

                int timeDifference = absoluteDifference(startingA + currentTime, startingB + (sumOfTime - currentTime));

                if (currentLowest == -1 || timeDifference < currentLowest) {
                    currentLowest = timeDifference;
                } else {
                    return currentLowest;
                }
            }
        } else {
            for (int i = timesLength - 1; i >= 0; i--) {

                currentTime += times[i];

                int timeDifference = absoluteDifference(startingA + currentTime, startingB + (sumOfTime - currentTime));

                if (currentLowest == -1 || timeDifference < currentLowest) {
                    currentLowest = timeDifference;
                } else {
                    return currentLowest;
                }
            }
        }

        return currentLowest;
    }

}