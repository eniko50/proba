package vp.polimorfizam.ispiti.evidencija;

import java.util.ArrayList;

public class KolokvijumskiIspit extends Ispit {
	private ArrayList<Integer> kolokvijumi = new ArrayList<>();
	
	public void dodajKolokvijum(int bodovi) {
		kolokvijumi.add(bodovi);
		izracunajOcenu(); // pri promeni broja bodova ponovo se izracunava ocena
	}
	
	@Override
	public void izracunajOcenu() {
		int ukupnoBodova = 0;
		for (int bodovi: kolokvijumi) {
			ukupnoBodova += bodovi;
		}
		ocena = ukupnoBodova >= 55 ? Math.round(ukupnoBodova/ (float) 10) : 5;
	}
	
	@Override
	public String toString() {
		String ispis = predmet.getNaziv() + " " + ocena + "(kolokvijumi: ";
		for (int kolokvijum: kolokvijumi) {
			ispis += kolokvijum + " ";
		}
		ispis += ")";		
		return ispis;
	}
	

}
