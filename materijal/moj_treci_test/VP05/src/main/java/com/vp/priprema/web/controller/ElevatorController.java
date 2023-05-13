package com.vp.priprema.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vp.priprema.service.ElevatorService;
import com.vp.priprema.web.dto.ElevatorDTO;

@RestController
public class ElevatorController {
	
	@Autowired
	ElevatorService elevatorService;
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("api/elevators")
	public ResponseEntity<List<ElevatorDTO>> getAllElevators(){
		List<ElevatorDTO> elevatorDTOs = elevatorService.findAll().stream()
				.map(elevator -> new ElevatorDTO(elevator))
				.collect(Collectors.toList());
		
	return new ResponseEntity<List<ElevatorDTO>>(elevatorDTOs, HttpStatus.OK);
	}

}
