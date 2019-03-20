import java.util.Scanner;
import java.util.ArrayList;


public class Edditor{

    
    private static final String hashtag = "#";
    private static final String undo = "<";
    private static final String redo = ">";
    private static final String add = "+";
    private static final String remove = "-";
    private static final String slash = "/";

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        ArrayList<String> doc = new ArrayList<>();

        while(sc.hasNext()){

            String currentCommand = sc.next();
          //  System.out.println("Current command:" + currentCommand);

            switch(currentCommand){

                case hashtag:

                    break;

                case add:

                    break;

                case remove:

                    break;
                
                case undo:

                    break;                    
            }

        }
    }

}


class Znak{

    String type, text = null;
    int index = -1;
    int price = 0;

}