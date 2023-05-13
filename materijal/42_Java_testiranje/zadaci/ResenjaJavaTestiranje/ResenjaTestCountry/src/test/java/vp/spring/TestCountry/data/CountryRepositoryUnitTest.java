package vp.spring.TestCountry.data;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import vp.spring.TestCountry.model.Country;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CountryRepositoryUnitTest {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	CountryRepository countryRepository;
	
	@Before
	public void setUp() {
		entityManager.persist(new Country("Serbia", 7098000));
		entityManager.persist(new Country("France", 66810000));
		entityManager.persist(new Country("Italy", 60800000));
	}
	
	@Test
	public void testFindByPopulation() {
		List<Country> countries = countryRepository.findByPopulation(60800000);
		
		assertEquals(1, countries.size());
        assertEquals("Italy", countries.get(0).getName());
        assertEquals(60800000, countries.get(0).getPopulation());
	}
	
	@Test 
	public void testFindByNameContains() {
		List<Country> countries = countryRepository.findByNameContains("tal");
		
		assertEquals(1, countries.size());
        assertEquals("Italy", countries.get(0).getName());
        assertEquals(60800000, countries.get(0).getPopulation());
	}
	
	@Test 
	public void testFindByNameContainsOrPopulationGreaterThan() {
		List<Country> countries = countryRepository.
				findByNameContainsOrPopulationGreaterThan("Ser", 65000000);
		
		assertEquals(2, countries.size());
		
        assertEquals("Serbia", countries.get(0).getName());
        assertEquals(7098000, countries.get(0).getPopulation());
        
        assertEquals("France", countries.get(1).getName());
        assertEquals(66810000, countries.get(1).getPopulation());
	}
	
}
