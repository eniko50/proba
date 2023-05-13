package vp.polimorfizam.ispiti.evidencija;

import java.util.ArrayList;

public class Student {
	private String ime;
	private String prezime;
	private String brIndeksa;
	private ArrayList<Ispit> ispiti = new ArrayList<>(); 
	
	public Student(String ime, String prezime, String brIndeksa) {
		this.ime = ime;
		this.prezime = prezime;
		this.brIndeksa = brIndeksa;
	}

	public String getIme() {
		return ime;
	}	

	public void setIme(String ime) {
		this.ime = ime;
	} 

	public String getPrezime() {
		return prezime;
	}	

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	} 

	public String getBrIndeksa() {
		return brIndeksa;
	}

	public void setBrIndeksa(String brIndeksa) {
		this.brIndeksa = brIndeksa;
	}
	
	public void dodajPolozeniIspit(Ispit ispit) {
		ispiti.add(ispit);
	}
	
	public void obrisiPolozeniIspit(Predmet p) {
		for (int i = 0; i < ispiti.size(); i++) {
			Ispit ispit = ispiti.get(i);
			if (ispit.getPredmet().getOznaka().equals(p.getOznaka())) {
				ispiti.remove(ispit);
				return;
			}
		}
	}

	@Override
	public String toString() {
		String zaIspis = brIndeksa + " " + ime + " " + prezime + 
				". Polozio: ";
		for (Ispit ispit: ispiti) {
			zaIspis += ispit + " "; // poziva se toString objekta ispit
		}
		return zaIspis;
	}
}

