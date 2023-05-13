package vp.polimorfizam;

public class StavkaOdrzavanje extends StavkaPriznanice {
	private double cena;
    private double taksa;
    
    public StavkaOdrzavanje(double cena, double taksa) {
		super();
		
		naziv = "Odrzavanje";
		
		this.cena = cena;
		this.taksa = taksa;
	}

	@Override
	public double izracunajIznos() {
		iznos = cena + taksa;
		return iznos;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public double getTaksa() {
		return taksa;
	}

	public void setTaksa(double taksa) {
		this.taksa = taksa;
	}
}
