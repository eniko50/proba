package vp.springdata.places.dto;

import java.util.ArrayList;
import java.util.List;

import vp.springdata.places.model.Country;

public class CountryDTO {
	
	private Long id;
	
	private String name;
	
	private int population;
	
	private List<PlaceDTO> places = new ArrayList<PlaceDTO>();
	
	// ovaj konstruktor se koristi kod automatske deserijalizacije
	public CountryDTO() {
	}
	
	public CountryDTO(Long id, String name, int population) {
		super();
		this.id = id;
		this.name = name;
		this.population = population;
	}
	
	// kreiranje DTO objekta na osnovu JPA entiteta. Ne popunjava kolekciju gradova
	public CountryDTO(Country country) {
		this.id = country.getId();
		this.name = country.getName();
		this.population = country.getPopulation();		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public List<PlaceDTO> getPlaces() {
		return places;
	}

	public void setPlaces(List<PlaceDTO> places) {
		this.places = places;
	}
}
