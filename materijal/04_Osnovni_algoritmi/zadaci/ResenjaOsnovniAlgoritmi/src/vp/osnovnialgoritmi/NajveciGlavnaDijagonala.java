package vp.osnovnialgoritmi;

public class NajveciGlavnaDijagonala {
	public static void main(String[] args) {
		int[][] a = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		
		int max = a[0][0];
		for (int i = 1; i < 3; i++) {
			if (a[i][i] > max) {
				max = a[i][i];
			}
		}
		System.out.println("Najveci element na glavnoj dijagonali je: " + max);
	}
}
