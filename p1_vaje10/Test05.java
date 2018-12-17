
// Oseba / steviloPrijateljev

public class Test05 {

    public static void main(String[] args) {
        PostniNaslov lj1 = new PostniNaslov("Sprednja 7", 1000, "Ljubljana");
        PostniNaslov lj2 = new PostniNaslov("Zadnja 10", 1000, "Ljubljana");
        PostniNaslov mb = new PostniNaslov("Zadnja 11",  2000, "Maribor");

        Oseba anka   = new Oseba("Anka Avbelj",     52, lj1);
        Oseba branko = new Oseba("Branko Brezovar", 58, mb);
        Oseba cvetka = new Oseba("Cvetka Cajzek",   65, lj2);
        Oseba drago  = new Oseba("Drago Debeljak",  48, mb);

        // nastavi prijateljstva
        Oseba.vzpostaviPrijateljstvo(anka, anka);
        Oseba.vzpostaviPrijateljstvo(anka, branko);
        Oseba.vzpostaviPrijateljstvo(anka, cvetka);
        Oseba.vzpostaviPrijateljstvo(anka, branko);
        Oseba.vzpostaviPrijateljstvo(branko, anka);
        Oseba.vzpostaviPrijateljstvo(cvetka, drago);

        Oseba[] osebe = {anka, branko, cvetka, drago};

        // izpiši število prijateljev posameznih oseb
        for (int i = 0;  i < osebe.length;  i++) {
            System.out.printf("%s: %d%n", osebe[i].vrniIP(), osebe[i].steviloPrijateljev());
        }
        System.out.println();
    }
}
