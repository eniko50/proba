package com.vp.priprema.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vp.priprema.data.BuildingRepository;
import com.vp.priprema.model.Building;
import com.vp.priprema.model.Elevator;
import com.vp.priprema.service.BuildingService;
import com.vp.priprema.web.dto.BuildingDTO;


@RestController
public class BuildingController {
	
	@Autowired
	BuildingService buildingService;
	
	@Autowired
	BuildingRepository buildingRepository;
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("api/buildings")
	public ResponseEntity<List<BuildingDTO>> getAllBuildings(){
		List<BuildingDTO> buildingDTOs = buildingService.findAll().stream()
				.map(building -> new BuildingDTO(building))
				.collect(Collectors.toList());
		
	return new ResponseEntity<List<BuildingDTO>>(buildingDTOs, HttpStatus.OK);
	}
	
	@GetMapping("api/buildings/{id}/elevators/drive")
	public ResponseEntity<Integer> drivingByElevator(@PathVariable Long id, @RequestBody List<Integer> floors){
		Building building = buildingService.findById(id);
		Integer startFloor = floors.get(0);
		Integer endFloor = floors.get(1);
		List<Elevator> elevatorsInBuilding = (List<Elevator>) building.getElevators();
		Elevator correctElevator = null;
		for (Elevator elevator : elevatorsInBuilding) {
			if(elevator.isCorrect()) {
				int totalNumberOfFloorsDrive = endFloor - startFloor;
				elevator.setNumberOfMaxFloorsLeft(elevator.getNumberOfMaxFloorsLeft() - totalNumberOfFloorsDrive);
				correctElevator = elevator;
			}
		}
		return new ResponseEntity<Integer>(correctElevator.getNumber(), HttpStatus.OK);
	}

}
