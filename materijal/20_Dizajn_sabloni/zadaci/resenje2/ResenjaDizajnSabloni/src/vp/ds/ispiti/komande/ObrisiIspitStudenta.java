package vp.ds.ispiti.komande;

import vp.ds.ispiti.EvidencijaIspita;
import vp.ds.ispiti.model.Ispit;
import vp.ds.ispiti.model.Student;

public class ObrisiIspitStudenta implements Komanda {

	private EvidencijaIspita evidencija;
	private Ispit ispit;
	private Student student;
	
	public ObrisiIspitStudenta(EvidencijaIspita evidencija, Ispit ispit, Student student) {
		this.evidencija = evidencija;
		this.ispit = ispit;
		this.student = student;
	}
		
	@Override
	public void izvrsi() {
		evidencija.obrisiIspitStudenta(student, ispit);
	}

	@Override
	public void ponisti() {
		evidencija.dodajIspitStudenta(student, ispit);
	}

}
