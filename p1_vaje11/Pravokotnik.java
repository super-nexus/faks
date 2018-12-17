
public class Pravokotnik extends Lik{

    int a;
    int b;

    public int kojSamLik(){
        return 2;
    }

    public Pravokotnik(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int obseg(){
        return 2*a + 2*b;
    }

    public int ploscina(){
        return a*b;
    }

    public void izpisiPodatke(){
         System.out.printf("pravokotnik [a = %d, b = %d] | p = %d, o = %d\n", a, b, ploscina(), obseg());
    }

}
