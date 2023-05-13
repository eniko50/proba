package vp.ds.ispiti.komande;

import vp.ds.ispiti.EvidencijaIspita;
import vp.ds.ispiti.model.Ispit;
import vp.ds.ispiti.model.Student;

public class DodajIspitStudenta implements Komanda {

	private EvidencijaIspita evidencija;
	private Ispit ispit;
	private Student student;

	public DodajIspitStudenta(EvidencijaIspita evidencija, Ispit ispit, Student student) {
		this.evidencija = evidencija;
		this.ispit = ispit;
		this.student = student;
	}

	@Override
	public void izvrsi() {
		evidencija.dodajIspitStudenta(student, ispit);
	}

	@Override
	public void ponisti() {
		evidencija.obrisiIspitStudenta(student, ispit);
	}

}
