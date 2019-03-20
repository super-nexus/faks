// _NE_ODSTRANI_

public class Test04 {

    public static void main(String[] args) {

        Diagram.Skatla[] skatle = {
            new Diagram.Skatla(3, 2.0, 1.0),
            new Diagram.Skatla(1, 0.0, 7.0),
            new Diagram.Skatla(2, 7.0, 1.0),
            new Diagram.Skatla(4, 6.0, 5.0),
        };

        Diagram diagram = new Diagram(
            skatle,
            new Diagram.Povezava[0],
            10.0,  // dPapir
            2.0    // wSkatla
        );

        diagram.sproziRisanje(new String[]{"rezultat04.png", "800x800"});
    }
}
