package vp.ds.ispiti.model;

public class Ispit {
	
	private Predmet predmet;
	private int ocena;
	
	public Ispit() {}
	
	public Ispit(Predmet predmet, int ocena) {
		super();
		this.predmet = predmet;
		this.ocena = ocena;
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
	
	@Override
	public String toString() {
		return predmet.getNaziv() + " " + ocena;
	}
}
