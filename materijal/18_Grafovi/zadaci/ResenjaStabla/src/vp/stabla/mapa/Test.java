package vp.stabla.mapa;

public class Test {
	public static void main(String[] args) {
		BSTMapa<Student> studenti = new BSTMapa<>();
		
		Student s1 = new Student(5, "6743", "Marko", "Markovic");
		Student s2 = new Student(7, "3732", "Petar", "Petrovic");
		Student s3 = new Student(3, "3938", "Milan", "Milanovic");
		Student s4 = new Student(4, "2322", "Ivan", "Ivanovic");
		Student s5 = new Student(1, "1243", "Stefan", "Stefanovic");
		
		studenti.dodaj(s1.getId(), s1);
		studenti.dodaj(s2.getId(), s2);
		studenti.dodaj(s3.getId(), s3);
		studenti.dodaj(s4.getId(), s4);
		studenti.dodaj(s5.getId(), s5);
		
		Student student = studenti.preuzmi(s2.getId());
		System.out.println(student.getBrIndeksa() + " " + student.getIme() + 
				" " + student.getPrezime());
		
		boolean brisanje = studenti.obrisi(s2.getId());
		System.out.println("Obrisao? " + brisanje);
		
		student = studenti.preuzmi(s2.getId());
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
			int k = (int) o;
			System.out.println(k);
		}
	}
}
