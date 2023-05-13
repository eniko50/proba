package vp.kontrolatoka;

public class Akcija {

	public static void main(String[] args) {
		double jedinicnaCena = 10;
		int kolicina = 3;
		boolean naPopustu = true;
		
		double ukupnaCena = jedinicnaCena * kolicina;
		
		if (naPopustu) {
			System.out.println("Ukupna cena je: " + ukupnaCena * 0.9);
			System.out.println("U cenu je uracunat akcijski popust od 10%");
		} else {
			System.out.println("Ukupna cena je: " + ukupnaCena);
		}
	}
}
