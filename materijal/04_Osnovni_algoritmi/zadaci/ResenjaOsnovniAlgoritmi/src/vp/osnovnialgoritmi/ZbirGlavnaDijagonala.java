package vp.osnovnialgoritmi;

public class ZbirGlavnaDijagonala {
	public static void main(String[] args) {
		int[][] a = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		
		int suma = 0;
		for (int i = 0; i < 3; i++) {
			suma += a[i][i];
		}
		System.out.println("Suma je: " + suma);
	}
}
