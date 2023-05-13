package vp.ds.ispiti.komande;

import vp.ds.ispiti.EvidencijaIspita;
import vp.ds.ispiti.model.Student;


public class ObrisiStudenta implements Komanda {

	private EvidencijaIspita evidencija;
	private Student obrisaniStudent;
	
	public ObrisiStudenta(EvidencijaIspita evidencija, Student noviStudent) {
		this.evidencija = evidencija;
		this.obrisaniStudent = noviStudent;
	}
	
	@Override
	public void izvrsi() {
		evidencija.oznaciStudentaKaoObrisanog(obrisaniStudent);
	}

	@Override
	public void ponisti() {
		evidencija.oznaciStudentaKaoNeobrisanog(obrisaniStudent);
	}

}
