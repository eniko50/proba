package vp.uml;

import java.time.LocalDate;
import java.util.ArrayList;

public class KolokvijumskiIspit extends Ispit {
	private ArrayList<Kolokvijum> kolokvijumi = new ArrayList<>();
	
	public void dodajKolokvijum(LocalDate datum, int bodovi) {
		kolokvijumi.add(new Kolokvijum(kolokvijumi.size() + 1, datum, bodovi));
		izracunajOcenu(); 
	}
	
	@Override
	public void izracunajOcenu() {
		int ukupnoBodova = 0;
		for (Kolokvijum k: kolokvijumi) {
			ukupnoBodova += k.getBodovi();
		}
		ocena = ukupnoBodova >= 55 ? Math.round(ukupnoBodova/ (float) 10) : 5;
	}
	
	@Override
	public String toString() {
		String ispis = predmet.getNaziv() + " " + ocena + "(kolokvijumi: ";
		for (Kolokvijum kolokvijum: kolokvijumi) {
			ispis += kolokvijum + " ";
		}
		ispis += ")";		
		return ispis;
	}
	

}
