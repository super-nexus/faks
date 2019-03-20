
public class Test09 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {
        boolean[][] m = {
            {F, T, F, F, T, T},
            {T, F, T, F, T, F},
            {F, T, F, T, F, F},
            {F, F, T, F, T, F},
            {T, T, F, T, F, F},
            {T, F, F, F, F, F}
        };
        int[][] s1 = {
            {1, 4, 5},
            {0, 2, 4},
            {1, 3},
            {2, 4},
            {0, 1, 3},
            {0}
        };
        int[][] s2 = {
            {1, 4, 5},
            {0, 2, 3},
            {1, 3},
            {1, 2, 4},
            {0, 3},
            {0}
        };
        System.out.println(Graf.istiGraf(m, s1));
        System.out.println(Graf.istiGraf(m, s2));
    }
}
