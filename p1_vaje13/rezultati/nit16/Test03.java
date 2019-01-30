
public class Test03 {

    public static void main(String[] args) {

        int[] podatki1 = {150, 70, 120, 190, 60, 130, 40, 100, 80, 60};
        Stolpci stolpci1 = new Stolpci(podatki1);
        for (int i = 0;  i < podatki1.length;  i++) {
            double[] vrh = stolpci1.sredinaVrha(i, 500, 700);
            System.out.printf("%d %d%n", Platno.ri(vrh[0]), Platno.ri(vrh[1]));
            vrh = stolpci1.sredinaVrha(i, 800, 600);
            System.out.printf("%d %d%n", Platno.ri(vrh[0]), Platno.ri(vrh[1]));
        }

        int[] podatki2 = {5};
        Stolpci stolpci2 = new Stolpci(podatki2);
        for (int i = 0;  i < podatki2.length;  i++) {
            double[] vrh = stolpci2.sredinaVrha(i, 500, 700);
            System.out.printf("%d %d%n", Platno.ri(vrh[0]), Platno.ri(vrh[1]));
            vrh = stolpci2.sredinaVrha(i, 800, 600);
            System.out.printf("%d %d%n", Platno.ri(vrh[0]), Platno.ri(vrh[1]));
        }

        int[] podatki3 = {2, 1, 2};
        Stolpci stolpci3 = new Stolpci(podatki3);
        for (int i = 0;  i < podatki3.length;  i++) {
            double[] vrh = stolpci3.sredinaVrha(i, 500, 700);
            System.out.printf("%d %d%n", Platno.ri(vrh[0]), Platno.ri(vrh[1]));
            vrh = stolpci3.sredinaVrha(i, 800, 600);
            System.out.printf("%d %d%n", Platno.ri(vrh[0]), Platno.ri(vrh[1]));
        }
    }
}
