package com.vp.priprema.web.controller;

import com.vp.priprema.data.RentRepository;
import com.vp.priprema.data.VehicleRepository;
import com.vp.priprema.model.Rent;
import com.vp.priprema.model.Vehicle;
import com.vp.priprema.web.dto.RentDTO;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class VehicleControllerTest {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @After
    public void afterTests() {
        rentRepository.deleteAll();
        vehicleRepository.deleteAll();
    }

    @Test
    public void testRentNoModel() {
        vehicleRepository.save(new Vehicle(0L, "Fiat Punto", "NS1337", 42000, true));

        RentDTO dto = createRentDto("Lada XCode");
        final ResponseEntity<Rent> response = restTemplate.postForEntity("/api/vehicles", dto, Rent.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testRentNoFree() {
        vehicleRepository.save(new Vehicle(0L, "Fiat Punto", "NS1337", 42000, false));

        RentDTO dto = createRentDto("Fiat Punto");
        final ResponseEntity<Rent> response = restTemplate.postForEntity("/api/vehicles", dto, Rent.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testRentSuccess() {
        vehicleRepository.save(new Vehicle(0L, "Fiat Punto", "NS1337", 42000, true));
        vehicleRepository.save(new Vehicle(0L, "Golf 2", "NS4321", 12, true));

        RentDTO dto = createRentDto("Fiat Punto");
        final ResponseEntity<Rent> response = restTemplate.postForEntity("/api/vehicles", dto, Rent.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        final Rent rent = response.getBody();
        assertNotNull(rent);

        assertEquals("Nikola", rent.getFirstName());
        assertEquals("Lukic", rent.getLastName());
        assertEquals("nema", rent.getLicence());

        final Vehicle vehicle = rent.getVehicle();
        assertNotNull(vehicle);

        assertEquals("Fiat Punto", vehicle.getModel());
        assertEquals("NS1337", vehicle.getLicencePlate());
        assertEquals(42000, vehicle.getMileage());
    }

    @Test
    public void testRentSuccessFreeTaken() {
        vehicleRepository.save(new Vehicle(0L, "Fiat Punto", "NS1337", 42000, true));
        vehicleRepository.save(new Vehicle(0L, "Fiat Punto", "NS4321", 12, true));

        RentDTO dto = createRentDto("Fiat Punto");
        final ResponseEntity<Rent> response = restTemplate.postForEntity("/api/vehicles", dto, Rent.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        final Rent rent = response.getBody();
        assertNotNull(rent);

        assertEquals("Nikola", rent.getFirstName());
        assertEquals("Lukic", rent.getLastName());
        assertEquals("nema", rent.getLicence());

        final Vehicle vehicle = rent.getVehicle();
        assertNotNull(vehicle);

        assertEquals("Fiat Punto", vehicle.getModel());
        assertEquals("NS1337", vehicle.getLicencePlate());
        assertEquals(42000, vehicle.getMileage());
    }

    private RentDTO createRentDto(String model) {
        return new RentDTO(model, "Nikola", "Lukic", "nema");
    }
}