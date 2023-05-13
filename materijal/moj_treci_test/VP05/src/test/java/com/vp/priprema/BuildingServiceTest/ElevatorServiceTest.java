package com.vp.priprema.BuildingServiceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.vp.priprema.data.ElevatorRepository;
import com.vp.priprema.model.Elevator;
import com.vp.priprema.service.ElevatorService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ElevatorServiceTest {
	
	@Autowired
	ElevatorService elevatorService;
	
	@Autowired
	ElevatorRepository elevatorRepo;
	
	@After
	public void after() {
		elevatorRepo.deleteAll();
	}
	
	@Test
	public void testFindByNumberOfMaxFloorsSmallerThanOne() {
		Elevator elevator = new Elevator();
		elevator.setId(0L);
		elevator.setBuilding(null);
		elevator.setCorrect(false);
		elevator.setCurrentFloor(0);
		elevator.setNumber(15);
		elevator.setNumberOfMaxFloorsLeft(0);
		
		elevatorRepo.save(elevator);
		
		List<Elevator> notCorrectElevators = elevatorService.findByNumberOfMaxFloorsSmallerThanOne();
		
		assertNull(notCorrectElevators.get(0).getBuilding());
		assertEquals(0, notCorrectElevators.get(0).getCurrentFloor());
		assertFalse(notCorrectElevators.get(0).isCorrect());
		assertEquals(15, notCorrectElevators.get(0).getNumber());
		assertEquals(0, notCorrectElevators.get(0).getNumberOfMaxFloorsLeft());
		
	}
}
