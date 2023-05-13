package vp.ds.ispiti.komande;

import vp.ds.ispiti.EvidencijaIspita;
import vp.ds.ispiti.model.Student;

public class DodajStudenta implements Komanda {

	private EvidencijaIspita evidencija;
	private Student noviStudent;
	
	public DodajStudenta(EvidencijaIspita evidencija, Student noviStudent) {
		this.evidencija = evidencija;
		this.noviStudent = noviStudent;
	}
	
	@Override
	public void izvrsi() {
		// svaka komanda u svojoj metodi "izvrsi" samo poziva odgovarajucu metodu Receiver-a,
		evidencija.dodajStudenta(noviStudent);
	}

	@Override
	public void ponisti() {
		evidencija.obrisiStudenta(noviStudent);
	}

}
