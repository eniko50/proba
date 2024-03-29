package vp.xml;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String id;
	private String ime;
	private String prezime;
	private String brIndeksa;
	private ArrayList<Ispit> ispiti = new ArrayList<Ispit>();
	private boolean obrisan = false;

	public Student() {
		
	}
	
	public Student(String ime, String prezime, String brIndeksa) {
		this.ime = ime;
		this.prezime = prezime;
		this.brIndeksa = brIndeksa;
	}

	public Student(String brIndeksa, String ime, String prezime, boolean obrisan) {
		this.ime = ime;
		this.prezime = prezime;
		this.brIndeksa = brIndeksa;
		this.obrisan = obrisan;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public ArrayList<Ispit> getIspiti() {
		return ispiti;
	}

	public void setIspiti(ArrayList<Ispit> ispiti) {
		this.ispiti = ispiti;
	}

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	public Ispit pronadjiIspitPoPredmetu(Predmet predmet){
		for (int i = 0; i < ispiti.size(); i++) {
			if(ispiti.get(i).getPredmet().getOznaka().equals(predmet.getOznaka())){
				return ispiti.get(i);
			}
		}
		return null;
	}
	
	public void dodajPolozeniIspit(Ispit ispit) {
		//ako student nije polozio taj predmet, dodaje se ispit
		if (ispit.getPredmet() != null && pronadjiIspitPoPredmetu(ispit.getPredmet()) !=null) {
			//ako je vec polozio, ispisuje se greska
			System.out.println("Student je vec polozio taj predmet");
			return;
		}
		
		ispiti.add(ispit);
	}
	
	void obrisiPolozeniIspit(Predmet predmet) {
		// pronalazenje predmeta
		int pozicija;
		for (pozicija = 0; pozicija < ispiti.size(); pozicija++) {
			if (ispiti.get(pozicija).getPredmet().getOznaka().equals(predmet.getOznaka())) {
				ispiti.remove(pozicija);
				break;
			}

		}
	}

	public double getProsek(){
		double retVal = 0;
		for (int i = 0; i < ispiti.size(); i++) {
			retVal += ispiti.get(i).getOcena();
		}
		return retVal / ispiti.size();
	}

	
	void ispisiStudenta() {
		String zaIspis = brIndeksa + " " + ime + " " + prezime + " prosek: " + getProsek() + ". Polozio: ";
		for (int i = 0; i < ispiti.size(); i++) {
			zaIspis += ispiti.get(i).getPredmet().getNaziv() + " " + ispiti.get(i).getOcena() + " ";
		}
		System.out.println(zaIspis);
	}
}
