import java.util.Scanner;

public class azman {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int dolzina = sc.nextInt();

        int[] tabela = new int[dolzina];
        int stevec = 0;

        while(sc.hasNextInt()){

            tabela[stevec] = sc.nextInt();
            stevec++;
        }

        int vsota = 0;
        int stevec2 = 1;
        boolean najdenPar = false;

        for(int i = 0; i < dolzina; i++){

            for(int j = i - 1; j >= 0; j--){

                if(tabela[i] < tabela[j]){
                    vsota += stevec2;
                    stevec2 = 1;
                    najdenPar = true;
                    break;
                }
                stevec2 += 1;
            }

            stevec2 = 1;

            if(!najdenPar){
                vsota += i + 1;
            }
            najdenPar = false;
        }

        System.out.println(vsota);

    }
}