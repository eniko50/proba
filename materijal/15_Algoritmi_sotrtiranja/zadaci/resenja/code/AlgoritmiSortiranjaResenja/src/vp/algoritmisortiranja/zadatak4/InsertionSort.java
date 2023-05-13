package vp.algoritmisortiranja.zadatak4;

public class InsertionSort {
	public static void main(String[] args) {
		int[] niz = {5,3,7,2,6,1,9};
		int key, j;
		for (int i = 1; i < niz.length; i++) {
			key = niz[i];
			j = i-1;
			while(j >= 0 && niz[j] > key){
				niz[j+1] = niz[j];
				j = j - 1;
			}
			niz[j+1] = key;
			
			System.out.println("Izgled niza nakon iteracije br. " + i);
			for (int x = 0; x < niz.length; x++) {
				System.out.print(niz[x]+" ");
			}
			System.out.println();			
		}
	}
}