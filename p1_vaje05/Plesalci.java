
import java.util.Scanner;

public class Plesalci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int man = sc.nextInt();
        int woman = sc.nextInt();
        int g = sc.nextInt();

        int counter = 1;

        int firstCheck = ((man >= woman)? man : woman);
        int secondCheck = ((man >= woman)? woman : man);

        for(int i = g; i <= man ; i += g ){

            for(int m = g; m <= woman; m += g){

                if(gcd(i, m ) == g){
                    System.out.printf("[%d] %d + %d\n", counter, i, m );
                    counter++;
                }

            }

        }

    }

    /*
     * Vrne GCD pozitivnih celih števil a in b.
     */
    public static int gcd(int a, int b) {
        while (b > 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }
}
