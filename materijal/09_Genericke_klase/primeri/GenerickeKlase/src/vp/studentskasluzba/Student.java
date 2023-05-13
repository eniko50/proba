package vp.studentskasluzba;

public class Student {

	public Student(String brojIndeksa, String ime, String prezime,
			int godinaStudija) {
		this.brojIndeksa = brojIndeksa;
		this.ime = ime;
		this.prezime = prezime;
		this.godinaStudija = godinaStudija;
	}
	
	private String brojIndeksa;	
	private String ime;
	private String prezime;
	private int godinaStudija;
	@Override
	public String toString() {
		return "Student [brojIndeksa=" + brojIndeksa + ", ime=" + ime
				+ ", prezime=" + prezime + ", godinaStudija=" + godinaStudija
				+ "]";
	}
	public String getBrojIndeksa() {
		return brojIndeksa;
	}
	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
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
	public int getGodinaStudija() {
		return godinaStudija;
	}
	public void setGodinaStudija(int godinaStudija) {
		this.godinaStudija = godinaStudija;
	}	
	
	
}
