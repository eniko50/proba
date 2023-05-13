package vp.funkcije.zadatak11;

public class Zad11 {
	//Suma(4*(-1)**i/(2*i+1))
	public static double pi(int n){
		double retVal = 0;
		int faktor = 1;
		for (int i = 0; i < n; i++) {
			faktor *= -1;
			retVal += 4*faktor/(2*i+1);
		}
		return retVal;
	}
	
	public static void main(String[] args) {
		double p = pi(1000);
		System.out.println(p);
	}
	
}
