
public class Test08 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(5);
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.katero() );
        System.out.println("---");

        z.ponastavi(3);
        System.out.println( z.katero() );
        System.out.println( z.naslednje() );
        System.out.println( z.naslednje() );
    }
}
