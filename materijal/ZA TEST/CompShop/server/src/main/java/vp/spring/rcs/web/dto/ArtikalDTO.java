package vp.spring.rcs.web.dto;

import vp.spring.rcs.model.Artikal;

public class ArtikalDTO {
	
	BrendDTO brend;
	String naziv;
	double cena;
	KategorijaDTO kategorija;
	
	public ArtikalDTO() {
		super();
	}
	
	public ArtikalDTO(Artikal artikal) {
		this.brend = new BrendDTO(artikal.getBrend());
		this.naziv = artikal.getNaziv();
		this.cena = artikal.getCena();
		this.kategorija = new KategorijaDTO (artikal.getKategorija());
	}
	
	
	
	
	
	public KategorijaDTO getKategorija() {
		return kategorija;
	}
	public void setKategorija(KategorijaDTO kategorija) {
		this.kategorija = kategorija;
	}
	public BrendDTO getBrend() {
		return brend;
	}
	public void setBrend(BrendDTO brend) {
		this.brend = brend;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	
	
	
	

}
