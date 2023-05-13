package vp.osnovnialgoritmi;

public class NajmanjiElement {
	public static void main(String[] args) {
		int[] niz = {2, 7, 3, 5, 1};
		
		int min = niz[0];
		for (int i = 1; i < 5; i++){
			if (niz[i] < min) {
				min = niz[i];
			}
		}
		System.out.println("Najmanji element je: " + min);
	}
}
