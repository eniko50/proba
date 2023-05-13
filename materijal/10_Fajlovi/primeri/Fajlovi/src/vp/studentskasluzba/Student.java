package vp.studentskasluzba;

public class Student {

	public Student(String brojIndeksa, String ime, String prezime,
			int godinaStudija) {
		this.brojIndeksa = brojIndeksa;
		this.ime = ime;
		this.prezime = prezime;
		this.godinaStudija = godinaStudija;
	}
	
	String brojIndeksa;	
	String ime;
	String prezime;
	int godinaStudija;
	@Override
	public String toString() {
		return "Student [brojIndeksa=" + brojIndeksa + ", ime=" + ime
				+ ", prezime=" + prezime + ", godinaStudija=" + godinaStudija
				+ "]";
	}	
	
	
}
