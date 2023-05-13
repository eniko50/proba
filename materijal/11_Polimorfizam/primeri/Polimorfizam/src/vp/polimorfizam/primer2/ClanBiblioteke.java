package vp.polimorfizam.primer2;

public class ClanBiblioteke extends Osoba{
	
	public ClanBiblioteke(String ime, String prezime, String brojClanskeKarte){
		super(ime, prezime);
		this.brojClanskeKarte = brojClanskeKarte;
	}
	
	protected String brojClanskeKarte;

	public String getBrojClanskeKarte() {
		return brojClanskeKarte;
	}

	public void setBrojClanskeKarte(String brojClanskeKarte) {
		this.brojClanskeKarte = brojClanskeKarte;
	}
	
	@Override
	public void predstaviSe(){
		super.predstaviSe();
		System.out.println("Moj broj clanske karte je: "+brojClanskeKarte);
	}
	
}
