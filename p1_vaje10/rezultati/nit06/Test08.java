
// Oseba / naIstemNaslovuKot

public class Test08 {

    public static void main(String[] args) {
        PostniNaslov naslovA = new PostniNaslov("Sprednja 7", 1000, "Ljubljana");
        PostniNaslov naslovB = new PostniNaslov("Sprednja 7", 1000, "Ljubljana");
        PostniNaslov naslovC = new PostniNaslov("Zadnja 3", 2000, "Maribor");

        Oseba osebaA = new Oseba("A A", 20, naslovA);
        Oseba osebaB = new Oseba("B B", 20, naslovB);
        Oseba osebaC = new Oseba("C C", 20, naslovC);

        System.out.println(osebaA.naIstemNaslovuKot(osebaA));
        System.out.println(osebaA.naIstemNaslovuKot(osebaB));
        System.out.println(osebaA.naIstemNaslovuKot(osebaC));
    }
}
