package vp.osnovnialgoritmi;

public class NajveciElement {
	public static void main(String[] args) {
		int[] niz = {2, 7, 3, 5, 1};
		
		int max = niz[0];
		for (int i = 1; i < 5; i++){
			if (niz[i] > max) {
				max = niz[i];
			}
		}
		System.out.println("Najveci element je: " + max);
	}
}
