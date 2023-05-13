package vp.funkcije.zadatak6;

public class Zad6 {
	//funkcija za sortiranje niza
	public static int[] bubbleSort(int[] niz){
		for (int i = 0; i < niz.length; i++) {
			for (int j = 0; j < niz.length-1; j++) {
				if(niz[j]>=niz[j+1]){
					int temp = niz[j];
					niz[j] = niz[j+1];
					niz[j+1] = temp;
				}
			}
		}
		return niz;
	}

	//funkcija koja pronalazi medijanu
	public static double median(int[] niz){
		//sortiramo niz
		int[] sNiz = bubbleSort(niz);
		//ako niz ima neparan broj elemenata vrati se srednji clan niza 
		if(sNiz.length%2 != 0){
			return sNiz[sNiz.length/2];
		}
		//ako niz ima paran broj elemenata, vrati se aritmeticka sredina kandidata za medijanu
		else{
			return ((double) sNiz[sNiz.length/2-1] + (double) sNiz[sNiz.length/2]) / 2;
		}
	}
	
	public static void main(String[] args) {
		int[] niz = {3,2,5,7,9,6};
		double m = median(niz);
		System.out.println(m);
	}

}
