package vp.ciklusiinizovi;

public class EvidencijaStudenata {

	public static void main(String[] args) {
		String[] ispiti = {"Matematika", "Fizika", "Engleski", 
				"Programiranje", "Sociologija"};
		int[] ocene = {7, 6, 9, 7, 10};
		int[] bodovi = {8, 4, 6, 8, 4};
		
		System.out.println("Ispiti sa ocenom vecom od 8");
		for (int i = 0; i < 5; i++) {
			if (ocene[i] > 8) {
				System.out.println(ispiti[i]);
			}
		}
		
		System.out.println("Ispiti sa ocenom vecom od 8 koji nose vise od 5 ESPB");
		for (int i = 0; i < 5; i++) {
			if (ocene[i] > 8 && bodovi[i] > 5) {
				System.out.println(ispiti[i]);
			}
		}
		
		

	}

}
