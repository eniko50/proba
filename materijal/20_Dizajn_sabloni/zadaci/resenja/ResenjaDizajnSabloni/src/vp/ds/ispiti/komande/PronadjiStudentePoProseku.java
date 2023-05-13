package vp.ds.ispiti.komande;

import java.util.List;

import vp.ds.ispiti.Util;
import vp.ds.ispiti.model.Student;

public class PronadjiStudentePoProseku implements Komanda {

	private List<Student> studenti;
	
	public PronadjiStudentePoProseku(List<Student> studenti) {
		this.studenti = studenti;
	}
	
	@Override
	public void izvrsi() {
		System.out.println("Unesite prosek studenata: ");
		double prosek = Double.parseDouble(Util.unesi()); 
		for (int i = 0; i < studenti.size(); i++) {
			if (studenti.get(i).getProsek() >= prosek) {
				if (!studenti.get(i).isObrisan()) {
					studenti.get(i).ispisiStudenta();
				}
			}
		}
	}

	@Override
	public void ponisti() {
	}

}
