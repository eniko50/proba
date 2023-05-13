package vp.standardniulazizlaz.predmeti;

public class Student {
	private String ime;
	private String prezime;
	private String brIndeksa;
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

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	void ispisiStudenta() {
		System.out.println(brIndeksa + " " + ime + " " + prezime);
	}
}

