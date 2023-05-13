package vp.spring.SpringDataJPACountry.web.dto;

public class CreatePlaceDTO {
	
	private String name;
	private int zipCode;
	private long countryId;
	
	public CreatePlaceDTO() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
}
