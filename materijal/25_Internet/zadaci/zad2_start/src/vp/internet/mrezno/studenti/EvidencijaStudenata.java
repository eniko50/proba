package vp.internet.mrezno.studenti;

import java.util.ArrayList;
import java.util.List;

public class EvidencijaStudenata {
	private List<Student> studenti = new ArrayList<Student>();
	
	public EvidencijaStudenata() {
		inicijalizujStudente();
	}
	
	private void inicijalizujStudente() {
		studenti.add(new Student("1783", "Marko", "Markovic"));
		studenti.add(new Student("3345", "Ivan", "Ivanovic"));
		studenti.add(new Student("3474", "Tamara", "Popovic"));
	}
	
	public void ispisiStudente() {
		for (Student s: studenti) {
			System.out.println(s);
		}
	}
	
	public Student getStudent(String brIndeksa) { 
		for (Student s: studenti) {
			if (s.getBrIndeksa().equals(brIndeksa)) {
				return s;
			}
		}
		return null;		
	}
	
	public boolean dodajStudenta(String brIndeksa, String ime, String prezime) { 
		Student student = new Student(brIndeksa, ime, prezime);
		return studenti.add(student);
	}
	
	public boolean izmeniStudenta(String brIndeksa, String ime, String prezime) { 
		for (Student s: studenti) {
			if (s.getBrIndeksa().equals(brIndeksa)) {
				s.setIme(ime);
				s.setPrezime(prezime);
				return true;
			}
		}
		return false;		
	}
	
	public boolean obrisiStudenta(String brIndeksa) { 
		for (Student s: studenti) {
			if (s.getBrIndeksa().equals(brIndeksa)) {
				studenti.remove(s);
				return true;
			}
		}
		return false;		
	}
}
