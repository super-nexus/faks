public class Prim {


    public static interface Primerjalnik{
        public boolean jePred(Lik a, Lik b);
    }

    public static class PrimerjalnikPloscina implements Primerjalnik{
        public boolean jePred(Lik a, Lik b){
            return a.ploscina() > b.ploscina();
        }
    }

    public static class PrimerjalnikTip implements Primerjalnik{
        public boolean jePred(Lik a, Lik b){
            return a.kojSamLik() > b.kojSamLik();
        }
    }

    public static class Obrat implements Primerjalnik{
        private Primerjalnik izhodisce;
        public Obrat(Primerjalnik prim){
            izhodisce = prim;
        }

        @Override
        public boolean jePred(Lik a, Lik b) {
            return this.izhodisce(b, a);
        }
    }


    public static class Kombinacija implements Primerjalnik{

        Primerjalnik prvi;
        Primerjalnik drugi;

        public Kombinacija(Primerjalnik prvi, Primerjalnik drugi){
            this.prvi = prvi;
            this.drugi = drugi;
        }

        @Override
        public boolean jePred(Lik a, Lik b) {
            if(this.prvi.jePred(a, b)){
                return true;
            }
            if(this.prvi.jePred(b, a)) return false;

            return drugi.jePred(a, b);

        }

    }

}