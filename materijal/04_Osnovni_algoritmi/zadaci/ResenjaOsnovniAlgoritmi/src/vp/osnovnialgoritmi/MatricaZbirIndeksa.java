package vp.osnovnialgoritmi;

public class MatricaZbirIndeksa {
	public static void main(String[] args) {
		int[][] a = {
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0}
		};
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				a[i][j] = i + j;
				System.out.print(a[i][j] + " ");
			}
			System.out.println(); // novi red nakon kraja reda
		}
	}
}
