
/**
 * NALOGA 3
 */

import java.awt.*;
import java.util.*;

public class Piramida extends Platno {

    public static void main(String[] args) {
        Piramida piramida = new Piramida(4);
        piramida.sproziRisanje(args);
    }

    private int visina;   // vi"sina piramide

    public Piramida(int visina) {
        this.visina = visina;
    }

    //-------------------------------------------------------------------------
    // Dopolnite / spremenite ...
    //
    // Za zaokro"zevanje double -> int uporabite metodo ri, npr. ri(2.7) = 3.
    //-------------------------------------------------------------------------
    protected void narisi(Graphics2D g, double wp, double hp) {

        double x = wp/2 - sirinaBloka(wp, hp)/2;
        double y = 0;

        for(int i = 0; i < visina; i++){
            
            y = i * visinaBloka(wp, hp);
            x = wp/2 - sirinaBloka(wp, hp)/2 - (i * sirinaBloka(wp, hp)/2);

            for(int m = 0; m <= i ; m++){

                g.setColor(Color.YELLOW);

                g.fillRect(ri(x), ri(y), ri(sirinaBloka(wp, hp)), ri(visinaBloka(wp, hp)));

                g.setColor(Color.BLACK);
                g.drawRect(ri(x), ri(y), ri(sirinaBloka(wp, hp)), ri(visinaBloka(wp, hp)));

                x+= sirinaBloka(wp, hp);

            }

        }


    }

    //-------------------------------------------------------------------------
    // Dopolnite / spremenite ...
    //-------------------------------------------------------------------------
    public double sirinaBloka(double wp, double hp) {
        return wp/visina;
    }

    //-------------------------------------------------------------------------
    // Dopolnite / spremenite ...
    //-------------------------------------------------------------------------
    public double visinaBloka(double wp, double hp) {
        return hp/visina;
    }
}
