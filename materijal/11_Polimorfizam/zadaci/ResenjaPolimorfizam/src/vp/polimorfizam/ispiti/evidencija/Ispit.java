package vp.polimorfizam.ispiti.evidencija;

public class Ispit {
	protected Predmet predmet;
	protected int ocena;

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
	
	public void izracunajOcenu() {		
	}
}
