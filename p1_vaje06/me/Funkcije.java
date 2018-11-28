public class Funkcije {
	
	public static double koren(double x, double epsilon) {
		double n = 0;
		double sum = 0; 
		double clen = 1;
		
		while (Math.abs(clen) > epsilon) {
			sum += clen;
			clen = clen * (1.0 - 2 * n) * (x - 1.0) / (2 * (n  + 1.0));
			n++;
		}
		return sum;
	}
	
}