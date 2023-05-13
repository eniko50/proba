package vp.spring.securitycountry.web.dto;

import vp.spring.securitycountry.model.Country;

public class CountryDTO {
	
	private Long id;
	
	private String name;
	
	private int population;
	
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
}
