
public class Test02 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {

        boolean[][] p = {
            {T, F, F, T},
            {F, T, F, T},
            {F, F, T, F},
            {T, F, F, F},
            {T, F, T, F},
            {T, F, F, T},
        };
        System.out.println(Park.steviloProstih(p));   // 10

        boolean[][] q = {
            {F, F, T, T, T, F, T, T, T, T},
            {F, T, T, F, T, T, T, T, T, T},
            {T, F, T, T, T, T, T, F, T, T},
        };
        System.out.println(Park.steviloProstih(q));   // 23
    }
}
