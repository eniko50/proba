package vp.polimorfizam;

public abstract class StavkaPriznanice {
	protected String naziv;
	protected double iznos;

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}
	
	public abstract double izracunajIznos(); 
}
