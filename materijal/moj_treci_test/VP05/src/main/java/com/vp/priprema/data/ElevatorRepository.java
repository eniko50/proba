package com.vp.priprema.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vp.priprema.model.Elevator;

@Repository
public interface ElevatorRepository extends JpaRepository<Elevator, Long> {
	
}
