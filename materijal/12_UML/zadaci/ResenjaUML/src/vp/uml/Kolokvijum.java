package vp.uml;

import java.time.LocalDate;

public class Kolokvijum {
	private int id;
	LocalDate datum;
	int bodovi;
	
	public Kolokvijum(int id, LocalDate datum, int bodovi) {
		super();
		this.id = id;
		this.datum = datum;
		this.bodovi = bodovi;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDatum() {
		return datum;
	}
	public void setDatum(LocalDate datum) {
		this.datum = datum;
	}
	public int getBodovi() {
		return bodovi;
	}
	public void setBodovi(int bodovi) {
		this.bodovi = bodovi;
	}
	@Override
	public String toString() {
		return id + ", " + datum + ", " + bodovi;
	}	
}	
