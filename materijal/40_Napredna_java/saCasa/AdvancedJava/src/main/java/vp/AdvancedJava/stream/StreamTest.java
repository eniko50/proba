package vp.AdvancedJava.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {
	
	public static void main(String[] args) {
		List<Country> countries = new ArrayList<Country>();
		Country c1 = new Country(1, "Serbia", 7057000);
		Country c2 = new Country(2, "France", 66810000);
		Country c3 = new Country(3, "Italy", 60800000);
		
		Map<Character, List<Country>> map = new HashMap<>();
		for (Country c: countries) {
			char firstChar = c.getName().charAt(0);
			if (!map.containsKey(firstChar)) {
				map.put(firstChar, new ArrayList<>());
			}
				
			map.get(firstChar).add(c);
		}
		
		Map<Character, List<Country>> map2 = countries.parallelStream()
			.collect(Collectors.groupingBy(c -> c.getName().charAt(0)));
		
	}
}





