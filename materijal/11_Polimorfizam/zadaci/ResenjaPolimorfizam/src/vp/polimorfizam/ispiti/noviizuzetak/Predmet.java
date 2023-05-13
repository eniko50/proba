package vp.polimorfizam.ispiti.noviizuzetak;

public class Predmet {
	private String oznaka;
	private String naziv;
	private int espb;
	
	public Predmet() {
	}

	public Predmet(String oznaka, String naziv, int espb) {
		super();
		this.oznaka = oznaka;
		this.naziv = naziv;
		this.espb = espb;
	}

	public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}
	
	@Override
	public String toString() {
		return oznaka + " " + naziv + " " + espb;
	}

}
