package vp.AdvancedJava.annotation;

import vp.AdvancedJava.annotation.SearchBy.SearchType;

@SearchBy(fields = {"name", "population"}, searchType = SearchType.CONTAINS)
public class Country {
	private int id;
	private String name;
	private int population;
	
	public Country(int id, String name, int population) {
		super();
		this.id = id;
		this.name = name;
		this.population = population;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
