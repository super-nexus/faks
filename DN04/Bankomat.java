//63180178

public class Bankomat {

    int[] steviloBankovcev = { 0, 0, 0 };
    int[] holderBankovcev = { 0, 0, 0 };
    int dolzinaBankovcev = 3;
    private int najDvig = 0;
    private Datum najDatum = null;
    private Datum currentDatum = new Datum(1,1,1);
    private int currentSum = 0;
    private int highestSum = 0;

    public Bankomat() {
    }

    public int vrniN5() {
        return steviloBankovcev[0];
    }

    public int vrniN2() {
        return steviloBankovcev[1];
    }

    public int vrniN1() {
        return steviloBankovcev[2];
    }

    public void nalozi(int k5, int k2, int k1) {
        steviloBankovcev[0] = steviloBankovcev[0] + k5;
        steviloBankovcev[1] = steviloBankovcev[1] + k2;
        steviloBankovcev[2] = steviloBankovcev[2] + k1;
    }

    public void izpisi() {
        System.out.printf("%d | %d | %d\n", steviloBankovcev[0], steviloBankovcev[1], steviloBankovcev[2]);
    }

    public int kolicinaDenarja() {
        return 5 * steviloBankovcev[0] + 2 * steviloBankovcev[1] + steviloBankovcev[2];
    }

    public boolean dvigni(int dvig, Datum datum) {

        int[] holderBankovcev = steviloBankovcev.clone();
        int dvigHolder = dvig;

        if (kolicinaDenarja() < dvig)
            return false;

        if (tryOptimal(steviloBankovcev, dvig)) {
            this.steviloBankovcev = doOptimal(this.steviloBankovcev, dvig);
        }
        else if(tryWithoutOne(steviloBankovcev, dvig)){
            this.steviloBankovcev = doWithoutOne(steviloBankovcev, dvig);   
        }
        else if (tryWithTwo(this.steviloBankovcev, dvig)) {
            this.steviloBankovcev = this.doWithTwo(this.steviloBankovcev, dvig);
        } 
     
        else {
            if (steviloBankovcev[2] >= dvig) {
                steviloBankovcev[2] = steviloBankovcev[2] - dvig;
            } else {
                return false;
            }
        }

       // System.out.printf("Dvig: %d , datum: %s\n", dvigHolder, datum.toString());

        // if (dvigHolder >= najDvig && datum.isYoungerThan(najDatum)) {
        //      najDvig = dvigHolder;
        //      najDatum = datum;
        // }

        if(dvigHolder > najDvig){
            najDvig = dvigHolder;
        }

        if(najDatum == null){
            najDatum = datum;
        }

        if(datum.jeEnakKot(currentDatum)){
            currentSum += dvigHolder;
            if(currentSum > highestSum){
                najDatum = datum;
            }
        }
        else{
            if(highestSum < currentSum){
                highestSum = currentSum;
                najDatum = currentDatum;
                currentSum = dvigHolder;
                currentDatum = datum;
            }
            else{
                currentDatum = datum;
                currentSum = dvigHolder;
            }
        }
      
     //   System.out.printf("Current sum: %d Highest sum: %d Current Datum: %s NajDatum: %s\n", currentSum, highestSum, currentDatum.toString(), najDatum.toString());

        return true;
    }

    private int[] doOptimal(int[] steviloBankovcev, int dvig) {
        int kolicina5 = dvig / 5;

        int[] holderArray = steviloBankovcev.clone();

        for (int i = 0; i < kolicina5; i++) {
            if (holderArray[0] > 0) {
                dvig -= 5;
                holderArray[0] = holderArray[0] - 1;
            } else {
                break;
            }
        }

        //System.out.println("Dvig after 5: " + dvig);
        int kolicina2 = dvig / 2;

        for (int m = 0; m < kolicina2; m++) {

            if (holderArray[1] > 0) {
                dvig -= 2;
                holderArray[1] = holderArray[1] - 1;
            } else {
                break;
            }
        }

        //System.out.println("Dvig after 2: " + dvig);

        while (dvig > 0) {
            if ((holderArray[2] == 0) && (dvig != 0)) {
                // holderArray = holderBankovcev;
                break;
            }
            dvig -= 1;
            holderArray[2] = holderArray[2] - 1;
        }
        return holderArray;
    }

