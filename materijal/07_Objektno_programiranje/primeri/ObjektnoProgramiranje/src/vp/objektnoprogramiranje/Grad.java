package vp.objektnoprogramiranje;

public class Grad {
	int ptt;
	String naziv;
	Drzava drzava;
	
	void ispisiGrad() {
		System.out.println(ptt + " " + naziv + " " + drzava.naziv);
	}
}
