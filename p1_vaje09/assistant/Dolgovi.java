import java.util.Scanner;
import java.util.Arrays;

public class Dolgovi {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int stOseb = sc.nextInt();
		int stTransakcij = sc.nextInt();
		
		int[][] dolgovi = new int[stOseb][stOseb];
		
		for(int i = 0; i < stTransakcij; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int izposoja = sc.nextInt();
			
			dolgovi[a - 1][b - 1] += izposoja;
		}
		
		System.out.println(Arrays.deepToString(dolgovi));
		
		int[][] pobotani = new int[stOseb][stOseb];
		
		for(int i = 0; i < stOseb; i++) {
			for(int j = 0; j < stOseb; j++) {
				if(dolgovi[i][j] > dolgovi[j][i]) {
					pobotani[i][j] = dolgovi[i][j] - dolgovi[j][i];
				} 
			}
		}
		
		System.out.println(Arrays.deepToString(pobotani));
	}
}