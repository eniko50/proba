package vp.polimorfizam;

public class StavkaGrejanje extends StavkaPriznanice {

	private double kvadraturaStana;
    private double jedinicnaCena;
    
	public StavkaGrejanje(double kvadraturaStana, double jedinicnaCena) {
		super();
		
		naziv = "Grejanje";
		
		this.kvadraturaStana = kvadraturaStana;
		this.jedinicnaCena = jedinicnaCena;
	}

	@Override
	public double izracunajIznos() {
		iznos =  kvadraturaStana * jedinicnaCena;
		return iznos;
	}

	public double getKvadraturaStana() {
		return kvadraturaStana;
	}

	public void setKvadraturaStana(double kvadraturaStana) {
		this.kvadraturaStana = kvadraturaStana;
	}

	public double getJedinicnaCena() {
		return jedinicnaCena;
	}

	public void setJedinicnaCena(double jedinicnaCena) {
		this.jedinicnaCena = jedinicnaCena;
	}
}
