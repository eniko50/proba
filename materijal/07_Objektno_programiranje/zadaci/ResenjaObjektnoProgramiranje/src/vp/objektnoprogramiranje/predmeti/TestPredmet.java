package vp.objektnoprogramiranje.predmeti;

public class TestPredmet {

	public static void main(String[] args) {
		Predmet p1 = new Predmet();
		p1.oznaka = "1";
		p1.naziv = "Matematika";
		p1.espb = 6;
		
		Predmet p2 = new Predmet();
		p2.oznaka = "2";
		p2.naziv = "Fizika";
		p2.espb = 4;
		
		Predmet p3 = new Predmet();
		p3.oznaka = "3";
		p3.naziv = "Osnove programiranja";
		p3.espb = 8;
		
		Predmet p4 = new Predmet();
		p4.oznaka = "4";
		p4.naziv = "Engleski jezik";
		p4.espb = 2;
		
		Predmet[] predmeti = {p1, p2, p3, p4};
		
		for (int i = 0; i < predmeti.length; i++) {
			Predmet p = predmeti[i];
			System.out.println(p.oznaka + " " + p.naziv + " " + p.espb + " ESPB");
		}
		

	}

}
