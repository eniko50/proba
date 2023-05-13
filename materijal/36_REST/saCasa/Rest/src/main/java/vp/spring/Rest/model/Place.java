package vp.spring.Rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Place {
	private int id;
	private int zipCode;
	private String name;
	Country country;
	
	public Place(int id, int zipCode, String name, Country country) {
		super();
		this.id = id;
		this.zipCode = zipCode;
		this.name = name;
		this.country = country;
	}

	public Place() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	@Override
	public String toString() {
		return "Place [id=" + id + ", zipCode=" + zipCode + ", name=" + name
				+ ", country =" + country + "]";
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Place other = (Place) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
