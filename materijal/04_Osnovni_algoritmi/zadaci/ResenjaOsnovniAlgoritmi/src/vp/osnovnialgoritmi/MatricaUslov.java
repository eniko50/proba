package vp.osnovnialgoritmi;

public class MatricaUslov {
	public static void main(String[] args) {
		int[][] a = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		
		int suma = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				suma += a[i][j];
			}
		}
		double srednjaVrednost = suma/9.0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (a[i][j] < srednjaVrednost) {
					System.out.println(a[i][j]);
				}
			}
		}
	}
}
