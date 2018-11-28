import java.util.Scanner;


public class Zbor{

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        int[] arrayOfSoliders = populateArray(sc);

        returnLocalyCorrect(arrayOfSoliders);
    }
    public static int[] populateArray(Scanner sc){

        int length = sc.nextInt();
        int[] soldiers = new int[length];

        for(int i = 0; i < length; i++){
            soldiers[i] = sc.nextInt();
        }
        return soldiers;
    }


    public static void returnLocalyCorrect(int[] soldiers){

        boolean one = false;

        for(int i = 0; i < soldiers.length; i++){

            if(i == 0){
                if(soldiers[i] <= soldiers[i + 1]){
                    System.out.println(i);
                    one = true;
                }
                continue;
            }
            else if(i == (soldiers.length - 1)){
                if(soldiers[i] >= soldiers[i - 1]){
                    System.out.println(i);
                    one = true;
                }
                continue;
            }

            if((soldiers[i] >= soldiers[i - 1]) && soldiers[i] <= soldiers[i + 1] ){
                System.out.println(i);
                one = true;
            }

        }

        if(!one){
            System.out.println("NOBEDEN");
        }

    }

}