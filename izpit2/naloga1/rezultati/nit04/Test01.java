
public class Test01 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {

        boolean[][] p = {
            {F, T, T, T, T},
            {T, T, T, F, F},
            {F, F, F, T, T},
            {F, T, T, T, F},
        };
        System.out.println(Park.steviloProstih(p));   // 12
    }
}
