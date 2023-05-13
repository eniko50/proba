package vp04.filmovi.model;

public class Film {
	private String id;
	private String naziv;
	private int godina;
	private Zanr zanr;
	
	public Film(String id, String naziv, int godina, Zanr zanr) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.godina = godina;
		this.zanr = zanr;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getGodina() {
		return godina;
	}
	public void setGodina(int godina) {
		this.godina = godina;
	}
	public Zanr getZanr() {
		return zanr;
	}
	public void setZanr(Zanr zanr) {
		this.zanr = zanr;
	}
	
	@Override
	public String toString() {
		return this.id + " " + this.naziv + " " + this.godina
			+ this.zanr.getNaziv();
	}
}
