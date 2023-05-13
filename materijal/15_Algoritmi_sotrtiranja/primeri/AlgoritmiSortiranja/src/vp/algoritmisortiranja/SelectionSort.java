package vp.algoritmisortiranja;

public class SelectionSort {
	public static void main(String[] args) {
		int[] niz = { 5, 3, 7, 2, 1, 4, 0, 6 };
		for (int i = 0; i < niz.length - 1; i++) {
			int minIndeks = i;
			for (int j = i + 1; j < niz.length; j++) {
				if (niz[j] < niz[minIndeks]) {
					minIndeks = j;
				}
			}
			// zameni elemente na indeksima "i" i "minIndeks"
			int najmanji = niz[minIndeks];
			niz[minIndeks] = niz[i];
			niz[i] = najmanji;
		}
		for (int i = 0; i < niz.length; i++) {
			System.out.println(niz[i] + " ");
		}
	}
}
