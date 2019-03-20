
/**
 * NALOGA 1
 */

import java.util.*;

public class Graf {

    // -------------------------------------------------------------------------
    // Dopolnite / spremenite ...
    // -------------------------------------------------------------------------
    public static boolean imaEulerjevObhod(boolean[][] m) {

        boolean euler = true;

        for (int i = 0; i < m.length; i++) {

            int counter = 0;

            for (int r = 0; r < m[0].length; r++) {
                if (m[i][r]) {
                    counter++;
                }
            }

            if ((counter % 2) == 1) {
                return false;
            }

        }
        return true;
    }

    // -------------------------------------------------------------------------
    // Dopolnite / spremenite ...
    // -------------------------------------------------------------------------
    public static boolean[][] vMatriko(int[][] s) {
        boolean[][] holder = new boolean[s.length][s.length];

        for (int i = 0; i < s.length; i++) {

            for (int m = 0; m < s.length; m++) {

                boolean in = false;

                for (int num : s[i]) {
                    if (num == m) {
                        in = true;
                    }
                }

                if (in) {
                    holder[i][m] = true;
                } else {
                    holder[i][m] = false;
                }
            }
        }

        return holder;

    }

    // -------------------------------------------------------------------------
    // Dopolnite / spremenite ...
    // -------------------------------------------------------------------------
    public static boolean istiGraf(boolean[][] m, int[][] s) {
        boolean holder = true;

        for (int i = 0; i < m.length; i++) {

            for (int r = 0; r < m[0].length; r++) {

                if (m[i][r]) {
                    holder = false;
                    for (int num : s[i]) {
                        if(num == r){
                            holder = true;
                            break;
                        }
                    }   
                }
                else{
                    for(int num : s[i]){
                        if(num == r){
                            return false;
                        }
                    }
                }
            }

        }
        return holder;
    }
}
