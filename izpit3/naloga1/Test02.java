
public class Test02 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {
        boolean[][] m1 = {
            {F, T, T, F},
            {T, F, T, F},
            {T, T, F, T},
            {F, F, T, F},
        };
        System.out.println(Graf.imaEulerjevObhod(m1));

        boolean[][] m2 = {
            {F, T, T},
            {T, F, T},
            {T, T, F},
        };
        System.out.println(Graf.imaEulerjevObhod(m2));
    }
}
