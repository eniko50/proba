package vp.ds.ispiti.komande;

import java.util.List;

import vp.ds.ispiti.Util;
import vp.ds.ispiti.model.Student;

public class IzmeniStudenta implements Komanda {

	private List<Student> studenti;
	
	private Student student;
	
	private String brojIndeksa;
	
	private String staroIme;
	
	private String staroPrezime;
	
	private String stariBrojIndeksa;
	
	public IzmeniStudenta(List<Student> studenti) {
		this.studenti = studenti;
	}
	
	@Override
	public void izvrsi() {
		System.out.print("Unesite broj indeksa studenta za izmenu: ");		
		brojIndeksa = Util.unesi();
		student = preuzmiPoBrojuIndeksa();
		if (student != null) {
			staroIme = student.getIme();
			staroPrezime = student.getPrezime();
			stariBrojIndeksa = student.getBrIndeksa();
			System.out.print("Unesite izmenjeno ime studenta: ");
			String unesenoIme = Util.unesi();
			System.out.print("Unesite izmenjeno prezime studenta: ");
			String unesenoPrezime = Util.unesi();
			System.out.print("Unesite izmenjeni broj indeksa studenta: ");
			String uneseniIndeks = Util.unesi();
			
			student.setIme(unesenoIme);
			student.setPrezime(unesenoPrezime);
			student.setBrIndeksa(uneseniIndeks);			
		} else {
			System.out.println("Trazeni student ne postoji.");
		}
	}

	@Override
	public void ponisti() {
		student = preuzmiPoBrojuIndeksa();
		if (student != null) {
			student.setIme(staroIme);
			student.setPrezime(staroPrezime);
			student.setBrIndeksa(stariBrojIndeksa);
		} else {
			System.out.println("Trazeni student ne postoji.");
		}

	}

	private Student preuzmiPoBrojuIndeksa() {
		for (int i = 0; i < studenti.size(); i++) {
			if (studenti.get(i).getBrIndeksa().equals(brojIndeksa) &&
					!studenti.get(i).isObrisan()) {
				return studenti.get(i);
			}
		}
		return null;
	}

}
