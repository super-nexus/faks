
import java.lang.Math;

public class Krog extends Lik{

    int radij;
    
    public int kojSamLik(){
        return 1;
    }

    public Krog(int radij){
        this.radij = radij;
    }


    public int ploscina(){
        return (int) Math.round(Math.PI * this.radij * this.radij);
    }

    public int obseg(){
        return (int) Math.round(Math.PI * 2 * this.radij);
    }

    public void izpisiPodatke(){
        System.out.printf("krog [r = %d] | p = %d, o = %d\n", radij, ploscina(), obseg());
    }
}
