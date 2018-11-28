//63180178

public class Bankomat{

    int[] steviloBankovcev = {0,0,0};
    int[] holderBankovcev = {0,0,0};
    int dolzinaBankovcev = 3;
    private static int najDvig = 0;
    private static Datum najDatum;

    public Bankomat(){
    }

    public int vrniN5(){
        return steviloBankovcev[0];
    }

    public int vrniN2(){
        return steviloBankovcev[1];
    }

    public int vrniN1(){
        return steviloBankovcev[2];
    }

    public void nalozi(int k5, int k2, int k1){
        steviloBankovcev[0] = steviloBankovcev[0] + k5;
        steviloBankovcev[1] = steviloBankovcev[1] + k2;
        steviloBankovcev[2] = steviloBankovcev[2] + k1;
    }

    public void izpisi(){
        System.out.printf("%d | %d | %d\n", steviloBankovcev[0], steviloBankovcev[1], steviloBankovcev[2]);
    }

    public int kolicinaDenarja(){
        return 5 * steviloBankovcev[0] + 2 * steviloBankovcev[1] + steviloBankovcev[2];
    }

    public boolean dvigni(int dvig, Datum datum){

        int[] holderBankovcev = steviloBankovcev.clone();
        int dvigHolder = dvig;

        if(kolicinaDenarja() < dvig) return false;

        if(dvig > najDvig){
            najDvig = dvig;
            najDatum = datum;
        }
        
        int kolicina5 = dvig / 5;

        for(int i = 0; i < kolicina5; i++){
            if(steviloBankovcev[0] > 0){
                dvig -= 5;
                steviloBankovcev[0] = steviloBankovcev[0] - 1;
            }
            else{
                break;
            }
        }

      //  System.out.println("Dvig after 5: " + dvig);
        int kolicina2 = dvig / 2;

        for(int m = 0; m < kolicina2; m++){

            if(steviloBankovcev[1] > 0){
                dvig -= 2;
                steviloBankovcev[1] = steviloBankovcev[1] - 1;
            }
            else{
                break;
            }
        }

      //  System.out.println("Dvig after 2: " + dvig);

        while(dvig > 0){
            if(steviloBankovcev[2] == 0 && dvig != 0){
                steviloBankovcev = holderBankovcev;
                return false;
            }
            dvig -= 1;
            steviloBankovcev[2] = steviloBankovcev[2] - 1;
        }
        
        
        //System.out.println("Dvig after 1: " + dvig);

        return true;
    }

    public int najDvig(){
        return najDvig;
    }

    public Datum najDatum(){
        return najDatum;
    }
}