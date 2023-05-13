package com.agancy.tourist_agency.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Tour {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Trip trip;
	
	@ManyToOne
	private TourGuide guide;
	
	@ManyToMany(mappedBy = "visitedTours")
	private Set<Traveler> travelers = new HashSet<>();
	
	private String startDate;
	private String endDate;

	public Tour() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public TourGuide getGuide() {
		return guide;
	}

	public void setGuide(TourGuide guide) {
		this.guide = guide;
	}

	public Set<Traveler> getTravelers() {
		return travelers;
	}

	public void setTravelers(Set<Traveler> travelers) {
		this.travelers = travelers;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
