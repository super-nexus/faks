
public class Kvadrat extends Pravokotnik {

    public Kvadrat(int a){
        super(a, a);
    }

    public int kojSamLik(){
        return 3;
    }

    public void izpisiPodatke(){
        System.out.printf("kvadrat [a = %d] | p = %d, o = %d\n", a, ploscina(), obseg());
    }

}
