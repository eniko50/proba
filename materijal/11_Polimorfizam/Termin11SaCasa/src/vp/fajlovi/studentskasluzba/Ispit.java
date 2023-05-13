package vp.fajlovi.studentskasluzba;

public class Ispit {
	public Ispit(Predmet predmet, int ocena) {
		this.predmet = predmet;
		this.ocena = ocena;
	}
	
	@Override
	public String toString() {
		return predmet.getNaziv() + " " + ocena;
	}
	public Predmet getPredmet() {
		return predmet;
	}
	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	public int getOcena() {
		return ocena;
	}
	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
	private Predmet predmet;
	private int ocena;
}
