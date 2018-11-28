
public class Funkcije {

    public static double koren(double x, double epsilon) {
        double n = 0;
        double sum = 0; 
        double clen = 1;
        
        while (Math.abs(clen) > epsilon) {
            sum += clen;
            clen = clen * (1.0 - 2 * n) * (x - 1.0) / (2 * (n  + 1.0));
            n++;
        }
        return sum;
    }

    private static int faculty(int number){
     //   int toReturn = number;

        while(number > 1){
            number *= number - 1;
            number--;
        }

        return number;
    }

    private static double absolute(double number){
        return (number < 0)? -1 * number : number;
    }

    private static double returnElement(int n, double x){
        double toReturn = (power(-1, n) * faculty(2*n) * power(x-1, n)) / ((1 - 2*n)) * power(faculty(n), 2) * power(4, n);
        System.out.println("Element: " + toReturn);
        return toReturn;

    }

    private static double power(double number, int power){
        double toReturn = number;
        for(int i = 0; i < power; i++){
            toReturn *= number;
        }
        return toReturn;
    }
}
