package vp.spring.rcs.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import vp.spring.rcs.model.user.SecurityUser;

@Entity
@Table(catalog = "compshopdb", name = "Korpa")

public class Korpa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@OneToMany(mappedBy = "korpa", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Artikal> artikli = new ArrayList<Artikal>();
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private SecurityUser user;

	
	
	

	public Korpa(Long id, List<Artikal> artikli, SecurityUser user) {
		super();
		this.id = id;
		this.artikli = artikli;
		this.user = user;
	}

	public Korpa() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Artikal> getArtikli() {
		return artikli;
	}

	public void setArtikli(List<Artikal> artikli) {
		this.artikli = artikli;
	}

	public SecurityUser getUser() {
		return user;
	}

	public void setUser(SecurityUser user) {
		this.user = user;
	}

	public void addArtikli(List<Artikal> artikli2) {
		this.artikli.addAll(artikli2);
		
	}
	
	public void addArtikal(Artikal artikal) {
		this.artikli.add(artikal);
	}
	
	
	
	
	

}
