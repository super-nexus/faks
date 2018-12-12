import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;

public class DN06_63180178 {

    static int seaCells = 0;
    static int countries = 0;

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int height = sc.nextInt();
        int width = sc.nextInt();

        int[][] holderTable = new int[height][width];

        for (int m = 0; m < height; m++) {
            for (int n = 0; n < width; n++) {

                int currentNumber = sc.nextInt();

                if (currentNumber > countries) {
                    countries = currentNumber;
                }

                if (currentNumber == 0) {
                    seaCells++;
                }

                holderTable[m][n] = currentNumber;
            }
        }

        // System.out.println(Arrays.deepToString(holderTable));

        int ukaz = sc.nextInt();

        switch (ukaz) {

        case 1:
            System.out.println(countries);
            break;
        case 2:
            System.out.println(seaCells);
            break;
        case 3:
            printCoastline(holderTable, height, width);
            break;
        case 4:
            printBorderingCountries(holderTable, height, width);
            break;

        }

    }

    private static void printCoastline(int[][] map, int height, int width) {

        int[] holder = new int[countries];

        for (int m = 0; m < height; m++) {

            for (int n = 0; n < width; n++) {

                int currentCountrie = map[m][n];

                if (currentCountrie == 0) {
                    continue;
                }

                if (m == 0) {
                    holder[currentCountrie - 1]++;
                    continue;
                } else if (m == (height - 1)) {
                    holder[currentCountrie - 1]++;
                    continue;
                } else {
                    if (map[m + 1][n] == 0) {
                        holder[currentCountrie - 1]++;
                        continue;
                    }
                    if (map[m - 1][n] == 0) {
                        holder[currentCountrie - 1]++;
                        continue;
                    }
                }

                if (n == 0) {
                    holder[currentCountrie - 1]++;
                    continue;
                } else if (n == (width - 1)) {
                    holder[currentCountrie - 1]++;
                    continue;
                } else {
                    if (map[m][n + 1] == 0) {
                        holder[currentCountrie - 1]++;
                        continue;
                    }
                    if (map[m][n - 1] == 0) {
                        holder[currentCountrie - 1]++;
                    }
                }

            }

        }

        for (int i : holder) {

            System.out.println(i);

        }
    }

    private static void printBorderingCountries(int[][] map, int height, int width) {

        int mostHomies = 0;
        int countrie = -1;
        // int[] countrieHolder = new int[countries];
        Countrie[] gzuz = new Countrie[countries];

        for (int z = 0; z < countries; z++) {
            Countrie srbija = new Countrie(z + 1);
            gzuz[z] = srbija;
        }

        for (int i = 0; i < height; i++) {

            for (int n = 0; n < width; n++) {

                int currentCountrie = map[i][n];

                if (currentCountrie == 0) {
                    continue;
                }

                Countrie holderCountrie = gzuz[currentCountrie - 1];

                if (i == 0) {
                    int below = map[i + 1][n];
                    if (below != 0) {
                        holderCountrie.addKomsija(holderCountrie, gzuz[below - 1]);
                    }
                } else if (i == (height - 1)) {

                    int above = map[i - 1][n];
                    if (above != 0) {
                        holderCountrie.addKomsija(holderCountrie, gzuz[map[i - 1][n] - 1]);
                    }
                } else {
                    int below = map[i + 1][n];
                    int above = map[i - 1][n];

                    if (below != 0) {
                        holderCountrie.addKomsija(holderCountrie, gzuz[map[i + 1][n] - 1]);
                    }
                    if (above != 0) {
                        holderCountrie.addKomsija(holderCountrie, gzuz[map[i - 1][n] - 1]);
                    }
                }

                if (n == 0) {
                    int right = map[i][n + 1];
                    if (right != 0) {
                        holderCountrie.addKomsija(holderCountrie, gzuz[right - 1]);
                    }
                } else if (n == (width - 1)) {
                    int left = map[i][n - 1];
                    if (left != 0) {
                        holderCountrie.addKomsija(holderCountrie, gzuz[left - 1]);
                    }
                } else {
                    int right = map[i][n + 1];
                    int left = map[i][n - 1];
                    if (right != 0) {
                        holderCountrie.addKomsija(holderCountrie, gzuz[map[i][n + 1] - 1]);
                    }
                    if (left != 0) {
                        holderCountrie.addKomsija(holderCountrie, gzuz[map[i][n - 1] - 1]);
                    }
                }

            }

        }

        for (Countrie c : gzuz) {
            if (c.komsije.size() > mostHomies) {
                mostHomies = c.komsije.size();
                countrie = c.id;
            }
        }

        System.out.printf("%d\n%d", countrie, mostHomies);

    }

}

class Countrie {

    int id;
    HashSet<Integer> komsije;
    // static int mostHomies = 0;

    public Countrie(int id) {
        this.id = id;
        komsije = new HashSet<Integer>();
    }

    public boolean addKomsija(Countrie first, Countrie second) {
        if (first.id != second.id) {
            first.komsije.add(second.id);
            second.komsije.add(first.id);
            return true;
        }
        return false;
    }
}