    private boolean tryOptimal(int[] steviloBankovcev, int dvig) {

        int kolicina5 = dvig / 5;
        int[] holderArray = steviloBankovcev.clone();

        for (int i = 0; i < kolicina5; i++) {
            if (holderArray[0] > 0) {
                dvig -= 5;
                holderArray[0] = holderArray[0] - 1;
            } else {
                break;
            }
        }

      // System.out.println("Dvig after 5: " + dvig);
        int kolicina2 = dvig / 2;

        for (int m = 0; m < kolicina2; m++) {

            if (holderArray[1] > 0) {
                dvig -= 2;
                holderArray[1] = holderArray[1] - 1;
            } else {
                break;
            }
        }

       //  System.out.println("Dvig after 2: " + dvig);

        while (dvig > 0) {
            if (holderArray[2] == 0 && dvig != 0) {
               // holderArray = holderBankovcev;
                return false;
            }
            dvig -= 1;
            holderArray[2] = holderArray[2] - 1;
        }

      //  System.out.println("Array after 1: " + Arrays.toString(holderArray));

        if (dvig == 0)
            return true;
        return false;
    }

    private boolean tryWithTwo(int[] steviloBankovcev, int dvig) {

        int divider = dvig / 2;
        int remainder = dvig % 2;

        int[] holderArray = steviloBankovcev.clone();

        if (holderArray[1] >= divider && holderArray[2] >= remainder) {

           // System.out.println("Inside if");

          //  System.out.println("Before 2: " + dvig);
            for (int i = 0; i < divider; i++) {
                holderArray[1] = holderArray[1] - 1;
                dvig -= 2;
            }
           // System.out.println("Before1 :" + dvig );
            while (dvig > 0) {
                // if (holderArray[2] <= 0 && dvig != 0){
                //     return false;
                // }
                holderArray[2] = holderArray[2] - 1;
                dvig--;
            }

          //  System.out.println("END: " + Arrays.toString(holderArray));

            if (dvig == 0)
                return true;
            return false;
        } else {
            return false;
        }
    }

    private int[] doWithTwo(int[] steviloBankovcev, int dvig) {
        int divider = dvig / 2;


        int[] holderArray = steviloBankovcev.clone();

        for (int i = 0; i < divider; i++) {
            holderArray[1] = holderArray[1] - 1;
            dvig -= 2;
        }
        while (dvig > 0) {
            // if (holderArray[2] <= 0)
            //     return null;
            holderArray[2] = holderArray[2] - 1;
            dvig--;
        }

      //  System.out.println("END: " + Arrays.toString(holderArray));

        return holderArray;
    }

    private boolean tryWithoutOne(int[] steviloBankovcev, int dvig){

        int[] holderArray = steviloBankovcev.clone();
        int divider = dvig / 5;
        int remainder = dvig % 5;
        boolean isDivisible = false;

        while(divider > 0){

            if(remainder % 2 == 0){
                isDivisible = true;
                break;
            }
            else{
                divider--;
                remainder = (dvig - (5 * divider));
            }
        }

        int numberOfTwos = ((dvig - (5 * divider)) / 2);

        if(holderArray[0] >= divider && holderArray[1] >= numberOfTwos){
            return isDivisible;
        }
        else{
            return false;
        }
        
    }

    private int[] doWithoutOne(int[] steviloBankovcev, int dvig){

        int[] holderArray = steviloBankovcev.clone();

        int divider = dvig / 5;
        int remainder = dvig % 5;
       
        while(divider > 0){

            if(remainder % 2 == 0){
                //isDivisible = true;
                break;
            }
            else{
                divider--;
                remainder = (dvig - (5 * divider));
            }
        }

        holderArray[0] = holderArray[0] - divider;
        holderArray[1] = holderArray[1] - ((dvig - (5 * divider)) / 2);
        return holderArray;
    }

    public int najDvig() {
        return najDvig;
    }

    public Datum najDatum() {
        return najDatum;
    }
}