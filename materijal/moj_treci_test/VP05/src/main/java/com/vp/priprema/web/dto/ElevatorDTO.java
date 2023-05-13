package com.vp.priprema.web.dto;

import com.vp.priprema.model.Elevator;

public class ElevatorDTO {
	
	private Long id;
	private int number;
	private int currentFloor;
	private int numberOfMaxFloorsLeft;
	private boolean correct;
	
	private BuildingDTO buildingDTO;
	
	public ElevatorDTO() {
		
	}

	public ElevatorDTO(Long id, int number, int currentFloor, int numberOfMaxFloorsLeft, boolean correct) {
		super();
		this.id = id;
		this.number = number;
		this.currentFloor = currentFloor;
		this.numberOfMaxFloorsLeft = numberOfMaxFloorsLeft;
		this.correct = correct;
	}

	public ElevatorDTO(Elevator elevator) {
		super();
		this.id = elevator.getId();
		this.number = elevator.getNumber();
		this.currentFloor = elevator.getCurrentFloor();
		this.numberOfMaxFloorsLeft = elevator.getNumberOfMaxFloorsLeft();
		this.correct = elevator.isCorrect();
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

	public BuildingDTO getBuildingDTO() {
		return buildingDTO;
	}

	public void setBuildingDTO(BuildingDTO buildingDTO) {
		this.buildingDTO = buildingDTO;
	}
	
}
