
public class Test07 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(3);

        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println("---");

        z.ponastavi(1);
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println("---");

        z.ponastavi(5);
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
    }
}
