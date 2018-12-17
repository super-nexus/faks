
public class PostniNaslov {

    public String ulicaHS;  // ulica s hišno številko
    public int postnaStevilka;
    public String posta;

    /**
     * Ustvari nov objekt razreda PostniNaslov.
     */
    public PostniNaslov(String ulicaHS, int postnaStevilka, String posta) {
        this.ulicaHS = ulicaHS;
        this.postnaStevilka = postnaStevilka;
        this.posta = posta;
    }

    /** 
     * Vrne predstavitev poštnega naslova `this' v obliki niza.
     */
    public String toString() {
        // popravite / dopolnite ...
        return String.format("%s, %d %s", ulicaHS, postnaStevilka, posta);
    }

    /** 
     * Vrne `true' natanko v primeru, če objekt `pn' predstavlja isti poštni
     * naslov kot objekt `this'.
     */
    public boolean jeEnakKot(PostniNaslov pn) {
        // popravite / dopolnite ...
       // 
       
       return ((this.ulicaHS.equals(pn.ulicaHS) && this.postnaStevilka == pn.postnaStevilka && this.posta.equals(pn.posta)));
       //return this.equals(pn);
    }
}
