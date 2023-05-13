package com.agancy.tourist_agency.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class TourGuide extends Person {

	@OneToMany(mappedBy = "guide")
	private Set<Tour> tours = new HashSet<>();

	public TourGuide() {
	}

	public Set<Tour> getTours() {
		return tours;
	}

	public void setTours(Set<Tour> tours) {
		this.tours = tours;
	}
}
