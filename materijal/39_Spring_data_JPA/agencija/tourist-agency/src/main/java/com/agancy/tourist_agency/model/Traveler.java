package com.agancy.tourist_agency.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Traveler extends Person {

	@ManyToMany
	private Set<Tour> visitedTours = new HashSet<>();

	public Traveler() {
	}

	public Set<Tour> getVisitedTours() {
		return visitedTours;
	}

	public void setVisitedTours(Set<Tour> visitedTours) {
		this.visitedTours = visitedTours;
	}
}
