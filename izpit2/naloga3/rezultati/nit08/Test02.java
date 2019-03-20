
public class Test02 {

    public static void main(String[] args) {

        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(2, 12.0, 13.0),
            new Diagram.Skatla(5, 3.0, 1.0),
            new Diagram.Skatla(7, 25.0, 5.0),
            new Diagram.Skatla(1, 3.0, 30.0),
            new Diagram.Skatla(3, 15.0, 21.0),
        };

        Diagram diagram = new Diagram(
            skatle,
            new Diagram.Povezava[]{
                new Diagram.Povezava(skatle[0], skatle[1]),
                new Diagram.Povezava(skatle[0], skatle[2]),
                new Diagram.Povezava(skatle[0], skatle[3]),
                new Diagram.Povezava(skatle[0], skatle[4]),
                new Diagram.Povezava(skatle[1], skatle[2]),
                new Diagram.Povezava(skatle[1], skatle[3]),
                new Diagram.Povezava(skatle[2], skatle[4]),
                new Diagram.Povezava(skatle[3], skatle[4]),
            },
            36.0,  // dPapir
            6.0    // wSkatla
        );

        double[] koord = diagram.sredisceSkatle(skatle[0], 360, 720);
        System.out.println(Platno.ri(koord[0]));
        System.out.println(Platno.ri(koord[1]));
    }
}
