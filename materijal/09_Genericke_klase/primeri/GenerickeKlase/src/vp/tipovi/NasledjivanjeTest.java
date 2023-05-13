package vp.tipovi;

public class NasledjivanjeTest {

	public static void main(String[] args) {
		Student s = new Student();
		s.ime = "Pera";
		s.prezime = "Peric";
		s.brojIndeksa = "E10750";
		System.out.println(s.predstaviSe());
		System.out.println(s.prikaziPodatke());
	}
}
