package vp.ds.ispiti.komande;

import java.util.List;

import vp.ds.ispiti.model.Student;

public class PrikaziStudente implements Komanda {

	private List<Student> studenti;

	public PrikaziStudente(List<Student> studenti) {
		this.studenti = studenti;
	}

	@Override
	public void izvrsi() {
		System.out.println("Studenti u evidenciji: ");
		for (int i = 0; i < studenti.size(); i++) {
			if (!studenti.get(i).isObrisan()) {
				studenti.get(i).ispisiStudenta();
			}
		}
	}

	@Override
	public void ponisti() {
		// TODO Auto-generated method stub

	}

}
