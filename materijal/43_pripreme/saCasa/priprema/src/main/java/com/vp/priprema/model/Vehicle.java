package com.vp.priprema.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String model;
	private String licencePlate;
	private int mileage;
	private boolean free;

	@JsonIgnore
	@OneToMany(mappedBy="vehicle")
	private Set<Rent> rents = new HashSet<>();

	public Vehicle() {
		super();
	}
	
	public Vehicle(Long id, String model, String licencePlate, int mileage, boolean free) {
		super();
		this.id = id;
		this.model = model;
		this.licencePlate = licencePlate;
		this.mileage = mileage;
		this.free = free;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getMileage() {
		return mileage;
	}
	public String getLicencePlate() {
		return licencePlate;
	}

	public void setLicencePlate(String licencePlate) {
		this.licencePlate = licencePlate;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public boolean isFree() {
		return free;
	}
	public void setFree(boolean free) {
		this.free = free;
	}
	public Set<Rent> getRents() {
		return rents;
	}
	public void setRents(Set<Rent> rents) {
		this.rents = rents;
	}
}
