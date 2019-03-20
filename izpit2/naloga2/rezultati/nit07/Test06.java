
public class Test06 {

    public static void main(String[] args) {
        Snov moka = new Snov("moka");
        Snov jajca = new Snov("jajca");
        Snov sol = new Snov("sol");
        Snov mleko = new Snov("mleko");
        Snov testo = new Snov("testo");
        Snov olje = new Snov("olje");
        Snov palacinke = new Snov("palacinke");

        Korak[] koraki = {
            new Korak(new Snov[]{moka, jajca, sol, mleko}, new Snov[]{testo}, "zmesaj", 20),
            new Korak(new Snov[]{testo, olje}, new Snov[]{palacinke}, "ocvri", 10)
        };

        Recept recept = new Recept(koraki);

        System.out.println(moka.naIzhodu(recept));       // false
        System.out.println(testo.naIzhodu(recept));      // true
        System.out.println(olje.naIzhodu(recept));       // false
        System.out.println(palacinke.naIzhodu(recept));  // true
    }
}
