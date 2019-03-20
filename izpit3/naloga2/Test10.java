
public class Test10 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(7);

        z.ponastavi(1);
        z.ponastavi(10);
        z.ponastavi(100);
        z.ponastavi(42);
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println("---");

        z.ponastavi(42);
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
    }
}
