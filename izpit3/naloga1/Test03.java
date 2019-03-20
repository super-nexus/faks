
public class Test03 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {
        boolean[][] m1 = {
            {F, T, T, T, T},
            {T, F, T, T, T},
            {T, T, F, T, T},
            {T, T, T, F, T},
            {T, T, T, T, F},
        };
        System.out.println(Graf.imaEulerjevObhod(m1));

        boolean[][] m2 = {
            {F, T},
            {T, F},
        };
        System.out.println(Graf.imaEulerjevObhod(m2));
    }
}
