package vp.ciklusiinizovi;

public class Student {

	public static void main(String[] args) {
		String[] imena = {"Marko", "Ivan", "Tamara", "Nikola"};
		String[] prezimena = {"Markovic", "Ivanovic", "Popovic", "Nikolic"};
		String[] indeksi = {"1783", "3345", "3474", "4646"};
		
		String[][] ispiti = { 
				{"Matematika (6 ESPB)", "Fizika (4 ESPB)", "", "", ""}, //ispiti prvog studenta
				{"Matematika (6 ESPB)", "", "", "", ""}, //ispiti drugog studenta
				{"Osnove programiranja (8 ESPB)", "", "", "", ""},
				{"", "", "", "", ""}				
		};
		
		
		for (int i = 0; i < 4; i++) { // prolazak kroz sve studente
			System.out.print(indeksi[i] + " " + imena[i] + " " + prezimena[i] + 
					". Polozio: ");
			for (int j = 0; j < 5; j++) { // prolazak kroz studentove ispite
				System.out.print(ispiti[i][j]+ " ");
			}
			System.out.println(); // novi red za svakog studenta
		}
	}
}
