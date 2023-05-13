package com.vp.priprema.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vp.priprema.model.Vehicle;

public interface VehicleRepository
		extends JpaRepository<Vehicle, Long> {

	List<Vehicle> findByModelAndFreeTrue(String model);
	
}
