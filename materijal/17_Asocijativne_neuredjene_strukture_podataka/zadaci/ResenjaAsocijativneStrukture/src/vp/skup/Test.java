package vp.skup;

import vp.student.Student;

public class Test {
	public static void main(String[] args) {
		Skup<Student> studenti = new Skup<>();
		
		Student s1 = new Student("6743", "Marko", "Markovic");
		Student s2 = new Student("3732", "Petar", "Petrovic");
		Student s3 = new Student("3938", "Milan", "Milanovic");
		
		studenti.dodaj(s1);
		studenti.dodaj(s2);
		studenti.dodaj(s3);
		
		System.out.println("Postoji u skupu? " + studenti.postoji(s1));
		
		studenti.obrisi(s1);
		
		System.out.println("Postoji u skupu? " + studenti.postoji(s1));
		
		System.out.println("Sadrzaj skupa:");
		Object[] elementiSkupa =  studenti.preuzmiElemente(); 
		for (Object o: elementiSkupa) {
			Student s = (Student) o;
			System.out.println(s.getBrIndeksa() + " " + s.getIme() + 
					" " + s.getPrezime()) ;
		}
	}
}
