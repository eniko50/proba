package vp.ds.ispiti.model;

import java.util.ArrayList;

public class Student {
	private String ime;
	private String prezime;
	private String brIndeksa;
//	private Predmet[] ispiti = new Predmet[100]; // najvise 100 ispita se evidentira
	private ArrayList<Ispit> ispiti = new ArrayList<>();
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
	
	public void dodajPolozeniIspit(Ispit ispit) {
		for (int i = 0; i < ispiti.size(); i++) {
			if (ispiti.get(i).getPredmet().getOznaka().equals(ispit.getPredmet().getOznaka())) {
				System.out.println("Student je vec polozio taj predmet");
				return;
			}
		}
		ispiti.add(ispit);
	}

	public void dodajPolozeniIspit(Predmet predmet, int ocena) {
		for (int i = 0; i < ispiti.size(); i++) {
			if (ispiti.get(i).getPredmet().getOznaka().equals(predmet.getOznaka())) {
				System.out.println("Student je vec polozio taj predmet");
				return;
			}
		}
		Ispit ispit = new Ispit(predmet, ocena);
		ispiti.add(ispit);
	}

	public double getProsek(){
		double sum = 0;
		for (int i = 0; i < ispiti.size(); i++) {
			sum += ispiti.get(i).getOcena();
		}
		return sum/ispiti.size();
	}
	
	public void obrisiPolozeniIspit(Predmet predmet) {
		//pronalazenje predmeta
		int pozicija; 
		for (pozicija = 0; pozicija < ispiti.size(); pozicija++) {
			if (ispiti.get(pozicija).getPredmet().getOznaka().equals(predmet.getOznaka())) {
				break;
			}
		}
		if (pozicija < ispiti.size()) { // ako je pronasao predmet
			ispiti.remove(pozicija);
		}		
	}

	public Ispit getPolozeniIspit(Predmet predmet) {
		for (Ispit ispit : ispiti) {
			if(ispit.getPredmet().getOznaka().equals(predmet.getOznaka())){
				return ispit;
			}
		}
		return null;
	}

	
	public void ispisiStudenta() {
		String zaIspis = brIndeksa + " " + ime + " " + prezime + 
				" prosek: " + getProsek() + ". Polozio: ";
		for (int i = 0; i < ispiti.size(); i++) {
			zaIspis += " "+ispiti.get(i).getPredmet().getNaziv() + ":" + ispiti.get(i).getOcena();
		}
		System.out.println(zaIspis);
	}	
}

