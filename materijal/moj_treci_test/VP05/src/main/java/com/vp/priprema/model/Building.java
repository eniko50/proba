package com.vp.priprema.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Building {
	
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	
	private int numberOfFloors;
	
	@JsonIgnore
	@OneToMany(mappedBy="building", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<Elevator> elevators = new HashSet<>();

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

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}
	
	public Set<Elevator> getElevators() {
		return elevators;
	}

	public void setElevators(Set<Elevator> elevators) {
		this.elevators = elevators;
	}
}
