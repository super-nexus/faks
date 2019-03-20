
public class Test01 {

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
        System.out.println(Graf.imaEulerjevObhod(m));
    }
}
