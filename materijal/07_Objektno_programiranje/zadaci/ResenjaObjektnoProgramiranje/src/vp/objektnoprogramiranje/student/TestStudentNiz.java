package vp.objektnoprogramiranje.student;

public class TestStudentNiz {

	public static void main(String[] args) {
		Student s1 = new Student();
		s1.brojIndeksa = "1783";
		s1.ime = "Marko";
		s1.prezime = "Markovic";
		
		Student s2 = new Student();
		s2.brojIndeksa = "3345";
		s2.ime = "Ivan";
		s2.prezime = "Ivanovic";
		
		Student s3 = new Student();
		s3.brojIndeksa = "3474";
		s3.ime = "Tamara";
		s3.prezime = "Popovic";
		
		Student s4 = new Student();
		s4.brojIndeksa = "4646";
		s4.ime = "Nikola";
		s4.prezime = "Nikolic";
		
		// ubacivanje studenata u niz
		Student[] studenti = {s1, s2, s3, s4};

		// ispis studenata
		for (int i = 0; i < 4; i++) {
			studenti[i].ispisi();
		}

	}

}
