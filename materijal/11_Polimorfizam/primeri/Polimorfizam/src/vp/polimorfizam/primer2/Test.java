package vp.polimorfizam.primer2;

import java.util.ArrayList;

public class Test {
	public static void main(String[] args) {
		ArrayList<Osoba> osobe = new ArrayList<Osoba>();

		Osoba o1 = new Osoba("Pera","Peric");
		
		osobe.add(o1);
		
		Student s1 = new Student("Marko", "Markovic", "E123000");
				
		osobe.add(s1);
		
		ClanBiblioteke cb1 = new ClanBiblioteke("Steva", "Stevic", "123321");
	
		osobe.add(cb1);

		for (Osoba osoba : osobe) {
			osoba.predstaviSe();
		}
	}
}
