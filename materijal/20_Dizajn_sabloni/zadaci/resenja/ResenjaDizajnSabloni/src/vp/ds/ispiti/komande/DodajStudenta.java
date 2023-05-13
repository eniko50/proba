package vp.ds.ispiti.komande;

import java.util.List;

import vp.ds.ispiti.Util;
import vp.ds.ispiti.model.Student;


public class DodajStudenta implements Komanda {

	private List<Student> studenti;
	
	private Student noviStudent;
	
	public DodajStudenta(List<Student> studenti) {
		this.studenti = studenti;
	}
	
	@Override
	public void izvrsi() {
		System.out.print("Unesite ime studenta: ");
		String unesenoIme = Util.unesi();
		System.out.print("Unesite prezime studenta: ");
		String unesenoPrezime = Util.unesi();
		System.out.print("Unesite broj indeksa studenta: ");
		String uneseniIndeks = Util.unesi();
		
		noviStudent = new Student(unesenoIme, unesenoPrezime, uneseniIndeks);
		studenti.add(noviStudent);

	}

	@Override
	public void ponisti() {
		for (Student student : studenti) {
			if(student.getBrIndeksa().equals(noviStudent.getBrIndeksa())){
				studenti.remove(student);
				return;
			}
		}
	}

}
