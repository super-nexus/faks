
public class Test04 {

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
        System.out.println(Park.zaporedje(p, 1));   // true
        System.out.println(Park.zaporedje(p, 2));   // false
        System.out.println(Park.zaporedje(p, 3));   // false
        System.out.println(Park.zaporedje(p, 4));   // false
        System.out.println(Park.zaporedje(p, 5));   // false
    }
}
