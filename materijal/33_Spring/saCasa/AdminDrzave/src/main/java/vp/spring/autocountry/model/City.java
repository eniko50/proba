package vp.spring.autocountry.model;

public class City {
	
	private int id;
	private String name;
	private String zipCode;
	private Country country;
	
	public City(int id, String name, String zipCode, Country country) {
		this.id = id;
		this.name = name;
		this.zipCode = zipCode;
		this.country = country;
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

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", zipCode=" + zipCode + ", country=" + country + "]";
	}
}
