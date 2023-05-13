package vp.polimorfizam;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class Priznanica {
	private String brojRacuna;
    private String zaMesec;
    private LocalDate datum;
    private List<StavkaPriznanice> stavke = new ArrayList<>();
	
	public String getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(String brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public String getZaMesec() {
		return zaMesec;
	}

	public void setZaMesec(String zaMesec) {
		this.zaMesec = zaMesec;
	}

	public LocalDate getDatum() {
		return datum;
	}

	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}

	public List<StavkaPriznanice> getStavke() {
		return stavke;
	}

	public void setStavke(List<StavkaPriznanice> stavke) {
		this.stavke = stavke;
	}
}
