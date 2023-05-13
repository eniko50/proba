package com.vp.priprema.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vp.priprema.data.ElevatorRepository;
import com.vp.priprema.model.Elevator;

@Component
public class ElevatorService {
	
	@Autowired
	ElevatorRepository elevatorRepository;
	
	public List<Elevator> findAll(){
		return elevatorRepository.findAll();
	}
	
	public List<Elevator> findByNumberOfMaxFloorsSmallerThanOne(){
		List<Elevator> elevators = elevatorRepository.findAll();
		
		List<Elevator> notcorrectElevators = elevators.stream()
				.filter(elevator -> elevator.getNumberOfMaxFloorsLeft() < 1)
				.collect(Collectors.toList());
		
		notcorrectElevators.stream()
			.forEach(elevator -> elevator.setCorrect(false));
		
		return notcorrectElevators;	
	}
	
	

}
