
public class Test07 {

    private static final boolean T = true;
    private static final boolean F = false;

    public static void main(String[] args) {

        boolean[][][] g = 
        {
            {
                {T, F, T},
                {F, T, F},
                {T, F, T},
                {T, F, F},
                {F, T, F},
            },
            {
                {F, T, T},
                {T, F, F},
                {F, T, T},
                {F, T, F},
                {T, F, F},
            },
            {
                {T, T, F},
                {F, T, T},
                {F, F, T},
                {F, T, F},
                {T, T, F},
            },
            {
                {T, F, F},
                {T, T, T},
                {F, F, T},
                {F, T, F},
                {F, T, F},
            },
        };
        System.out.println(Park.steviloMest(g));  // 60
    }
}
