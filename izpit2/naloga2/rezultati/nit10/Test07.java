
public class Test07 {

    public static void main(String[] args) {
        Snov snovA = new Snov("snovA");
        Snov snovB = new Snov("snovB");
        Snov snovC = new Snov("snovC");
        Snov snovD = new Snov("snovD");
        Snov snovE = new Snov("snovE");
        Snov snovF = new Snov("snovF");
        Snov snovG = new Snov("snovG");
        Snov snovH = new Snov("snovH");
        Snov snovI = new Snov("snovI");
        Snov snovJ = new Snov("snovJ");

        Korak[] koraki = {
            new Korak(new Snov[]{snovD, snovF, snovI}, new Snov[]{snovC, snovG, snovJ}, "akcijaA", 30),
            new Korak(new Snov[]{snovC, snovJ}, new Snov[]{snovH}, "akcijaB", 40),
            new Korak(new Snov[]{snovB, snovH, snovG}, new Snov[]{snovA}, "akcijaA", 50),
        };

        Recept recept = new Recept(koraki);

        System.out.println(snovA.naIzhodu(recept));  // true
        System.out.println(snovB.naIzhodu(recept));  // false
        System.out.println(snovC.naIzhodu(recept));  // true
        System.out.println(snovD.naIzhodu(recept));  // false
        System.out.println(snovE.naIzhodu(recept));  // false
        System.out.println(snovF.naIzhodu(recept));  // false
        System.out.println(snovG.naIzhodu(recept));  // true
        System.out.println(snovH.naIzhodu(recept));  // true
        System.out.println(snovI.naIzhodu(recept));  // false
        System.out.println(snovJ.naIzhodu(recept));  // true
    }
}
