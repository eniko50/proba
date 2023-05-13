package vp.ciklusiinizovi;

public class BankomatBroj {
	public static void main(String args[]) {
		int v = 10350;
		//svaki element niza je broj za jedan tip novcanice
		int[] brojNovcanica = {0, 0, 0, 0, 0}; 
		
		while (v > 0) {
			if (v >= 1000) {
				v -= 1000;
				System.out.println("Isplacujem 1000");
				brojNovcanica[0]++;
			} else if (v >= 500) {
				v -= 500;
				System.out.println("Isplacujem 500");
				brojNovcanica[1]++;
			} else if (v >= 200) {
				v -= 200;
				System.out.println("Isplacujem 200");
				brojNovcanica[2]++;
			} else if (v >= 100) {
				v -= 100;
				System.out.println("Isplacujem 100");
				brojNovcanica[3]++;
			} else if (v >=50) {
				v -= 50;
				System.out.println("Isplacujem 50");
				brojNovcanica[4]++;
			}
		}
		
		// zbog jednostavnijeg ispisa vrednosti novcanica
		int[] vrednostiNovcanica = {1000, 500, 200, 100, 50};
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Isplaceno " + brojNovcanica[i] + 
				" novcanica od " + vrednostiNovcanica[i] + " dinara.");
		}
		
	}
}
