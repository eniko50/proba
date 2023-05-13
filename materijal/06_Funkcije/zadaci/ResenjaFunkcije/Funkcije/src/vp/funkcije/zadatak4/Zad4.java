package vp.funkcije.zadatak4;

public class Zad4 {
	//funkcija koja racuna srednju vrednost niza
	public static double srVrednost(int[] niz) {
		int retVal = 0;
		for (int i = 0; i < niz.length; i++) {
			retVal += niz[i];
		}
		return (double)retVal/niz.length;
	}

	public static void main(String[] args) {
		int[] niz = {3,2,5,7,9};
		double srV = srVrednost(niz);
		System.out.println(srV);
	}

}
