package povp.hashmapprimer;

public class Test {

	public static void main(String[] args) {
		Mapa<String, Student> mapa = new Mapa<>();
		
		Student s1 = new Student("6389", "Marko", "Marković");
		Student s2 = new Student("7430", "Petar", "Petrović");
		Student s3 = new Student("7205", "Jovan", "Jovanović");
		Student s4 = new Student("8364", "Filip", "Filipović");
		
		mapa.dodaj(s1.getBrojIndeksa(), s1);
		mapa.dodaj(s2.getBrojIndeksa(), s2);
		mapa.dodaj(s3.getBrojIndeksa(), s3);
		mapa.obrisi(s1.getBrojIndeksa());
		
		Student s = mapa.preuzmi(s1.getBrojIndeksa());
		int brojElemenata = mapa.brojElemenata();
		System.out.println(brojElemenata);
		
		Object[] kljucevi = mapa.preuzmiKljuceve();
		for (Object kljuc : kljucevi) {
			String brojIndeksa = (String) kljuc;
			System.out.println(brojIndeksa);
		}
		/*
		Object[] vrednosti = mapa.preuzmiVrednosti();
		for (Object vrednost : vrednosti) {
			Student student = (Student) vrednost;
			System.out.println(student);
		}
*/
	}

}
