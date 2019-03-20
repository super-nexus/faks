// _NE_ODSTRANI_

public class Test07 {

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
            new Diagram.Povezava[0],
            36.0,  // dPapir
            6.0    // wSkatla
        );

        diagram.sproziRisanje(new String[]{"rezultat07.png", "800x600"});
    }
}
