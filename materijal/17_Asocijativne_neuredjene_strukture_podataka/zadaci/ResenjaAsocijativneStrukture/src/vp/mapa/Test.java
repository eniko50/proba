package vp.mapa;

import vp.student.Student;

public class Test {
	public static void main(String[] args) {
		Mapa<String, Student> studenti = new Mapa<>();
		
		Student s1 = new Student("6743", "Marko", "Markovic");
		Student s2 = new Student("3732", "Petar", "Petrovic");
		Student s3 = new Student("3938", "Milan", "Milanovic");
		
		studenti.dodaj(s1.getBrIndeksa(), s1);
		studenti.dodaj(s2.getBrIndeksa(), s2);
		studenti.dodaj(s3.getBrIndeksa(), s3);
		
		Student student = studenti.preuzmi(s2.getBrIndeksa());
		System.out.println(student.getBrIndeksa() + " " + student.getIme() + 
				" " + student.getPrezime());
		
		boolean brisanje = studenti.obrisi(s2.getBrIndeksa());
		System.out.println("Obrisao? " + brisanje);
		
		student = studenti.preuzmi(s2.getBrIndeksa());
		System.out.println("Preuzeti student: " + student);
		
		System.out.println("Sadrzaj mape:");
		Object[] elementi = studenti.preuzmiSveVrednosti();
		for (Object o: elementi) {
			Student s = (Student) o;
			System.out.println(s.getBrIndeksa() + " " + s.getIme() + 
					" " + s.getPrezime());
		}
		
		System.out.println("Svi kljucevi u mapi:");
		Object[] kljucevi = studenti.preuzmiSveKljuceve();
		for (Object o: kljucevi) {
			String k = (String) o;
			System.out.println(k);
		}
	}
}
