package vp.ds.ispiti.model;

public class Predmet {
	private String oznaka;
	private String naziv;
	private int espb;
	private boolean obrisan;
	
	public Predmet() {
	}

	public Predmet(String oznaka, String naziv, int espb) {
		//super();
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

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}
	
	public void ispisiPredmet() {
		System.out.println(oznaka + " " + naziv + " " + espb);
	}

}
