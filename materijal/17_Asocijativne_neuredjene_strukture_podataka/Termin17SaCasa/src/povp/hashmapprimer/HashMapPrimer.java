package povp.hashmapprimer;

import java.util.*;

public class HashMapPrimer {

	public static void main(String[] args) {
		
		Map<String, Student> mapa = new HashMap<>();
		
		Student s1 = new Student("6389", "Marko", "Marković");
		Student s2 = new Student("7430", "Petar", "Petrović");
		Student s3 = new Student("7205", "Jovan", "Jovanović");
		Student s4 = new Student("8364", "Filip", "Filipović");
		
		mapa.put(s1.getBrojIndeksa(), s1);
		mapa.put(s2.getBrojIndeksa(), s2);
		
		Student s = mapa.get(s2.getBrojIndeksa());
		mapa.remove(s2.getBrojIndeksa());
		
		Set<String> keys = mapa.keySet();
		for (String key : keys) {
			
		}
		
		Collection<Student> studenti = mapa.values();
	}

}
