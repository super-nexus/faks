
// PostniNaslov / jeEnakKot

public class Test02 {

    public static void main(String[] args) {
        PostniNaslov a = new PostniNaslov("Sprednja 7", 1000, "Ljubljana");
        PostniNaslov b = new PostniNaslov("Zadnja 7", 1000, "Ljubljana");
        PostniNaslov c = new PostniNaslov("Sprednja 7", 1001, "Ljubljana");
        PostniNaslov d = new PostniNaslov("Sprednja 7", 2000, "Maribor");
        PostniNaslov e = new PostniNaslov("Sprednja 7", 1000, "Ljubljana");
        PostniNaslov f = a;

        System.out.println(a.jeEnakKot(a));
        System.out.println(a.jeEnakKot(b));
        System.out.println(a.jeEnakKot(c));
        System.out.println(a.jeEnakKot(d));
        System.out.println(a.jeEnakKot(e));
        System.out.println(a.jeEnakKot(f));

        System.out.println("----------------------------------");

        System.out.println(a == a);
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);
        System.out.println(a == e);
        System.out.println(a == f);

        System.out.println("----------------------------------");

        PostniNaslov fri1 = new PostniNaslov("Vecna pot 113", 1000, "Ljubljana");
        PostniNaslov fri2 = new PostniNaslov("Vecna pot 113", 1000, "Ljubljana");
        System.out.println(fri1.jeEnakKot(fri2));

        PostniNaslov fri3 = new PostniNaslov(new String("Vecna pot 113"), 1000, new String("Ljubljana"));
        PostniNaslov fri4 = new PostniNaslov(new String("Vecna pot 113"), 1000, new String("Ljubljana"));
        System.out.println(fri3.jeEnakKot(fri4));
    }
}
