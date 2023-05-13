package vp.osnovnialgoritmi;

public class ProizvodIznad {
	public static void main(String[] args) {
		int[][] a = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		int n = 3; // dimenzija matrice
		
		int proizvod = 1;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				proizvod *= a[i][j];
			}
		}
		System.out.println("Proizvod je: " + proizvod);
	}
}
