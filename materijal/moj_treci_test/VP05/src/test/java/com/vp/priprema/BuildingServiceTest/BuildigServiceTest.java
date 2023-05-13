package com.vp.priprema.BuildingServiceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.vp.priprema.data.BuildingRepository;
import com.vp.priprema.model.Building;
import com.vp.priprema.service.BuildingService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BuildigServiceTest {
	
	@Autowired
	BuildingService buildingService;
	
	@Autowired
	BuildingRepository buildingRepo;
	
	@Test
	public void tetsFindAll() {
		int size = buildingService.findAll().size();
		Building building = new Building();
		building.setId(0L);
		building.setName("Fifi");
		building.setElevators(null);
		building.setNumberOfFloors(3);
		buildingRepo.save(building);
		
		assertEquals(size + 1, buildingService.findAll().size());
		
		buildingRepo.delete(building);
	}
	
	@Test
	public void testFindById() {
		Building building = new Building();
		building.setId((long) 1);
		building.setName("Fifi");
		building.setElevators(null);
		building.setNumberOfFloors(3);
		buildingRepo.save(building);
		
		Building building2  = buildingService.findById(building.getId());
		
		assertEquals("Fifi", building2.getName());
		assertNull(building.getElevators());
		assertEquals(3, building2.getNumberOfFloors());
		
		buildingRepo.delete(building);

		}

}
