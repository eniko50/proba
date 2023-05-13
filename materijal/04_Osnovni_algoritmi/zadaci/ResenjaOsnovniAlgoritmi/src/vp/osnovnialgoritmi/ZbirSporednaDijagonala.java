package vp.osnovnialgoritmi;

public class ZbirSporednaDijagonala {
	public static void main(String[] args) {
		int[][] a = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}			
		};
		int n = 3; // dimenzija matrice
		
		int suma = 0;
		for (int i = 0; i < 3; i++) {
			suma += a[n - i - 1][i];
		}
		System.out.println("Suma je: " + suma);
	}
}
