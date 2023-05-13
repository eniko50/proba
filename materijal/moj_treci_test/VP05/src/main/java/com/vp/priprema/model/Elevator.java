package com.vp.priprema.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Elevator {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private int number;
	
	private int currentFloor;
	
	private int numberOfMaxFloorsLeft;
	
	private boolean correct;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.REFRESH)
	private Building building;

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	public int getNumberOfMaxFloorsLeft() {
		return numberOfMaxFloorsLeft;
	}

	public void setNumberOfMaxFloorsLeft(int numberOfMaxFloorsLeft) {
		this.numberOfMaxFloorsLeft = numberOfMaxFloorsLeft;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	

}
