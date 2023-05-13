package com.vp.priprema.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vp.priprema.model.Rent;
import com.vp.priprema.model.Vehicle;
import com.vp.priprema.service.VehicleService;
import com.vp.priprema.web.dto.RentDTO;

@RestController
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;

	@PostMapping("/api/vehicles")
	public ResponseEntity<Rent> rent(
			@RequestBody RentDTO dto) {
		List<Vehicle> vehicles = vehicleService
				.findFreeByModel(dto.getModel());
		
		if (vehicles.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Rent rent = vehicleService.rent(dto, vehicles);
		
		return new ResponseEntity<>(rent, HttpStatus.OK);
	}
}




