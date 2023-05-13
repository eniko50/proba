package vp.spring.SpringDataJPACountry.web.dto;

import vp.spring.SpringDataJPACountry.model.Place;

public class PlaceDTO {
	Long id;
	
	int zipCode;
	
	String name;
	
	CountryDTO country;
	
	// kreira DTO objekat na osnovu JPA objekta. Ne postavlja atribut country 
	public PlaceDTO(Place city) {
		this.id = city.getId();
		this.zipCode = city.getZipCode();
		this.name = city.getName();
	}

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

	public CountryDTO getCountry() {
		return country;
	}

	public void setCountry(CountryDTO country) {
		this.country = country;
	}	
}
