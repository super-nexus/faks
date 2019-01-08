import java.util.Scanner;
import java.lang.Math;


public class Gabrijel {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int duzinaVremena = sc.nextInt() - 1;

        int ukupnoVreme = -1;

        int[] tabelaVremena = new int[duzinaVremena];

        ukupnoVreme++;

        for(int i = 0; i < duzinaVremena; i++){

            int vreme = sc.nextInt();

            ukupnoVreme += vreme;
            tabelaVremena[i] = vreme;

        }

        int brojPocetnih = sc.nextInt();
        int[][] pocetnaTabela = new int[brojPocetnih][2];

        for(int m = 0; m < brojPocetnih; m++){

            for(int r = 0; r < 2; r++){
                pocetnaTabela[m][r] = sc.nextInt();
            }

        }

        int cuvarBrojeva = 0;
        int najmanjiBrojNaSvetu = 0;
        int zbir = 0;
        boolean prviPut = true;

        for(int z = 0; z < brojPocetnih; z++){

            if(Math.abs(pocetnaTabela[z][0] - pocetnaTabela[z][1]) >= ukupnoVreme){
                continue;
            }

            for(int x = 0; x < duzinaVremena; x++){

                cuvarBrojeva += tabelaVremena[x];

                int razlika = pocetnaTabela[z][0] + cuvarBrojeva - (pocetnaTabela[z][1] + (ukupnoVreme - cuvarBrojeva));
                
                if(prviPut || Math.abs(razlika) < najmanjiBrojNaSvetu){
                    najmanjiBrojNaSvetu = Math.abs(razlika);
                    prviPut = false;
                }

            }
            zbir += najmanjiBrojNaSvetu;
            cuvarBrojeva = 0;
            najmanjiBrojNaSvetu = 0;
            prviPut = true;
        }

        System.out.println(zbir);

        sc.close();
    }
}
