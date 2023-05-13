package com.vp.priprema.service;

import com.vp.priprema.data.VehicleRepository;
import com.vp.priprema.model.Vehicle;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VehicleServiceTest {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleService vehicleService;

    @After
    public void afterTests() {
        vehicleRepository.deleteAll();
    }

    @Test
    public void testGetAllVehicles() {
        vehicleRepository.save(new Vehicle(0L, "Tesla S", "btngu", 42000, false));
        vehicleRepository.save(new Vehicle(0L, "Peugeot 2008", "mrsrvr", 121000, true));

        List<Vehicle> vehicles = vehicleService.findAll();

        assertEquals(2, vehicles.size());
    }

    @Test
    public void testFindLeastMileage() {
        vehicleRepository.save(new Vehicle(0L, "Fiat Punto", "NS1337", 42000, true));
        vehicleRepository.save(new Vehicle(0L, "Fiat Punto", "BG5544", 121000, true));
        vehicleRepository.save(new Vehicle(0L, "Dacia Duster", "hello", 1000, true));

        Map<String, Vehicle> leastMileageVehicles = vehicleService.findLeastMileageByModel();

        assertEquals(2, leastMileageVehicles.size());

        Vehicle punto = leastMileageVehicles.get("Fiat Punto");
        assertEquals(42000, punto.getMileage());
        assertEquals("NS1337", punto.getLicencePlate());

        Vehicle duster = leastMileageVehicles.get("Dacia Duster");
        assertEquals(1000, duster.getMileage());
        assertEquals("hello", duster.getLicencePlate());
    }
}