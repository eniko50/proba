package vp.AdvancedJava.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import vp.AdvancedJava.annotation.Country;

public class DisplayCountryData {
	public static void main(String args[]) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InvocationTargetException {
		
		Country country = new Country(1, "Serbia", 7057000);
		
		// ispis svih atributa za drzavu genericki, prolaskom kroz sva polja klase refleksijom
		Field[] fields = Country.class.getDeclaredFields(); // preuzimanje niza svih atributa iz klase refleksijom 
		
		// prolazimo kroz sve atribute
		for (Field field: fields) {
			// preuzimamo objekat koji reprezentuje get metodu za trenutni atribut
			
			// get metoda ima oblik get<ime polja>, pri cemu je prvo slovo u imenu polja veliko
			Method fieldGetter = Country.class.getMethod("get" + 
					String.valueOf(field.getName().charAt(0)).toUpperCase() + // veliko prvo slovo u imenu atributa 
					field.getName().substring(1)); // ostatak imena atributa se uzme kako je definisan
			
			// ispis imena polja i poziv gore definisane get metode objekta country da bi vratila vrednost
			System.out.println(field.getName() + ": " + fieldGetter.invoke(country));
		}
	}
	
	
}
