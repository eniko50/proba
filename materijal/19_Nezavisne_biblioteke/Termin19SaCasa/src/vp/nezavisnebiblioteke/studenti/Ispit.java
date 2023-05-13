package vp.nezavisnebiblioteke.studenti;

public class Ispit {
	protected Predmet predmet;
	protected int ocena;
	private int usmeniBodovi;
	private int pismeniBodovi;

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public int getOcena() {
		return ocena;
	}

	public int getUsmeniBodovi() {
		return usmeniBodovi;
	}

	public void setUsmeniBodovi(int usmeniBodovi) {
		this.usmeniBodovi = usmeniBodovi;
		izracunajOcenu(); // pri promeni broja bodova ponovo se izracunava ocena
	}

	public int getPismeniBodovi() {
		return pismeniBodovi;
	}

	public void setPismeniBodovi(int pismeniBodovi) {
		this.pismeniBodovi = pismeniBodovi;
		izracunajOcenu();
	}

	public void izracunajOcenu() {
		int ukupnoBodova = pismeniBodovi + usmeniBodovi;
		ocena = ukupnoBodova >= 55 ? Math.round(ukupnoBodova / (float) 10) : 5;
	}

	@Override
	public String toString() {
		return predmet.getNaziv() + " " + ocena + "(usmeni: " + usmeniBodovi
				+ ", pismeni: " + pismeniBodovi + ")";
	}

}
