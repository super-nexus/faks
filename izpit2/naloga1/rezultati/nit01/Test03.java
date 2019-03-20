
public class Test03 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {

        boolean[][] p = {
            {F, T, T, T, T},
            {T, T, T, F, F},
            {F, F, F, T, T},
            {F, T, T, T, F},
        };
        System.out.println(Park.zaporedje(p, 1));   // true
        System.out.println(Park.zaporedje(p, 2));   // true
        System.out.println(Park.zaporedje(p, 3));   // true
        System.out.println(Park.zaporedje(p, 4));   // true
        System.out.println(Park.zaporedje(p, 5));   // false
    }
}
