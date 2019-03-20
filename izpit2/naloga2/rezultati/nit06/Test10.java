
public class Test10 {

    public static void main(String[] args) {
        Snov snovA = new Snov("snovA");
        Snov snovB = new Snov("snovB");
        Snov snovC = new Snov("snovC");
        Snov snovD = new Snov("snovD");
        Snov snovE = new Snov("snovE");
        Snov snovF = new Snov("snovF");
        Snov snovG = new Snov("snovG");

        Korak[] koraki = {
            new Korak(new Snov[]{snovA}, new Snov[]{snovB}, "akcijaA", 60),
            new Korak(new Snov[]{snovB}, new Snov[]{snovC}, "akcijaB", 50),
            new Korak(new Snov[]{snovC}, new Snov[]{snovD}, "akcijaC", 40),
            new Korak(new Snov[]{snovD, snovE}, new Snov[]{snovF, snovG}, "akcijaD", 30)
        };

        Recept recept = new Recept(koraki);

        System.out.println(recept.steviloVstopnihSnovi());  // 2 (snovA, snovE)
    }
}
