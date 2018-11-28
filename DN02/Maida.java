import java.util.Scanner;

public class Maida {

    public static void main(String args[]) {

        int prviBroj = 0;
        int drugiBroj = 0;
        boolean regularanWhile = false;
        int brojac = 1;
        int razlicitiBrojevi = 1;
        int najveciRazlicitiBroj = 1;

        Scanner scanner = new Scanner(System.in);
        int zadatak = scanner.nextInt();

        if (zadatak == 1) {
            System.out.println(scanner.nextInt());
        } 
        else if (zadatak == 2) {

            while (scanner.hasNext()) {
                prviBroj = scanner.nextInt();
            }
            System.out.println(prviBroj);
        } else if (zadatak == 3) {

            while (scanner.hasNext()) {

                if (!regularanWhile) {
                    prviBroj = scanner.nextInt();
                    regularanWhile = true;
                } else {
                    drugiBroj = prviBroj;
                    prviBroj = scanner.nextInt();
                }
            }

            System.out.println(prviBroj + drugiBroj);
        } else if (zadatak == 4) {

            while (scanner.hasNext()) {

                if (!regularanWhile) {
                    prviBroj = scanner.nextInt();
                    regularanWhile = true;
                } else {

                    drugiBroj = prviBroj;
                    prviBroj = scanner.nextInt();

                    if(prviBroj >= drugiBroj){
                        brojac += 1;
                    }
                    else{
                        System.out.println(brojac);
                        break;
                    }
                }

            }
        }
        else if(zadatak == 5){

            while (scanner.hasNext()) {

                if (regularanWhile) {
                    prviBroj = scanner.nextInt();
                    regularanWhile = true;
                } else {
                    drugiBroj = prviBroj;
                    prviBroj = scanner.nextInt();

                    if(prviBroj >= drugiBroj){
                        if(prviBroj != drugiBroj){
                            razlicitiBrojevi += 1;
                        }
                    }
                    else{
                        if(razlicitiBrojevi > najveciRazlicitiBroj){
                            najveciRazlicitiBroj = razlicitiBrojevi;
                        }
                        razlicitiBrojevi = 1;
                    }
                }
            }
            if(razlicitiBrojevi > najveciRazlicitiBroj){
                najveciRazlicitiBroj = razlicitiBrojevi;
            }

            System.out.println(najveciRazlicitiBroj);
        }

    }

}
