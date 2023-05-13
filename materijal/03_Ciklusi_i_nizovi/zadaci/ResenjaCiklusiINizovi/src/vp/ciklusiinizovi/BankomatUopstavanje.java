package vp.ciklusiinizovi;

public class BankomatUopstavanje {
	public static void main(String[] args) {
		int v = 10350;
		// svaki element niza je broj za jedan tip novcanice
		int[] brojNovcanica = {0, 0, 0, 0, 0}; 
		
		int[] vrednostiNovcanica = {2000, 500, 200, 100, 50};
		
		for (int i = 0; i < 5; i++) {
			while (v >= vrednostiNovcanica[i]) {			
				v -= vrednostiNovcanica[i];
				System.out.println("Isplacujem " + vrednostiNovcanica[i]);
				brojNovcanica[i]++;
			}
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Isplaceno " + brojNovcanica[i] + 
				" novcanica od " + vrednostiNovcanica[i] + " dinara.");
		}
	}
}
