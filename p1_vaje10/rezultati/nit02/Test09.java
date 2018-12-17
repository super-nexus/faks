
// Oseba / steviloPrijateljevNaIstemNaslovu

public class Test09 {

    public static void main(String[] args) {
        PostniNaslov lj1 = new PostniNaslov("Lepa 1",      1000, "Ljubljana");
        PostniNaslov lj2 = new PostniNaslov("Lepa 1",      1000, "Ljubljana");
        PostniNaslov mb1 = new PostniNaslov("Mirna 2a",    2000, "Maribor");
        PostniNaslov mb2 = new PostniNaslov("Mirna 2b",    2000, "Maribor");
        PostniNaslov ce =  new PostniNaslov("Centralna 3", 3000, "Celje");
        PostniNaslov kr =  new PostniNaslov("Krasna 4",    4000, "Kranj");
        PostniNaslov go =  new PostniNaslov("Gornja 5",    5000, "Nova Gorica");
        PostniNaslov kp =  new PostniNaslov("Kotna 6",     6000, "Koper");
        PostniNaslov nm =  new PostniNaslov("Mala 8",      8000, "Novo mesto");
        PostniNaslov ms =  new PostniNaslov("Samotna 9",   9000, "Murska Sobota");

        // skupina prijateljev
        Oseba anka   = new Oseba("Anka Avbelj",     52, lj1);
        Oseba branko = new Oseba("Branko Bizjak",   58, lj1);
        Oseba drago  = new Oseba("Drago Dolenc",    48, lj2);
        Oseba helga  = new Oseba("Helga Hrvatin",   56, kp);
        Oseba iva    = new Oseba("Iva Ivanc",       50, ce);
        Oseba lidija = new Oseba("Lidija Lebar",    41, ms);

        // skupina prijateljev
        Oseba ema    = new Oseba("Ema Ertl",        31, mb1);
        Oseba gregor = new Oseba("Gregor Golob",    33, mb1);
        Oseba katja  = new Oseba("Katja Kotnik",    25, mb2);

        // skupina prijateljev
        Oseba franci = new Oseba("Franci Frelih",   28, kr);

        // skupina prijateljev
        Oseba cvetka = new Oseba("Cvetka Cajzek",   68, ce);
        Oseba janko  = new Oseba("Janko Jereb",     65, go);

        Oseba[] osebe = {anka, branko, cvetka, drago, ema, franci, 
            gregor, helga, iva, janko, katja, lidija};

        // nastavi prijateljstva
        int[][] prijateljstva = {{0, 1, 3, 7, 8, 11}, {4, 6, 10}, {2, 9}, {5}};
        for (int[] p: prijateljstva) {
            for (int i = 0;  i < p.length - 1;  i++) {
                for (int j = i + 1;  j < p.length;  j++) {
                    Oseba.vzpostaviPrijateljstvo(osebe[p[i]], osebe[p[j]]);
                }
            }
        }

        // za vsako osebo izpiši število prijateljev na istem naslovu
        for (int i = 0;  i < osebe.length;  i++) {
            System.out.printf("%s: %d%n",
                    osebe[i].vrniIP(),
                    osebe[i].steviloPrijateljevNaIstemNaslovu() );
        }
    }
}
