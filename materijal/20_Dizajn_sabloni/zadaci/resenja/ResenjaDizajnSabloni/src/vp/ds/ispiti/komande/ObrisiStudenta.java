package vp.ds.ispiti.komande;

import java.util.List;

import vp.ds.ispiti.Util;
import vp.ds.ispiti.model.Student;


public class ObrisiStudenta implements Komanda{

	private List<Student> studenti;
	
	private Student student;
	
	public ObrisiStudenta(List<Student> studenti) {
		this.studenti = studenti;
	}
	
	@Override
	public void izvrsi() {
		student = preuzmiPoBrojuIndeksa();
		if (student != null) {
			student.setObrisan(true);
		}
		
	}

	@Override
	public void ponisti() {
		student.setObrisan(false);
	}
	
	private Student preuzmiPoBrojuIndeksa() {
		System.out.println("Unesite broj studenta za brisanje: ");
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
