package vp.uvodujavu;

public class Cena {

	public static void main(String[] args) {
		double jedinicnaCena = 10;
		int kolicina = 3;
		double popust = 20;
		
		double ukupno = jedinicnaCena * kolicina * (100 - popust)/100;
		
		System.out.println("Cena sa popustom je: " + ukupno);
	}
}
