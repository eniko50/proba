package vp.objektnoprogramiranje.student;

public class Student {
	String ime;
	String prezime;
	String brojIndeksa;
	
	String tekstZaIspis() {
		return brojIndeksa + " " + ime + " " + prezime;
	}
	
	void ispisi() {
		System.out.println(brojIndeksa + " " + ime + " " + prezime);
	}
	
	void ispisiDrugaVarijanta() {
		System.out.println(tekstZaIspis());
	}
}
