package vp.ciklusiinizovi;

public class PovezivanjePredmeta {
	public static void main(String[] args) {
		String[] imena = {"Marko", "Ivan", "Tamara", "Nikola"};
		String[] prezimena = {"Markovic", "Ivanovic", "Popovic", "Nikolic"};
		String[] indeksi = {"1783", "3345", "3474", "4646"};
		
		// -1 je oznaka za nepostojeci ispit
		int[][] ispiti = { 
				{1, 2, -1, -1}, //ispiti prvog studenta
				{1, -1, -1, -1}, //ispiti drugog studenta
				{3, -1, -1, -1},
				{-1, -1, -1, -1}				
		};
		
		// predmeti
		System.out.println("----------------------");
		System.out.println("Spisak predmeta:");
		int[] oznakePredmeta = {1, 2, 3, 4};
		String[] naziviPredmeta = {"Matematika", "Fizika", 
				"Osnove programiranja", "Engleski jezik"};
		int[] bodovi = {6, 4, 8, 6};
		
		for (int i = 0; i < 4; i++) { // prolazak kroz sve studente (4 ukupno)
			System.out.print(indeksi[i] + " " + imena[i] + " " + prezimena[i] + 
					". Polozio: ");
			for (int j = 0; j < 4; j++) { // prolazak kroz studentove ispite (4 ispita ukupno)
				int idPredmeta = ispiti[i][j]; 
				// pronalazenje podataka o predmetu sa odredjenim identifikatorom
				int pozicijaPredmeta = -1;
				for (int k = 0; k < 4; k++) { // prolazak kroz sve predmete
					if (idPredmeta == oznakePredmeta[k]) {
						pozicijaPredmeta = k; // pronadjen predmet. Pamtimo njegovu poziciju u nizu
						break;
					}
				}
				if (pozicijaPredmeta != -1) { // ako je predmet pronadjen
					// ispis podataka o predmetu
					System.out.print(naziviPredmeta[pozicijaPredmeta] + " (" + 
							bodovi[pozicijaPredmeta] + " ESPB) ");
				}
			}
			System.out.println(); // novi red za svakog studenta
		}
	}		
}
