
// Oseba / vzpostaviPrijateljstvo

public class Test04 {

    public static void main(String[] args) {
        PostniNaslov lj1 = new PostniNaslov("Sprednja 7", 1000, "Ljubljana");
        PostniNaslov lj2 = new PostniNaslov("Zadnja 10", 1000, "Ljubljana");
        PostniNaslov mb = new PostniNaslov("Zadnja 11",  2000, "Maribor");

        Oseba anka   = new Oseba("Anka Avbelj",     52, lj1);
        Oseba branko = new Oseba("Branko Brezovar", 58, mb);
        Oseba cvetka = new Oseba("Cvetka Cajzek",   65, lj2);
        Oseba drago  = new Oseba("Drago Debeljak",  48, mb);

        System.out.println(Oseba.vzpostaviPrijateljstvo(anka, anka));
        System.out.println(Oseba.vzpostaviPrijateljstvo(anka, branko));
        System.out.println(Oseba.vzpostaviPrijateljstvo(anka, cvetka));
        System.out.println(Oseba.vzpostaviPrijateljstvo(anka, branko));
        System.out.println(Oseba.vzpostaviPrijateljstvo(branko, anka));
        System.out.println(Oseba.vzpostaviPrijateljstvo(cvetka, drago));
    }
}
