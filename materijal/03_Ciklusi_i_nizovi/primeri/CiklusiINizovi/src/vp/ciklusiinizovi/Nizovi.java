package vp.ciklusiinizovi;

class Nizovi {
	public static void main(String[] args) {
		int[] a = {6, 3, 7, 6}; 
		
		System.out.println("Element sa indeksom 2 je: " + a[2]);
		a[2] = 9;
		System.out.println("Element sa indeksom 2 je: " + a[2]);
		
		for (int i = 0; i < 4; i++) {
			System.out.println(a[i]);
		}
		
		// visedimenzionalni nizovi
		System.out.println("Visedimenzionalni nizovi");
		int[][] brojevi = { 
			{1, 3, 5},
			{2, 7, 9},
			{6, 6, 4},
			{8, 1, 3}	
		}; 
		
		System.out.println(brojevi[1][2]);
		brojevi[1][2] = 17;
		System.out.println(brojevi[1][2]);
		
		System.out.println("Ispis svih elemenata niza");
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println(brojevi[i][j]);
			}
		}
		
		System.out.println("Formatiran ispis svih elemenata niza");
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(brojevi[i][j] + " ");
			}
			System.out.println();
		}


	}
}
