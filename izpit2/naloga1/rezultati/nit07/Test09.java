
public class Test09 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {

        boolean[][][] g =
        {
            {
                {T, F},
                {F, T},
            },
            {
                {F, T},
                {T, T},
            },
            {
                {T, T},
                {F, F},
            },
            {
                {F, F},
                {F, F},
            },
        };
        System.out.println(Park.najboljProstoNadstropje(g));   // 1
    }
}
