//63180178

abstract class Izraz {

    public final static char open_bracket = '(';
    public final static char closed_bracket = ')';
    public final static char plus = '+';
    public final static char minus = '-';
    public final static char multiply = '*';
    public final static char divide = '/';
    public static final char hashtag = '#';

    //private static int numberOfOperators = 0;

    public static Izraz zgradi(String niz) {

        Izraz holder;
        boolean go = false;
        String nizHolder = niz;

        char furthestRight = hashtag;
        int furthestIndex = -1;

        if (niz.length() == 1) {
            return new Stevilo(Integer.parseInt(niz));
        }

        // while (!go) {

        //     // System.out.println("Bracket trimmer: " + nizHolder);

        //     if (nizHolder.charAt(0) == open_bracket && nizHolder.charAt(nizHolder.length() - 1) == closed_bracket) {
        //         nizHolder = nizHolder.substring(1, nizHolder.length() - 1);
        //         // System.out.println("After brackets: " + nizHolder);
        //     } else {
        //         go = true;
        //     }

        // }

      //  numberOfOperators++;

        // if(nizHolder.length() == 3){
        // return new SestavljenIzraz(new
        // Stevilo(Integer.parseInt(Character.toString(nizHolder.charAt(0)))),
        // nizHolder.charAt(1), new
        // Stevilo(Integer.parseInt(Character.toString(nizHolder.charAt(2)))));
        // }

        for (int i = 0; i < nizHolder.length(); i++) {

            if (nizHolder.charAt(i) == open_bracket) {
                i++;
                // while (nizHolder.charAt(i) != closed_bracket) {
                //     i++;
                // }
               // System.out.println("Niz length " + Integer.toString(nizHolder.length()));
                i = passTheBrackets2(nizHolder, i);
               // System.out.println("i: " + Integer.toString(i));
                if(i == nizHolder.length() - 1){
                    return zgradi(nizHolder.substring(1, nizHolder.length() - 1));
                }
            }

            char currentChar = nizHolder.charAt(i);

            if (currentChar == minus || currentChar == plus) {
                furthestRight = currentChar;
                furthestIndex = i;
            } else if ((currentChar == multiply || currentChar == divide)
                    && ((furthestRight == hashtag) || furthestRight == divide || furthestRight == multiply)) {
                furthestRight = currentChar;
                furthestIndex = i;
            }

        }

        String leftString = nizHolder.substring(0, furthestIndex);
        char operator = nizHolder.charAt(furthestIndex);
        String rightString = nizHolder.substring(furthestIndex + 1, nizHolder.length());

      //  System.out.println(leftString + " " + operator + " " + rightString);

        return new SestavljenIzraz(zgradi(leftString), operator, zgradi(rightString));
    }

    public static int passTheBrackets(String niz, int i) {

            System.out.println("Niz: " + niz.substring(i, niz.length()));
            System.out.println("i: " + Integer.toString(i));

            boolean first = true;

            if(i >= niz.length()) return i;

            while (niz.charAt(i) != closed_bracket) {
                if(niz.charAt(i) == open_bracket){
                    i = passTheBrackets(niz, i+1);
                    first = false;
                }
                i++;
            }
        return i;
    }

    public static int passTheBrackets2(String niz, int i){

        int counter = 1;
        int holder = 0;

       // System.out.println("Running with i: " + Integer.toString(i) + " and Niz: " + niz);

        for(int m = i; m < niz.length(); m++){
            if(niz.charAt(m) == closed_bracket){
                counter--;
                if(counter == 0){
                    return m;
                }
            }
            else if(niz.charAt(m) == open_bracket){
                counter++;
            }
            holder = m;
        }
        return holder;
    }

    public int steviloOperatorjev() {
        return 0;
    }

    public String postfiksno() {
        return null;
    }

    public int vrednost() {
        return 0;
    }

}

class Stevilo extends Izraz {

    int stevilo;

    public Stevilo(int n) {
        stevilo = n;
    }

    public int vrednost() {
        return stevilo;
    }

    public String postfiksno() {
        return Integer.toString(stevilo);
    }

}

class SestavljenIzraz extends Izraz {

    Izraz levi;
    Izraz desni;
    char operator;
    static int stOperatorjev = 0;

    public SestavljenIzraz(Izraz levi, char operator, Izraz desni) {

        this.levi = levi;
        this.desni = desni;
        this.operator = operator;
        stOperatorjev++;

    }

    public int vrednost() {

        switch (operator) {
        case plus:
            return levi.vrednost() + desni.vrednost();
        case minus:
            return levi.vrednost() - desni.vrednost();
        case multiply:
            return levi.vrednost() * desni.vrednost();
        case divide:
            return levi.vrednost() / desni.vrednost();
        default:
            System.out.println("error");
            return 0;
        }

    }

    public String postfiksno() {
        return levi.postfiksno() + desni.postfiksno() + Character.toString(operator);
    }

    public int steviloOperatorjev(){
        return this.stOperatorjev;
    }
}