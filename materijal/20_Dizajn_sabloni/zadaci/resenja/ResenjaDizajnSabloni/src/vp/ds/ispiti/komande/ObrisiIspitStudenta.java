package vp.ds.ispiti.komande;

import java.util.List;

import vp.ds.ispiti.Util;
import vp.ds.ispiti.model.Ispit;
import vp.ds.ispiti.model.Predmet;
import vp.ds.ispiti.model.Student;

public class ObrisiIspitStudenta implements Komanda {

	private List<Student> studenti;
	
	private List<Predmet> predmeti;
	
	public ObrisiIspitStudenta(List<Student> studenti, List<Predmet> predmeti) {
		this.studenti = studenti;
		this.predmeti = predmeti;
	}
	
	private Ispit ispit;
	
	private Student student;
	
	@Override
	public void izvrsi() {
		student = preuzmiPoBrojuIndeksa();
		Predmet predmet = preuzmiPredmetPoOznaci();
		if (student != null && predmet != null) {
			ispit = student.getPolozeniIspit(predmet);
			student.obrisiPolozeniIspit(predmet);
		} else {
			System.out.println("Nepostojeci student ili predmet");
		}
		
	}

	@Override
	public void ponisti() {
		student.dodajPolozeniIspit(ispit);
	}

	
	private Predmet preuzmiPredmetPoOznaci() {
		System.out.print("Unesite oznaku predmeta: ");
		String trazenaOznaka = Util.unesi(); 
		
		for (int i = 0; i < predmeti.size(); i++) {
			if (predmeti.get(i).getOznaka().equals(trazenaOznaka) &&
					!predmeti.get(i).isObrisan()) {
				return predmeti.get(i);
			}
		}
		return null;
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
