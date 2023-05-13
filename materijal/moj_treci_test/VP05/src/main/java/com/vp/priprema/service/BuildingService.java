package com.vp.priprema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vp.priprema.data.BuildingRepository;
import com.vp.priprema.model.Building;


@Component
public class BuildingService {
	
	@Autowired
	BuildingRepository buildingRepository;
	
	public List<Building> findAll(){
		return buildingRepository.findAll();
	}
	
	public Building findById(Long id) {
		return buildingRepository.findById(id).get();
	}
	
	

}
