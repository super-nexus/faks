
public class Test10 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {
        int[][] s = {
            {2},
            {2, 3},
            {0, 1},
            {1}
        };
        boolean[][] m1 = {
            {F, T, F, F},
            {T, F, T, F},
            {F, T, F, T},
            {F, F, T, F},
        };
        boolean[][] m2 = {
            {F, F, T, F},
            {F, F, T, T},
            {T, T, F, F},
            {F, T, F, F},
        };

        System.out.println(Graf.istiGraf(m1, s));
        System.out.println(Graf.istiGraf(m2, s));
    }
}
