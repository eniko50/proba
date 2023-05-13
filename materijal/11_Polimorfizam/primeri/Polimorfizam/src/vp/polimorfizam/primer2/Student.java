package vp.polimorfizam.primer2;

public class Student extends Osoba{
	protected String brojIndeksa;

	public Student(String ime, String prezime, String brojIndeksa){
		super(ime, prezime);
		this.brojIndeksa = brojIndeksa;
	}
	
	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	@Override
	public void predstaviSe(){
		super.predstaviSe();
		System.out.println("Moj broj indeksa je: "+brojIndeksa);
	}
	
	@Override
	public boolean equals(Object arg0) {
		return this.brojIndeksa.equals( ((Student)arg0).brojIndeksa );
	}
	
	@Override
	public String toString() {
		return "Moj broj indeksa je: "+this.brojIndeksa;
	}
}
