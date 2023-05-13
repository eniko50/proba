package vp.polimorfizam;

import java.util.ArrayList;
import java.util.List;

public class Korisnik {
	private String ime;
    private String prezime;
    private int sifra;
    private List<Priznanica> priznanice = new ArrayList<>();
	
    public Korisnik(String ime, String prezime, int sifra) {
		this.ime = ime;
		this.prezime = prezime;
		this.sifra = sifra;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public int getSifra() {
		return sifra;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

	public List<Priznanica> getPriznanice() {
		return priznanice;
	}

	public void setPriznanice(List<Priznanica> priznanice) {
		this.priznanice = priznanice;
	}	
}
