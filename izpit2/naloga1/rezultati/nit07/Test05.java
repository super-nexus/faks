
public class Test05 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {

        boolean[][] p = {
            {F, F, T, T, T, F, T, T, T, T},
            {F, T, T, F, T, T, T, T, T, T},
            {T, F, T, T, T, T, T, F, T, T},
        };
        System.out.println(Park.zaporedje(p, 20));  // false
        System.out.println(Park.zaporedje(p, 8));   // false
        System.out.println(Park.zaporedje(p, 7));   // false
        System.out.println(Park.zaporedje(p, 6));   // true
        System.out.println(Park.zaporedje(p, 5));   // true
    }
}
