package vp.spring.rcs.model;




import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

	@Entity
	@Table(catalog = "compshopdb", name = "Artikal")

public class Artikal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Brend brend;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private Korpa korpa;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Kategorija kategorija;
	
	String naziv;
	
	double cena;

	
	public Artikal(Long id, Brend brend,  Kategorija kategorija, String naziv, double cena) {
		super();
		this.id = id;
		this.brend = brend;
//		this.korpa = korpa;
		this.kategorija = kategorija;
		this.naziv = naziv;
		this.cena = cena;
	}

	public Artikal() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Brend getBrend() {
		return brend;
	}

	public void setBrend(Brend brend) {
		this.brend = brend;
	}

	public Korpa getKorpa() {
		return korpa;
	}

	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

	public void setKorpa(Korpa korpa) {
		this.korpa = korpa;
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
