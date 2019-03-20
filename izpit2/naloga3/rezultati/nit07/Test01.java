
public class Test01 {

    public static void main(String[] args) {

        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(3, 2.0, 1.0),
            new Diagram.Skatla(1, 0.0, 7.0),
            new Diagram.Skatla(2, 7.0, 1.0),
            new Diagram.Skatla(4, 6.0, 5.0),
        };

        Diagram diagram = new Diagram(
            skatle,
            new Diagram.Povezava[]{
                new Diagram.Povezava(skatle[0], skatle[1]),
                new Diagram.Povezava(skatle[0], skatle[2]),
                new Diagram.Povezava(skatle[0], skatle[3]),
                new Diagram.Povezava(skatle[2], skatle[3]),
            },
            10.0,   // dPapir
            2.0    // wSkatla
        );

        System.out.println(Platno.ri(diagram.sirinaSkatle(500, 300)));

    }
}
