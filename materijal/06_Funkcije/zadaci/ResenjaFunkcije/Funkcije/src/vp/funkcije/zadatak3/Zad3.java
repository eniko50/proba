package vp.funkcije.zadatak3;

public class Zad3 {
	//funkcija koja pronalazi sumu vrednosti u nizu
	public static int sum(int[] niz){
		int retVal = 0;
		for (int i = 0; i < niz.length; i++) {
			retVal += niz[i];
		}
		return retVal;
	}
	
	public static void main(String[] args) {
		int[] niz = {3,2,5,7,9};
		int suma = sum(niz);
		System.out.println(suma);
	}
}
