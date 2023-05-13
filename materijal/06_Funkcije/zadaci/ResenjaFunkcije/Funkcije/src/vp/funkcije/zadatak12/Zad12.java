package vp.funkcije.zadatak12;

public class Zad12 {
	// racunanje faktorijela
	public static double factorial(int x) {
		double retVal = 1;
		for (int i = 1; i <= x; i++) {
			retVal *= i;
		}
		return retVal;
	}

	// racunanje sinusa
	public static double sinus(double x, int n) {
		x = x % (2 * Math.PI);
		// x**(2*i+1)*(-1)**i/(2*i+1)!
		double retVal = 0;
		for (int i = 0; i < n; i++) {
			System.out.print("x*"+ (2 * i + 1)); 
			System.out.print("*("+Math.pow(-1, i)+")");
			System.out.println("/"+ factorial(2 * i + 1));
			retVal += (Math.pow(x, (2 * i + 1)) * Math.pow(-1, i)) / factorial(2 * i + 1);
			System.out.println(retVal);
		}
		return retVal;
	}

	public static void main(String[] args) {
		double s = sinus(Math.PI/2, 5);
		System.out.println(s);
	}
}
