package vp.standardniulazizlaz.studenti;

import vp.standardniulazizlaz.predmeti.Predmet;

public class Ispit {
	private int ocena;
	private Predmet predmet;
	
	public Ispit(int ocena, Predmet predmet) {
		super();
		this.ocena = ocena;
		this.predmet = predmet;
	}
	public int getOcena() {
		return ocena;
	}
	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
	public Predmet getPredmet() {
		return predmet;
	}
	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	
	
}
