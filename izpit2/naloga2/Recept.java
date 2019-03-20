
/**
 * NALOGA 2
 */

public class Recept {    // kuharski recept

    private Korak[] koraki;    // koraki recepta

    public Recept(Korak[] koraki) {
        this.koraki = koraki;
    }

    public Korak[] vrniKorake() {
        return this.koraki;
    }

    /**
     * Naloga (a) -- vrne trajanje recepta v minutah.
     */
    public int trajanje() {

        int sum = 0;

        for(Korak k : koraki){
            sum += k.vrniTrajanje();
        }

        return sum;
    }

    /**
     * Naloga (b) -- vrne indeks prvega koraka s podano akcijo (-1, "ce te
     * akcije ni).
     */
    public int prviKorakZAkcijo(String akcija) {

        for(int i = 0; i < koraki.length; i++){
            if(koraki[i].vrniAkcijo() == akcija){
                return i;
            }
        }
        return -1;
    }

    /**
     * Naloga (d) -- vrne "stevilo snovi, ki se pojavljajo SAMO na vhodih v
     * korake recepta.
     */
    public int steviloVstopnihSnovi() {
        String[] nazivi = new String[100];
        int index = 0;

        for(Korak korak : koraki){
            for()
        }

    }
}
