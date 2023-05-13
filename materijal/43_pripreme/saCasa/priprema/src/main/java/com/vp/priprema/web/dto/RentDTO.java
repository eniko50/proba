package com.vp.priprema.web.dto;

public class RentDTO {
	private String model;
	private String firstName;
	private String lastName;
	private String licence;

    public RentDTO() {
    }

    public RentDTO(String model, String firstName, String lastName, String licence) {
        this.model = model;
        this.firstName = firstName;
        this.lastName = lastName;
        this.licence = licence;
    }

    public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLicence() {
		return licence;
	}
	public void setLicence(String licence) {
		this.licence = licence;
	}
}
