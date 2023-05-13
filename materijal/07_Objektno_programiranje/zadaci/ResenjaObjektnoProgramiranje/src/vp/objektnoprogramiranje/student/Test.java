package vp.objektnoprogramiranje.student;

public class Test {

	public static void main(String[] args) {
		Student s1 = new Student();
		s1.brojIndeksa = "1783";
		s1.ime = "Marko";
		s1.prezime = "Markovic";
		System.out.println(s1.brojIndeksa + " " + s1.ime + " " + s1.prezime);
		
		Student s2 = new Student();
		s2.brojIndeksa = "3345";
		s2.ime = "Ivan";
		s2.prezime = "Ivanovic";
		//drugi nacin ispisa
		String s = s2.tekstZaIspis();
		System.out.println(s);
		// moze i ovako krace
		// System.out.println(s2.tekstZaIspis());
		
		Student s3 = new Student();
		s3.brojIndeksa = "3474";
		s3.ime = "Tamara";
		s3.prezime = "Popovic";
		//treci nacin ispisa
		s3.ispisi();
		
		Student s4 = new Student();
		s4.brojIndeksa = "4646";
		s4.ime = "Nikola";
		s4.prezime = "Nikolic";
		//cetvrti nacin ispisa
		s4.ispisiDrugaVarijanta();		
	}
}
