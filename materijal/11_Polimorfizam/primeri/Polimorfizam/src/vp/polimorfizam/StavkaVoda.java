package vp.polimorfizam;

public class StavkaVoda extends StavkaPriznanice {

	private double jedinicnaCena;
	private int brojClanovaDomacinstva;
	private int brojStanaraUZgradi;
	private double potrosnjaUZgradi;

	public StavkaVoda(double jedinicnaCena, int brojClanovaDomacinstva,
			int brojStanaraUZgradi, double potrosnjaUZgradi) {
		super();

		naziv = "Voda";

		this.jedinicnaCena = jedinicnaCena;
		this.brojClanovaDomacinstva = brojClanovaDomacinstva;
		this.brojStanaraUZgradi = brojStanaraUZgradi;
		this.potrosnjaUZgradi = potrosnjaUZgradi;
	}

	@Override
	public double izracunajIznos() {
		iznos =  (potrosnjaUZgradi / brojStanaraUZgradi) * brojClanovaDomacinstva
				* jedinicnaCena;
		return iznos;
	}

	public double getJedinicnaCena() {
		return jedinicnaCena;
	}

	public void setJedinicnaCena(double jedinicnaCena) {
		this.jedinicnaCena = jedinicnaCena;
	}

	public int getBrojClanovaDomacinstva() {
		return brojClanovaDomacinstva;
	}

	public void setBrojClanovaDomacinstva(int brojClanovaDomacinstva) {
		this.brojClanovaDomacinstva = brojClanovaDomacinstva;
	}

	public int getBrojStanaraUZgradi() {
		return brojStanaraUZgradi;
	}

	public void setBrojStanaraUZgradi(int brojStanaraUZgradi) {
		this.brojStanaraUZgradi = brojStanaraUZgradi;
	}

	public double getPotrosnjaUZgradi() {
		return potrosnjaUZgradi;
	}

	public void setPotrosnjaUZgradi(double potrosnjaUZgradi) {
		this.potrosnjaUZgradi = potrosnjaUZgradi;
	}
}
