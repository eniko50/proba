package vp.spring.SpringDataJPACountry.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
//neophodno definisati i bazu jer Hibernate pravi problem ako u drugoj bazi ima istoimena tabela 
@Table(catalog = "dbcountry", name = "place") 
public class Place {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	int zipCode;
	
	String name;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	Country country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}	
}
