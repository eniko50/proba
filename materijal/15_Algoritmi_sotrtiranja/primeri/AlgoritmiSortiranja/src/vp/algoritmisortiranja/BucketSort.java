package vp.algoritmisortiranja;

public class BucketSort {

	public static void main(String[] args) {
		int[] niz = { 5, 3, 7, 2, 1, 4, 0, 6 };
		int[] sortiraniNiz = { 0, 0, 0, 0, 0, 0, 0, 0 };
		for (int i = 0; i < niz.length; i++) {
			sortiraniNiz[niz[i]] = niz[i];
		}

		for (int i = 0; i < sortiraniNiz.length; i++) {
			System.out.println(sortiraniNiz[i] + " ");
		}
	}

}
