
/**
 * NALOGA 2
 */

import java.util.*;

public class Zaporedje {

    //-------------------------------------------------------------------------
    // Dopolnite / spremenite ...
    //-------------------------------------------------------------------------

    private int k;
    private int current = 1;
    private int depot = 1;

    int currentIndex = 0;

    boolean first = true;

    public Zaporedje(int k) {
        this.k = k;
    }

    //-------------------------------------------------------------------------
    // Dopolnite / spremenite ...
    //-------------------------------------------------------------------------
    public int naslednje() {

  

        if(first){
            currentIndex++;
            first = false;
            return 1;
        }

        int naslednje = k*currentIndex - depot + current;
        current = naslednje;

        depot += 2;

        currentIndex++;

        return  naslednje;
    }

    //-------------------------------------------------------------------------
    // Dopolnite / spremenite ...
    //-------------------------------------------------------------------------
    public int katero() {
        if(first){return 1;}

        return currentIndex + 1;

    }

    //-------------------------------------------------------------------------
    // Dopolnite / spremenite ...
    //-------------------------------------------------------------------------
    public void ponastavi(int n) {

    //    System.out.println("Index: " + Integer.toString(n));
    //    System.out.println("Current Index" + Integer.toString(currentIndex));



        if(n > currentIndex){
            int nasZanima = n-1;

            for(int i = currentIndex; i < nasZanima; i++){
                naslednje();
            }
        }
        else{

            if(n == 1){
                currentIndex = 0;
                depot = 1;
                current = 1;
                first = true;
            }

            else{
                for(int r = currentIndex; r >= n; r--){

                    // System.out.println("Hello");

                    // System.out.println(currentIndex);
                    // System.out.println(depot);
                    // System.out.println(current);

                    currentIndex--;
                    depot -= 2;

                    current -= k*currentIndex -  depot;

                }
            }

        }

    }
}
