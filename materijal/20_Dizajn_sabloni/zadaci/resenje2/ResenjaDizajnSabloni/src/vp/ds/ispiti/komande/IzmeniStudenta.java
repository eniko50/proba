package vp.ds.ispiti.komande;

import vp.ds.ispiti.EvidencijaIspita;
import vp.ds.ispiti.model.Student;

public class IzmeniStudenta implements Komanda {

	private EvidencijaIspita evidencija;
	private Student noviStudent;
	private String staroIme;
	private String staroPrezime;
	private String brojIndeksa;
	
	public IzmeniStudenta(EvidencijaIspita evidencija, Student stariStudent, Student noviStudent) {
		this.evidencija = evidencija;
		this.noviStudent = noviStudent;
		this.brojIndeksa = stariStudent.getBrIndeksa();
		this.staroIme = stariStudent.getIme();
		this.staroPrezime = stariStudent.getPrezime();
	}
	
	@Override
	public void izvrsi() {
		evidencija.izmeniStudenta(brojIndeksa, noviStudent);
	}

	@Override
	public void ponisti() {
		Student stariStudent = new Student(staroIme, staroPrezime, brojIndeksa);
		evidencija.izmeniStudenta(brojIndeksa, stariStudent);
	}

}
