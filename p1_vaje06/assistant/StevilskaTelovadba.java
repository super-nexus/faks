import java.util.Scanner;

public class StevilskaTelovadba {
	
	/**
	 * Vrne najvecjo potenco stevila 10, ki je manjsa ali enaka 
	 * podanemu stevilu <stevilo>. THE SMALLEST EXPONENT
	 */
	private static int navzdolDoPotence(int number){
		int exponent = 1;
		while(number>=10){
			number /= 10;
			exponent *= 10;
		}
		return exponent;
	}

	
	/**
	 * Doda podano stevko <stevka> na zacetek stevila <stevilo> 
	 * in vrne rezultat.
	 */
	private static int dodajZ(int stevilo, int stevka){
		return navzdolDoPotence(stevilo) * 10 * stevka + stevilo;
	}
	

	
	/**
	 * Doda podano stevko <stevka> na konec stevila <stevilo> 
	 * in vrne rezultat.
	 */
	private static int dodajK(int number, int d){
		return number * 10 + d;			
	}
	

	
	/**
	 * Odstrani prvo stevko iz stevila <stevilo> in vrne rezultat.
	 */
	private static int odstraniZ(int stevilo){
		return stevilo % navzdolDoPotence(stevilo);
	}
	
	
	
	/**
	 * Odstrani zadnjo stevko iz stevila <stevilo> in vrne rezultat.
	 */
	 
	private static int odstraniK(int number){
		return number / 10 ;			
	}
	

	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 
		int instruction = sc.nextInt();
		int number = sc.nextInt();
		
		switch (instruction){
			case 1: 
				int d = sc.nextInt();
				int result = dodajK(number, d);
				System.out.println(result);
				break;
			case 2:
				result = dodajZ(number, sc.nextInt());
				System.out.println(result);
				break;
			case -1:
				System.out.println(odstraniK(number));
				break;
			case -2:
				System.out.println(odstraniZ(number));
				break;
		}
	}
}