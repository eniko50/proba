package vp.funkcije.zadatak1;

public class Zad1 {
	
	//funkcija koja pronalazi najmanju vrednost u nizu celih brojeva
	public static int min(int[] niz){
		int retVal = niz[0];
		for (int i = 1; i < niz.length; i++) {
			if(niz[i]<retVal){
				retVal = niz[i];
			}
		}
		return retVal;
	}
	
	public static void main(String[] args) {
		int[] niz = {3,2,5,7,9};
		int najmanji = min(niz);
		System.out.println(najmanji);
	}
}
