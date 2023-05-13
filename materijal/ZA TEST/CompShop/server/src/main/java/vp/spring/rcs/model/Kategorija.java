package vp.spring.rcs.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(catalog = "compshopdb", name = "Kategorija")
public class Kategorija {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String naziv;
	
	@JsonIgnore
	@OneToMany(mappedBy = "kategorija", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	List<Artikal> artikli = new ArrayList<Artikal>();
	
	
	

	public Kategorija() {
		super();
	}

	public Kategorija(Long id, String naziv, List<Artikal> artikli) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.artikli = artikli;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Artikal> getArtikli() {
		return artikli;
	}

	public void setArtikli(List<Artikal> artikli) {
		this.artikli = artikli;
	}
	
	
	

}
