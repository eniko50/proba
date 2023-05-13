package vp.ciklusiinizovi;

public class Predmeti {

	public static void main(String[] args) {
		String[] imena = {"Marko", "Ivan", "Tamara", "Nikola"};
		String[] prezimena = {"Markovic", "Ivanovic", "Popovic", "Nikolic"};
		String[] indeksi = {"1783", "3345", "3474", "4646"};
		
		String[][] ispiti = { 
				{"Matematika (6 ESPB)", "Fizika (4 ESPB)", "", ""}, //ispiti prvog studenta
				{"Matematika (6 ESPB)", "", "", ""}, //ispiti drugog studenta
				{"Osnove programiranja (8 ESPB)", "", "", ""},
				{"", "", "", ""}				
		};
		
		for (int i = 0; i < 4; i++) { // prolazak kroz sve studente (4 ukupno)
			System.out.print(indeksi[i] + " " + imena[i] + " " + prezimena[i] + 
					". Polozio: ");
			for (int j = 0; j < 4; j++) { // prolazak kroz studentove ispite (4 ispita ukupno)
				System.out.print(ispiti[i][j]+ " ");
			}
			System.out.println(); // novi red za svakog studenta
		}
		
		// predmeti
		System.out.println("----------------------");
		System.out.println("Spisak predmeta:");
		int[] oznakePredmeta = {1, 2, 3, 4};
		String[] naziviPredmeta = {"Matematika", "Fizika", 
				"Osnove programiranja", "Engleski jezik"};
		int[] bodovi = {6, 4, 8, 6};
		
		for (int i = 0; i < 4; i++) {
			System.out.println(oznakePredmeta[i] + " " + naziviPredmeta[i] + " " + 
				bodovi[i] + " ESPB");
		}
	}
}
