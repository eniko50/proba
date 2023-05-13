package vp.spring.TestCountry.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import vp.spring.TestCountry.data.CountryRepository;
import vp.spring.TestCountry.model.Country;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CountryServiceUnitTest {

	@Autowired
	CountryService countryService;

	@MockBean
	CountryRepository countryRepository;

	@Before
	public void setup() {
		// definisanje ponasanja test dvojnika countryRepository
		// za ulaz 1, vraca objekat sa podacima o Srbiji
		given(
			countryRepository.findById(1L)
		).willReturn(
			Optional.of(new Country(1L, "Serbia", 7098000))
		);
	}

	@Test
	public void testClassifyCountry() {
		// Srbija ima izmedju jedan i 10 miliona stanovnika
		int result = countryService.classifyCountry(1L);
		assertEquals(2, result);
	}
}
