package vp04.termin8.studenti;

public class Student {
	private String brIndeksa;
	private String ime;
	private String prezime;
	
	public Student() {
	}
	
	public Student(String brIndeksa, String ime, String prezime) {
		super();
		this.brIndeksa = brIndeksa;
		this.ime = ime;
		this.prezime = prezime;
	}
	
	public String getBrIndeksa() {
		return brIndeksa;
	}
	public void setBrIndeksa(String brIndeksa) {
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
	
	
}
