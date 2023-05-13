package vp.kontrolatoka;

public class Meni {
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
		int bodovi5 = 4;
		
		int meniOpcija = 3; 
		
		switch (meniOpcija) {
		case 1:
			System.out.println("Ispiti sa ocenom iznad 8:");
			if (ocena1 > 8) {
				System.out.println(ispit1);
			}
			if (ocena2 > 8) {
				System.out.println(ispit2);
			}
			if (ocena3 > 8) {
				System.out.println(ispit3);
			}
			if (ocena4 > 8) {
				System.out.println(ispit4);
			}
			if (ocena5 > 8) {
				System.out.println(ispit5);
			}
			break;
		case 2:
			System.out.println("Ispiti sa ocenom iznad 8 koji nose više od 5 ESPB:");
			if (ocena1 > 8 && bodovi1 > 5) {
				System.out.println(ispit1);
			}
			if (ocena2 > 8 && bodovi2 > 5) {
				System.out.println(ispit2);
			}
			if (ocena3 > 8 && bodovi3 > 5) {
				System.out.println(ispit3);
			}
			if (ocena4 > 8 && bodovi4 > 5) {
				System.out.println(ispit4);
			}
			if (ocena5 > 8 && bodovi5 > 5) {
				System.out.println(ispit5);
			}
			break;
		case 3:
			String najuspesnijiPredmet = ispit1;
			int najvisaOcena = ocena1;
			
			if (ocena2 > najvisaOcena) {
				najvisaOcena = ocena2;
				najuspesnijiPredmet = ispit2;
			}
			if (ocena3 > najvisaOcena) {
				najvisaOcena = ocena3;
				najuspesnijiPredmet = ispit3;
			}
			if (ocena4 > najvisaOcena) {
				najvisaOcena = ocena4;
				najuspesnijiPredmet = ispit4;
			}
			if (ocena5 > najvisaOcena) {
				najvisaOcena = ocena5;
				najuspesnijiPredmet = ispit5;
			}
			System.out.println("Predmet sa najvisom ocenom: " + najuspesnijiPredmet + 
					" (ocena " + najvisaOcena + ")");	
			break;
		case 4:
			String najmanjiIspit = ispit1;
			int najmanjeEspb = bodovi1;
			
			if (bodovi2 < najmanjeEspb) {
				najmanjeEspb = bodovi2;
				najmanjiIspit = ispit2;
			}
			if (bodovi3 < najmanjeEspb) {
				najmanjeEspb = bodovi3;
				najmanjiIspit = ispit3;
			}
			if (bodovi4 < najmanjeEspb) {
				najmanjeEspb = bodovi4;
				najmanjiIspit = ispit4;
			}
			if (bodovi5 < najmanjeEspb) {
				najmanjeEspb = bodovi5;
				najmanjiIspit = ispit5;
			}
			System.out.println("Predmet sa najmanje ESPB: " + najmanjiIspit);	
			break;
		}
	}		
}
