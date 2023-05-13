package vp.AdvancedJava.annotation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import vp.AdvancedJava.annotation.Country;
import vp.AdvancedJava.annotation.SearchBy;
import vp.AdvancedJava.annotation.SearchBy.SearchType;

public class TestSearchCountry {
	public static void main(String args[]) throws IOException,
			NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		List<Country> countries = new ArrayList<Country>();
		countries.add(new Country(1, "Serbia", 7057000));
		countries.add(new Country(2, "France", 66810000));
		countries.add(new Country(3, "Italy", 60800000));

		// korisnik unosi vrednost koju trazi, a ta vrednost se proverava u svim
		// poljima
		// definisanim u SearchBy anotaciji u klasi
		System.out.print("Unesite vrednost za pretragu drzava: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputText = br.readLine();

		// preuzmemo iz anotacije po kojim atributima treba pretrazivati
		SearchBy annotationData = Country.class.getAnnotation(SearchBy.class);
		// spisak atributa po kojima pretrazujemo
		String[] searchableFields = annotationData.fields(); 
		
		// preuzimamo tip poredjenja iz anotacije u klasi Country - equals ili contains
		SearchType comparisonCriteria = annotationData.searchType();
		
		// trazimo drzavu koja odgovara kriterijumu
		for (Country country : countries) {
			// po svakom od polja probamo da pretrazimo
			for (String field : searchableFields) {
				// poziv get metode za ovo polje
				Method fieldGetter = Country.class.getMethod("get"
						+ String.valueOf(field.charAt(0)).toUpperCase()
						+ field.substring(1));					
				Object fieldValue = fieldGetter.invoke(country);
				
				// poredjenje trazene vrednosti sa vrednoscu koju je vratila get metoda	
				// poredjenje se vrsi sa equals ili contains u zavisnosti kako je anotirana klasa
				if ((comparisonCriteria == SearchType.EQUALS && fieldValue.toString().equals(inputText)) || 
					(comparisonCriteria == SearchType.CONTAINS && fieldValue.toString().contains(inputText))) {
					// ako je drzava nadjena, ispisemo je
					System.out.println(country.getId() + " " + country.getName()
									+ " " + country.getPopulation());
					break;
				}
			}
		}
	}
}
