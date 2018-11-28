
import java.util.Scanner;

public class Smreka {

    final static String space = " ";
    final static String star = "*";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int heightOfSprouce = sc.nextInt();

       piramida(6, 0);

        for(int i = 1; i <= heightOfSprouce; i++){

            int offset = heightOfSprouce - i;

            piramida(i, offset);

        }

    }

    /*
     * Nariše piramido vi"sine <visina>, zamaknjeno za <zamik> presledkov v
     * desno.
     */
    private static void piramida(int visina, int zamik) {

        int rows = visina, k = 1;

       // System.out.print(zamik);

        for(int i = 1; i <= rows; i++) {

            
            for(int m = 0; m < zamik; m++){
                System.out.print(space);
            }

            for(int r = visina - 1; r >= 0; r--){
                System.out.print("-");
            }

            for(int l = 0; l < k; l++){
                System.out.print(star);
            }

            k += 2;

            System.out.println();
        
        }

        //System.out.print("                p");

    }
}
