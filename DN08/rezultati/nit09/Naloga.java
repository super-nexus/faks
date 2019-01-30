//63180178
// V prej"snji vrstici navedite svojo vpisno "stevilko.

import java.util.HashSet;

import java.util.Arrays;

public class Naloga {

    public static class Predmet {
        private int sifra; 
        private String naziv;
        private int kt;
        private int tip;
        private Modul modul;
        private Izvajalec[] izvajalci;

        public Predmet(int sifra, String naziv, int kt, int tip, Modul modul, Izvajalec[] izvajalci) {
            this.sifra = sifra;
            this.naziv = naziv;
            this.kt = kt;
            this.tip = tip;
            this.modul = modul;
            this.izvajalci = izvajalci;
        }

        @Override
        public String toString() {
            return String.format("%d (%s)", this.sifra, this.naziv);
        }

        public int returnKt(){
            return this.kt;
        }

        public int returnTip(){
            return this.tip;
        }
        public int returnIzvajalciLength(){
            return this.izvajalci.length;
        }
        public int returnSifra(){
            return this.sifra;
        }
        public String returnNaziv(){
            return this.naziv;
        }
        public Modul returnModul(){
            return this.modul;
        }
        public Izvajalec[] returnIzvajalci(){
            return izvajalci;
        }
    }

    public static class Modul {
        private int sifra;
        private String naziv;

        public Modul(int sifra, String naziv) {
            this.sifra = sifra;
            this.naziv = naziv;
        }

        @Override
        public String toString() {
            return String.format("%d (%s)", this.sifra, this.naziv);
        }

        public int returnSifra(){
            return this.sifra;
        }
    }

    public static class Izvajalec {
        private int sifra;
        private String ip;

        public Izvajalec(int sifra, String ip) {
            this.sifra = sifra;
            this.ip = ip;
        }

        @Override
        public String toString() {
            return String.format("%d (%s)", this.sifra, this.ip);
        }

        public int returnSifra(){
            return this.sifra;
        }
    }

    public static class Predmetnik {
        private Predmet[] predmeti;

        public Predmetnik(Predmet[] predmeti) {
            this.predmeti = predmeti;
        }

        public Predmet[] returnPredmeti(){
            return this.predmeti;
        }

        public int steviloKT() {

            int holder = 0;

            for(Predmet predmet : predmeti){
                holder += predmet.returnKt();
            }

            return holder;
        }

        public int[] tipiPredmetov() {

            int[] holder = new int[3];

            for(Predmet predmet : predmeti){
                holder[predmet.returnTip()] += 1;
            }

            return holder;
        }

        public Predmet predmetZNajvecIzvajalci() {

            Predmet holder = null;

            for(Predmet predmet : predmeti){
                if(holder == null || predmet.returnIzvajalciLength() >= holder.returnIzvajalciLength()){

                    if(holder == null){
                        holder = predmet;
                        continue;
                    }

                    if(predmet.returnIzvajalciLength() == holder.returnIzvajalciLength()){
                        if(predmet.returnSifra() < holder.returnSifra()){
                            holder = predmet;
                        }
                    }
                    else{
                        holder = predmet;
                    }
                }
            }

            return holder;

        }
   

        public int predmetiModula(int sifra, String[] nazivi) {

            int counter = 0;
            

            for(int i = 0; i < predmeti.length; i++){
                if(predmeti[i].returnTip() != 2){
                    continue;
                }

                if(predmeti[i].returnModul().returnSifra() == sifra){
                  //  nazivi = Arrays.copyOf(nazivi, counter + 1);
                    nazivi[counter] = predmeti[i].returnNaziv(); 
                    counter++;
                }

            }

            //nazivi = new String[]{"Operacijski sistemi", "Prevajalnik"};
             //System.out.println(Arrays.toString(nazivi));
            // System.out.println(counter);
            return counter;
        }

        public int modulSubjectLength(int sifra, Predmet[] predmeti){

            int counter = 0;

            for(Predmet predmet : predmeti){
                if(predmet.returnTip() != 2){continue;}
                if(predmet.returnModul().returnSifra() == sifra){
                    counter++;
                }
            }

            return counter;

        }

        public int steviloIzvajalcev() {

            HashSet<Integer> holder = new HashSet<>();

            for(Predmet predmet : predmeti){
                for(Izvajalec izvajalec : predmet.returnIzvajalci()){
                    holder.add(izvajalec.returnSifra());
                }
            }
            return holder.size();
        }

        public int steviloEnakoMocnihModulov(Predmetnik drugi) {

            HashSet<Integer> holder = new HashSet<>();

            for(Predmet predmetA : this.predmeti){

                if(predmetA.returnTip() != 2){
                    continue;
                }

                Modul currentModul = predmetA.returnModul();

                for(Predmet predmetB : drugi.returnPredmeti()){

                    if(predmetB.returnTip() != 2){
                        continue;
                    }

                    if(currentModul.returnSifra() == predmetB.returnModul().returnSifra()){
                        if(modulSubjectLength(currentModul.returnSifra(), this.predmeti) == modulSubjectLength(predmetB.returnModul().returnSifra(), drugi.returnPredmeti())){
                            holder.add(currentModul.returnSifra());
                        }
                    }
                }

            }

            return holder.size();
        }
    }
}
