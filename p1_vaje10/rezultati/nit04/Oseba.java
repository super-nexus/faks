import java.util.ArrayList;

public class Oseba {

    // dopolnite ...
    String ip;
    int starost;
    PostniNaslov postniNaslov;
    public int steviloPrijateljev;
    public ArrayList<Oseba> prijatelji;

    /**
     * Ustvari nov objekt razreda Oseba.
     */
    public Oseba(String ip, int starost, PostniNaslov postniNaslov) {
        // dopolnite ...
        this.ip = ip;
        this.starost = starost;
        this.postniNaslov = postniNaslov;
        prijatelji = new ArrayList<Oseba>();
    }

    /**
     * Vrne ime in priimek osebe `this'.
     */
    public String vrniIP() {
        // popravite / dopolnite ...
        return this.ip;
    }

    public boolean jeIstaOsebaKot(Oseba os) {
        return this.ip == os.ip && this.starost == os.starost;
    }

    public static boolean jeIstaOsebaKot(Oseba prva, Oseba druga) {
        return prva.ip == druga.ip && prva.starost == druga.starost;
    }

    /**
     * Vrne niz z osnovnimi podatki o osebi `this'.
     */
    public String toString() {
        // popravite / dopolnite ...
        return String.format("%s (%d), %s", ip, starost, postniNaslov.toString());
    }

    /**
     * Vrne število prijateljev osebe `this'.
     */
    public int steviloPrijateljev() {
        // popravite / dopolnite ...
        return prijatelji.size();
    }

    /**
     * Vrne `true' natanko v primeru, če je oseba `this' prijatelj osebe `os'.
     */
    public boolean jePrijateljOd(Oseba os) {
        // popravite / dopolnite ...

        for (Oseba oseba : prijatelji) {

            if (oseba.jeIstaOsebaKot(os)) {
                return true;
            }

        }

        return false;
    }

    /**
     * Če sta osebi `prva' in `druga' različni in če še nista prijatelja, to
     * postaneta, sicer pa se ne zgodi nič.
     */

    public static void dodajPrijatelja(Oseba prva, Oseba druga) {
        prva.prijatelji.add(druga);
        druga.prijatelji.add(prva);
    }

    public static boolean vzpostaviPrijateljstvo(Oseba prva, Oseba druga) {
        // popravite / dopolnite ...
   

        if (prva != druga) {
            if (!prva.jePrijateljOd(druga)) {
                dodajPrijatelja(prva, druga);
                prva.steviloPrijateljev++;
                druga.steviloPrijateljev++;
                return true;
            }
        }

        return false;
    }

    /**
     * Vrne `true' natanko v primeru, če oseba `os' prebiva na istem poštnem naslovu
     * kot oseba `this'.
     */
    public boolean naIstemNaslovuKot(Oseba os) {
        // popravite / dopolnite ...
        return (this.postniNaslov.jeEnakKot(os.postniNaslov));
    }

    /**
     * Vrne število prijateljev osebe `this', ki živijo na istem poštnem naslovu kot
     * oseba `this'.
     */
    public int steviloPrijateljevNaIstemNaslovu() {
        // popravite / dopolnite ...
        int counter = 0;
        for(Oseba os : prijatelji){
            if(this.naIstemNaslovuKot(os)){
                counter++;
            }
        }
        return counter;
    }

    /**
     * Vrne najstarejšega prijatelja osebe `this' (prvega, če jih je več; null, če
     * jih ni).
     */
    public Oseba najstarejsiPrijatelj() {
        // popravite / dopolnite ...
        Oseba currentMax = null;
        for(Oseba os : prijatelji){
            if(currentMax == null || os.starost > currentMax.starost){
                currentMax = os;
            }
        }
        return currentMax;
    }
}
