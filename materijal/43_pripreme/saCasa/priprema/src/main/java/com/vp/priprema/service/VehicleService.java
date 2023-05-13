package com.vp.priprema.service;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vp.priprema.data.RentRepository;
import com.vp.priprema.data.VehicleRepository;
import com.vp.priprema.model.Rent;
import com.vp.priprema.model.Vehicle;
import com.vp.priprema.web.dto.RentDTO;

@Service
public class VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private RentRepository rentRepository;
	
	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}
	
	public List<Vehicle> findFreeByModel(String model) {
		return vehicleRepository.findByModelAndFreeTrue(model);
	}

	public Rent rent(RentDTO dto, List<Vehicle> vehicles) {
		Random random = new Random();
		Vehicle vehicle = vehicles.get(random.nextInt(vehicles.size()));
		
		Rent rent = new Rent(0L, dto.getFirstName(), dto.getLastName(),
				dto.getLicence()	, vehicle);
		
		rentRepository.save(rent);
		vehicle.setFree(false);
		vehicleRepository.save(vehicle);
		
		return rent;
	}
	
	public Map<String, Vehicle> findLeastMileageByModel() {
		Map<String, List<Vehicle>> vehiclesByModel = vehicleRepository.findAll().stream()
				.collect(Collectors.groupingBy(Vehicle::getModel));

		// Entry je klasa koje predstavlja jedan par (kljuc, vrednost), tipizirana kao sto je mapa tipizirana.
		// Map<String, List<Vehicle>> ima svoje entrije Entry<String, List<Vehicle>>.
		return vehiclesByModel.entrySet().stream() // Stream parova (kljuc, vrednost)
				.collect(Collectors.toMap(Map.Entry::getKey, entry -> findVehicleWithLeastMileage(entry.getValue())));
	}

	private Vehicle findVehicleWithLeastMileage(List<Vehicle> vehicles) {
		int minimumMileage = vehicles.stream()
				.mapToInt(Vehicle::getMileage)
				.min()
				.orElse(0);

		List<Vehicle> minimumVehicles = vehicles.stream()
				.filter(vehicle -> vehicle.getMileage() == minimumMileage)
				.collect(Collectors.toList());

		Random random = new Random();

		return minimumVehicles.get(random.nextInt(minimumVehicles.size()));
	}
}



