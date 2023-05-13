package com.vp.priprema.web.dto;

import java.util.List;

import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;

import com.vp.priprema.model.Building;

public class BuildingDTO {
	
	private Long id;
	private String name;
	private int numberOfFloors;
	private List<ElevatorDTO> elevatorDTOs;
	
	public BuildingDTO() {
		
	}

	public BuildingDTO(Long id, String name, int numberOfFloors) {
		super();
		this.id = id;
		this.name = name;
		this.numberOfFloors = numberOfFloors;
	}

	public BuildingDTO(Building building) {
		this.id = building.getId();
		this.name = building.getName();
		this.numberOfFloors = building.getNumberOfFloors();
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

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}

	public List<ElevatorDTO> getElevatorDTOs() {
		return elevatorDTOs;
	}

	public void setElevatorDTO(List<ElevatorDTO> elevatorDTOs) {
		this.elevatorDTOs = elevatorDTOs;
	}
	
}
