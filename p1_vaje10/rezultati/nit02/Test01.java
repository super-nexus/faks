
// PostniNaslov / toString

public class Test01 {

    public static void main(String[] args) {
        PostniNaslov a = new PostniNaslov("Sprednja 7", 1000, "Ljubljana");
        PostniNaslov b = new PostniNaslov("Zadnja 11",  2000, "Maribor");
        System.out.println(a.toString());
        System.out.println(b.toString());
    }
}
