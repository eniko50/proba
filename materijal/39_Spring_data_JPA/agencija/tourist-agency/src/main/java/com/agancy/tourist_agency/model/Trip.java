package com.agancy.tourist_agency.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Trip {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	
	@ManyToMany
	private Set<Destination> destinations = new HashSet<>();
	
	@OneToMany(mappedBy = "trip")
	private Set<Tour> tours = new HashSet<>();

	public Trip() {
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

	public Set<Destination> getDestinations() {
		return destinations;
	}

	public void setDestinations(Set<Destination> destinations) {
		this.destinations = destinations;
	}

	public Set<Tour> getTours() {
		return tours;
	}

	public void setTours(Set<Tour> tours) {
		this.tours = tours;
	}
}
