
public class Tester{

    public static void main(String args[]){

        Datum datum = new Datum(6,9,2018);
        System.out.println(datum.toString());

        Datum datum2 = new Datum(6,9,2018);
        System.out.println(datum2.toString());

        System.out.println(datum2 == datum);
        System.out.println(datum2.toString() == datum.toString());


    }

}