
/**
 * NALOGA 1
 */

public class Park {

    /**
     * Naloga (a) -- vrne "stevilo prostih parkirnih mest na parkiri"s"cu.
     */
    public static int steviloProstih(boolean[][] p) {
        int counter = 0;

        for(int i = 0; i < p.length; i++){
            for(int m = 0; m < p[0].length; m++){
                if(p[i][m] == true){
                    counter++;
                }
            }
        }
        return counter;
    }

    /**
     * Naloga (b) -- preveri, ali obstaja vrstica z vsaj k zaporednimi (!)
     * prostimi mesti.
     */
    public static boolean zaporedje(boolean[][] p, int k) {

        for(int i = 0; i < p.length; i++){

            int currentCounter = 0;

            for(int m = 0; m < p[0].length; m++){
                

                if(p[i][m]){
                    currentCounter++;
                }
                else{
                    if(currentCounter >= k){
                        return true;
                    }
                    currentCounter = 0;
                }

            }

            if(currentCounter >= k){
                return true;
            }

        }
        return false;
    }

    /**
     * Naloga (c) -- vrne "stevilo VSEH parkirnih mest v gara"zni hi"si.
     */
    public static int steviloMest(boolean[][][] g) {
        // Dopolnite / spremenite ...
        return (g.length)*(g[0].length * g[0][0].length);
    }

    /**
     * Naloga (d) -- vrne indeks nadstropja z najve"c prostimi mesti.
     */
    public static int najboljProstoNadstropje(boolean[][][] g) {
        int currentIndex = 0;
        int currentLowest = 0;

        for(int i = 0; i < g.length; i++){
            if(steviloProstih(g[i]) > currentLowest){
                currentLowest = steviloProstih(g[i]);
                currentIndex = i;
            }
        }
        return currentIndex;
    }
}
