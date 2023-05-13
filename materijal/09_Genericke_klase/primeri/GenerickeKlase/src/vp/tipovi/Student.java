package vp.tipovi;

public class Student extends Osoba{
	String brojIndeksa;
	public String prikaziPodatke(){
		return "ime: "+ime+"; prezime: "+prezime+"; broj indeksa: "+brojIndeksa;
	}
}
