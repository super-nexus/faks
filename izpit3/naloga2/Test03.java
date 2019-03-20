
public class Test03 {

    public static void main(String[] args) {
        Zaporedje z = new Zaporedje(10);
        for (int i = 0;  i < 20;  i++) {
            System.out.println( z.naslednje() );
        }
    }
}
