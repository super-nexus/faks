
public class Test02 {

    public static void main(String[] args) {

        int[] podatki1 = {150, 70, 120, 190, 60, 130, 40, 100, 80, 60};
        Stolpci stolpci1 = new Stolpci(podatki1);
        for (int i = 0;  i < podatki1.length;  i++) {
            System.out.println(Platno.ri(stolpci1.visinaStolpca(i, 500, 700)));
            System.out.println(Platno.ri(stolpci1.visinaStolpca(i, 800, 600)));
        }

        int[] podatki2 = {5};
        Stolpci stolpci2 = new Stolpci(podatki2);
        for (int i = 0;  i < podatki2.length;  i++) {
            System.out.println(Platno.ri(stolpci2.visinaStolpca(i, 500, 700)));
            System.out.println(Platno.ri(stolpci2.visinaStolpca(i, 800, 600)));
        }

        int[] podatki3 = {2, 1, 2};
        Stolpci stolpci3 = new Stolpci(podatki3);
        for (int i = 0;  i < podatki3.length;  i++) {
            System.out.println(Platno.ri(stolpci3.visinaStolpca(i, 500, 700)));
            System.out.println(Platno.ri(stolpci3.visinaStolpca(i, 800, 600)));
        }
    }
}
