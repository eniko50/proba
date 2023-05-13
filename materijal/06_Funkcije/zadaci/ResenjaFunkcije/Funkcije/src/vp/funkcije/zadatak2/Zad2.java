package vp.funkcije.zadatak2;

public class Zad2 {
	//funkcija koja pronalazi najvecu vrednost u nizu celih brojeva
	public static int max(int[] niz){
		int retVal = niz[0];
		for (int i = 1; i < niz.length; i++) {
			if(niz[i]>retVal){
				retVal = niz[i];
			}
		}
		return retVal;
	}
	
	public static void main(String[] args) {
		int[] niz = {3,2,5,7,9};
		int najmanji = max(niz);
		System.out.println(najmanji);
	}

}
