package vp.spring.TestCountry.web.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import vp.spring.TestCountry.web.dto.CountryDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CountryControllerTest {
	
	
	@Autowired
    private TestRestTemplate restTemplate;
	
	@Test
	public void testGetCountry() {
		ResponseEntity<CountryDTO> responseEntity =
	            restTemplate.getForEntity("/api/countries/3", CountryDTO.class);
		
		CountryDTO country = responseEntity.getBody();
		
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertNotNull(country);
        assertEquals("Italy", country.getName());
        assertEquals(60800000, country.getPopulation());
	}
}
