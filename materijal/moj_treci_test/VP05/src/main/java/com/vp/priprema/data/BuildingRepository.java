package com.vp.priprema.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vp.priprema.model.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long>{

}
