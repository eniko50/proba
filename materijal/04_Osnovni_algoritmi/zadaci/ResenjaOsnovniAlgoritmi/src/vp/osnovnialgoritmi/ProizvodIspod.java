package vp.osnovnialgoritmi;

public class ProizvodIspod {
	public static void main(String[] args) {
		int[][] a = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		int n = 3; // dimenzija matrice
		
		int proizvod = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				proizvod *= a[i][j];
			}
		}
		System.out.println("Proizvod je: " + proizvod);
	}
}
