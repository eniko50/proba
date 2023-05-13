package vp.ds.ispiti.komande;

import java.util.List;

import vp.ds.ispiti.Util;
import vp.ds.ispiti.model.Student;

public class PronadjiStudenta implements Komanda {

	private List<Student> studenti;
	
	public PronadjiStudenta(List<Student> studenti) {
		this.studenti = studenti;
	}
	
	@Override
	public void izvrsi() {
		Student trazeniStudent = preuzmiPoBrojuIndeksa();
		if (trazeniStudent != null) {
			System.out.print("Podaci trazenog studenta: ");
			trazeniStudent.ispisiStudenta();
		} else {
			System.out.println("Trazeni student ne postoji");
		}

	}

	@Override
	public void ponisti() {
		
	}

	private Student preuzmiPoBrojuIndeksa() {
		System.out.print("Unesite broj indeksa: ");
		String brojIndeksa = Util.unesi();
		for (int i = 0; i < studenti.size(); i++) {
			if (studenti.get(i).getBrIndeksa().equals(brojIndeksa) &&
					!studenti.get(i).isObrisan()) {
				return studenti.get(i);
			}
		}
		return null;
	}

}
