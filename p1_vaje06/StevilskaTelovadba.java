import java.util.Scanner;

public class StevilskaTelovadba {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int command = sc.nextInt();
        int n = sc.nextInt();
        int d = 0;

        if (command > 0) {
            d = sc.nextInt();
        }

        switch (command) {
        case 1:
            addNumberAtTheEnd(n, d);
            break;
        case -1:
            removeNumberAtTheEnd(n);
            break;
        case 2:
            addNumberAtTheStart(n, d);
            break;
        case -2:
            removeNumberAtTheStart(n);
            break;
        }

    }

    private static void addNumberAtTheEnd(int n, int d) {
        System.out.println(n * 10 + d);
    }

    private static void removeNumberAtTheEnd(int n) {
        System.out.println(n / 10);
    }

    private static int power(int number, int power) {
        int toPrint = number;
        for (int i = 1; i <= power; i++) {
            toPrint *= number;
        }
        return (toPrint);
    }

    private static void addNumberAtTheStart(int n, int d) {
        int sum = 0;
        int i = 0;
        while (n > 0) {

            int reminder = n % 10;
            sum += reminder * power(10, i);
            
            n /= 10;
            i++;
        }

        sum += d * (power(10, i));
        sum /= 10;
        System.out.println(sum);
    }


    private static void removeNumberAtTheStart(int n) {
        int sum = 0;
        int i = 0;
        while (n > 10) {

            int reminder = n % 10;
            sum += reminder * power(10, i);
            
            n /= 10;
            i++;
        }
        sum /= 10;
        System.out.println(sum);
    } 

}