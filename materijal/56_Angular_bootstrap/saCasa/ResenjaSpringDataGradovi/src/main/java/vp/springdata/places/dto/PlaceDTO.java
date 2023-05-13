package vp.springdata.places.dto;

import vp.springdata.places.model.Place;

public class PlaceDTO {
	Long id;
	
	int zipCode;
	
	String name;
	
	CountryDTO country;
	
	public PlaceDTO() {
		
	}
	
	// kreira DTO objekat na osnovu JPA objekta 
	public PlaceDTO(Place place) {
		this.id = place.getId();
		this.zipCode = place.getZipCode();
		this.name = place.getName();
		this.country = new CountryDTO(place.getCountry());
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
