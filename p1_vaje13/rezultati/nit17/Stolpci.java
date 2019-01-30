
import java.awt.*;

/**
 * Stolpci s povezovalno "crto in napisi.
 */
public class Stolpci extends Platno {

    public static void main(String[] args) {
        // V odvisnosti od argumentov ukazne vrstice bodisi ustvari okno in
        // plo"s"co ali pa pripravi sliko v pomnilniku, na katero je mo"zno
        // risati.  S stali"s"ca izdelave na"sega programa je to popolnoma
        // vseeno.

        int[] podatki = {150, 70, 120, 190, 60, 130, 40, 100, 80, 60};
        //int[] podatki = {5};
        //int[] podatki = {1, 1, 1};
        Stolpci stolpci = new Stolpci(podatki);
        stolpci.sproziRisanje(args);
    }

    // podatki, ki dolo"cajo vi"sine stolpcev
    private int[] podatki;
    private int biggest;

    public Stolpci(int[] podatki) {
        this.podatki = podatki;

        int currentMax = 0;
        for(int height : podatki){
            if(height > currentMax){
                currentMax = height;
            }
        }
        biggest = currentMax;
    }

    /**
     * Nari"se sliko na platno (zaslon ali slikovno datoteko).  To metodo
     * pokli"ce ogrodje, ko je "cas zanjo.
     * @param g objekt, ki nam omogo"ca risanje
     * @param wp "sirina platna
     * @param hp vi"sina platna
     */
    protected void narisi(Graphics2D g, double wp, double hp) {

        FontMetrics fm = g.getFontMetrics();

        int hPisava = fm.getAscent();

        double xColumn = 0.0;
        double yColumn = sirinaStolpca(wp, hp);

        for(int i = 0; i < podatki.length; i++){

            g.setColor(Color.ORANGE);
            g.fillRect((int)xColumn,(int)(hp - visinaStolpca(i, wp, hp)), (int) sirinaStolpca(wp, hp), (int) visinaStolpca(i, wp, hp));

            g.setColor(Color.RED);
            g.drawRect((int)((i)*sirinaStolpca(wp, hp)),(int) (hp-visinaStolpca(i, wp, hp)), (int)sirinaStolpca(wp, hp), (int)visinaStolpca(i, wp, hp));

            g.setColor(Color.BLUE);
            if(i < podatki.length - 1){
                double startCrtaX = sredinaVrha(i, wp, hp)[0];
                double startCrtaY = sredinaVrha(i, wp, hp)[1];

                double endCrtaX = sredinaVrha(i + 1, wp, hp)[0];
                double endCrtaY = sredinaVrha(i+1, wp, hp)[1];

                g.drawLine((int)startCrtaX,(int) startCrtaY,(int) endCrtaX,(int) endCrtaY);

            }

            g.setColor(Color.BLACK);

            String toWrite = Integer.toString(i+1);
            double wNapis=fm.stringWidth(toWrite);
            double xNapis=xColumn+(xColumn-wNapis)/2;
            double yNapisLowerLine=hp-hPisava;
            xColumn+=sirinaStolpca(wp, hp);
            g.drawString(toWrite,ri (xNapis),ri(yNapisLowerLine));

        }

    }

    /**
     * Vrne "sirino (v pikslih) posameznega stolpca.
     */
    public double sirinaStolpca(double wp, double hp) {
        // popravite / dopolnite ...
        return wp/this.podatki.length;
    }

    /**
     * Vrne vi"sino (v pikslih) stolpca s podanim indeksom.
     */
    public double visinaStolpca(int ixStolpec, double wp, double hp) {
        // popravite / dopolnite ...
        return hp/biggest * podatki[ixStolpec];
    }

    /**
     * Vrne koordinati (v pikslih) sredine zgornjega roba stolpca s podanim indeksom.
     * @return tabela z dvema elementoma ({x, y}).
     */
    public double[] sredinaVrha(int ixStolpec, double wp, double hp) {
        // popravite / dopolnite ...
        double[] sredina = new double[2];
        double widthSredina = sirinaStolpca(wp, hp)/2 * (1 + 2 * ixStolpec);

        double heightSredina = hp -  visinaStolpca(ixStolpec, wp, hp);

        sredina[0] = widthSredina;
        sredina[1] = heightSredina;

        return sredina;
    }
}
