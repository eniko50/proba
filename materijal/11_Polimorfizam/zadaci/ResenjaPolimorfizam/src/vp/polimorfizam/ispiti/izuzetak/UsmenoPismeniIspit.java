package vp.polimorfizam.ispiti.izuzetak;

public class UsmenoPismeniIspit extends Ispit {
	private int usmeniBodovi;
	private int pismeniBodovi;
	
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
	
	@Override
	public void izracunajOcenu() {
		int ukupnoBodova = pismeniBodovi + usmeniBodovi;
		if (ukupnoBodova < 0 || ukupnoBodova > 100) {
			throw new ArithmeticException();
		}
		ocena = ukupnoBodova >= 55 ? Math.round(ukupnoBodova/ (float) 10) : 5;  
	}
	
	@Override
	public String toString() {
		return predmet.getNaziv() + " " + ocena + "(usmeni: " + usmeniBodovi
				+ ", pismeni: " + pismeniBodovi + ")";
	}
}
