package vp.generickeklase.ispiti;

import java.util.ArrayList;

public class Student {
	private String ime;
	private String prezime;
	private String brIndeksa;
	// private Predmet[] ispiti = new Predmet[100]; // najvise 100 ispita se
	// evidentira
	// umesto niza koristimo array listu
	private ArrayList<Predmet> ispiti = new ArrayList<Predmet>();
//	private int ukupnoIspita = 0;
	private boolean obrisan = false;

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

	// public Predmet[] getIspiti() {
	// return ispiti;
	// }
	//
	// public void setIspiti(Predmet[] ispiti) {
	// this.ispiti = ispiti;
	// }
	// umesto niza koristimo listu
	public ArrayList<Predmet> getIspiti() {
		return ispiti;
	}

	public void setIspiti(ArrayList<Predmet> ispiti) {
		this.ispiti = ispiti;
	}

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	public void dodajPolozeniIspit(Predmet predmet) {
		// ispiti[ukupnoIspita++] = predmet;
		// koristimo add metodu za dodavanje
		ispiti.add(predmet);
	}

	void obrisiPolozeniIspit(Predmet predmet) {
		// pronalazenje predmeta
		int pozicija;
		for (pozicija = 0; pozicija < ispiti.size(); pozicija++) {
			// if (ispiti[pozicija].getOznaka().equals(predmet.getOznaka())) {
			// break;
			// }
			//ukoliko je pronadjen element, brise se
			if (ispiti.get(pozicija).getOznaka().equals(predmet.getOznaka())) {
				ispiti.remove(pozicija);
				break;
			}

		}
		// pri birsanju u lisit automtski se azuridaju svi elementi
		// if (pozicija < ukupnoIspita) { // ako je pronasao predmet
		// for (int i = pozicija + 1; i < ukupnoIspita; i++) {
		// ispiti[i-1] = ispiti[i]; // pomeramo naredne ispite preko obrisanog
		// }
		// ukupnoIspita--; // sada je jedan ispit manje
		// }
	}

	void ispisiStudenta() {
		String zaIspis = brIndeksa + " " + ime + " " + prezime + ". Polozio: ";
		for (int i = 0; i < ispiti.size(); i++) {
//			zaIspis += ispiti[i].getNaziv() + " ";
			zaIspis += ispiti.get(i).getNaziv() + " ";
		}
		System.out.println(zaIspis);
	}
}
