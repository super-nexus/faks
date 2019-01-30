
public class Test01 {

    public static void main(String[] args) {

        Stolpci stolpci1 = new Stolpci(new int[]{150, 70, 120, 190, 60, 130, 40, 100, 80, 60});
        System.out.println(Platno.ri(stolpci1.sirinaStolpca(500, 700)));
        System.out.println(Platno.ri(stolpci1.sirinaStolpca(800, 600)));

        Stolpci stolpci2 = new Stolpci(new int[]{5});
        System.out.println(Platno.ri(stolpci2.sirinaStolpca(500, 700)));
        System.out.println(Platno.ri(stolpci2.sirinaStolpca(800, 600)));

        Stolpci stolpci3 = new Stolpci(new int[]{2, 1, 2});
        System.out.println(Platno.ri(stolpci3.sirinaStolpca(500, 700)));
        System.out.println(Platno.ri(stolpci3.sirinaStolpca(800, 600)));
    }
}
