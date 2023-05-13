package vp.spring.TestCountry.data;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import vp.spring.TestCountry.data.CountryRepository;
import vp.spring.TestCountry.model.Country;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CountryRepositoryIntegrationTest {
	@Autowired
	CountryRepository countryRepository;
	
	@Test
	public void testFindByPopulation() {
		List<Country> countries = countryRepository.findByPopulation(60800000);
		
		assertEquals(1, countries.size());
        assertEquals("Italy", countries.get(0).getName());
        assertEquals(60800000, countries.get(0).getPopulation());
	}
	
	@Test
	public void testFindByNameContains() {
		List<Country> countries = countryRepository.
				findByNameContains("Ita");
		
		assertEquals(1, countries.size());
        assertEquals("Italy", countries.get(0).getName());
        assertEquals(60800000, countries.get(0).getPopulation());
	}
}