package vp.uml;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Student {
	private String ime;
	private String prezime;
	private String brIndeksa;
	private LocalDate datumRodjenja;
	private String gradRodjenja;
	private String drzavaRodjenja;
	
	private ArrayList<Ispit> ispiti = new ArrayList<>(); 
	
	public Student(String ime, String prezime, String brIndeksa,
			LocalDate datumRodjenja, String gradRodjenja, String drzavaRodjenja) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.brIndeksa = brIndeksa;
		this.datumRodjenja = datumRodjenja;
		this.gradRodjenja = gradRodjenja;
		this.drzavaRodjenja = drzavaRodjenja;
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
	
	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getGradRodjenja() {
		return gradRodjenja;
	}

	public void setGradRodjenja(String gradRodjenja) {
		this.gradRodjenja = gradRodjenja;
	}

	public String getDrzavaRodjenja() {
		return drzavaRodjenja;
	}

	public void setDrzavaRodjenja(String drzavaRodjenja) {
		this.drzavaRodjenja = drzavaRodjenja;
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
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");
		
		StringBuffer sb = new StringBuffer();		
		sb.append(brIndeksa).append(" ").append(ime).append(" ").append(prezime) 
				.append(" ").append(formatter.format(datumRodjenja)).append(" ")
				.append(gradRodjenja).append(" ").append(drzavaRodjenja).append(" ")
				.append(". Polozio: ");
		for (Ispit ispit: ispiti) {
			sb.append(ispit).append(" "); 
		}
		return sb.toString();
	}
}

