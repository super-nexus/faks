
public class Test09 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(6);

        z.ponastavi(10);
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println("---");

        z.ponastavi(20);
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println("---");

        z.ponastavi(1);
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
    }
}
