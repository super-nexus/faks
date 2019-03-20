
public class Test08 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {
        boolean[][] m = {
            {F, T, T, F, F},
            {T, F, T, T, T},
            {T, T, F, T, T},
            {F, T, T, F, F},
            {F, T, T, F, F}
        };
        int[][] s = {
            {1, 2},
            {0, 2, 3, 4},
            {0, 1, 3, 4},
            {1, 2},
            {1, 2}
        };
        System.out.println(Graf.istiGraf(m, s));
    }
}
