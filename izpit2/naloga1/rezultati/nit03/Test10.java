
public class Test10 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {

        boolean[][][] g =
        {
            {
                {F, F},
                {F, F},
                {F, F},
            },
            {
                {F, F},
                {F, F},
                {F, F},
            },
            {
                {F, F},
                {F, F},
                {F, F},
            },
            {
                {F, F},
                {F, F},
                {F, F},
            },
        };
        System.out.println(Park.najboljProstoNadstropje(g));   // 0
    }
}
