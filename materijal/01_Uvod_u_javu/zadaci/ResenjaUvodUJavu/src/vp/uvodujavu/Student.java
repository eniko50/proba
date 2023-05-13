package vp.uvodujavu;

public class Student {

	public static void main(String[] args) {
		String ime = "Petar";
		String prezime = "Petrovic";
		String brIndeksa = "27382";
		
		//ispiti
		String ispit1 = "Matematika";
		String ispit2 = "Fizika";
		String ispit3 = "Engleski";
		String ispit4 = "Programiranje";
		String ispit5 = "Sociologija";

		//ocene
		int ocena1 = 7;
		int ocena2 = 6;
		int ocena3 = 9;
		int ocena4 = 7;
		int ocena5 = 10;
		
		//espb bodovi
		int bodovi1 = 8;
		int bodovi2 = 4;
		int bodovi3 = 2;
		int bodovi4 = 8;
		int bodovi5 = 2;
		
		//ukupno bodova
		double ukupnoBodova = bodovi1 + bodovi2 + bodovi3 + bodovi4 + bodovi5;
		System.out.println("Student je ostvario ukupno " + ukupnoBodova + " ESPB bodova");
		
		//prosecna ocena
		double prosecnaOcena = (ocena1 + ocena2 + ocena3 + ocena4 + ocena5)/5.0;
		System.out.println("Prosecna ocena studenta je " + prosecnaOcena);
	}
}
