package vp.xml;

public class Ispit {
	public Ispit(Predmet predmet, int ocena) {
		this.predmet = predmet;
		this.ocena = ocena;
	}
	
	public Ispit() {
		
	}
	
	@Override
	public String toString() {
		return "Ispit [predmet=" + predmet + ", ocena=" + ocena + "]";
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
