import java.util.Scanner;

public class Mravlja {
	
	/**
	 * Vrne stevilo poti od zgornjega levega do spodnjega desnega
	 * konta za steno s podano visino in sirino.
	 */
	
	private static int stPoti(int visina, int sirina) {
		if (visina <= 1 || sirina <= 1){
			return 1;
		}
		return stPoti(visina - 1, sirina) + stPoti(visina, sirina - 1);

	}
	
	/**
	 * Razlicica metode stPoti, ki uporablja memoizacijo -- pomnenje
	 * ze izracunanih vrednosti.
	 * @param memo memo[visina][sirina]: 0 oziroma ze izracunano
	 * stevilo poti za steno velikosti <visina> x <sirina> ali s x v
	 */
	
	private static int stPotiMemo(int visina, int sirina, long[][] memo) {
		// 1 - on the wall 1 x visina or sirina x 1, we have only one solution to the end
		if (visina <= 1 || sirina <= 1){
			return 1;
		}
		
		// 2 - have we already solved the problem for <visina> x <sirina> ??!
		if (memo[visina][sirina] > 0) {
			return memo[visina][sirina];
		}
		if (memo[sirina][visina] > 0) {
			return memo[visina][sirina];
		}
		
		// 3 - if we haven't solved it yet, "do kolena v blato"
		
		memo[visina][sirina] = 	stPotiMemo(visina - 1, sirina, memo) + 
								stPotiMemo(visina, sirina - 1, memo);
		return memo[visina][sirina];
	}
	 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int visina = sc.nextInt();
		int sirina = sc.nextInt();
		
		// osnovna razlicija
		// System.out.println(stPoti(visina, sirina));
		
		// razlicica z memoizacijo (ne memo-R-izacijo)
		int m = Math.max(visina, sirina) + 1;
		long[][] memo = new long[m][m];
		System.out.println(stPotiMemo(visina, sirina, memo));
		
	}
}