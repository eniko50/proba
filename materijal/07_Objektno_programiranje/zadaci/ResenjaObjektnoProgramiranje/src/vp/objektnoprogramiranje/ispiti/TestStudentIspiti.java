package vp.objektnoprogramiranje.ispiti;

public class TestStudentIspiti {
	public static void main(String[] args) {
		Student s1 = new Student();
		s1.brojIndeksa = "1783";
		s1.ime = "Marko";
		s1.prezime = "Markovic";
		s1.ispiti = new String[2];
		s1.ispiti[0] = "Matematika";
		s1.ispiti[1] = "Fizika";
		s1.espbBodovi = new int[2];
		s1.espbBodovi[0] = 6;
		s1.espbBodovi[1] = 4;
		s1.ocene = new int[2];
		s1.ocene[0] = 9;
		s1.ocene[1] = 7;
				
		Student s2 = new Student();
		s2.brojIndeksa = "3345";
		s2.ime = "Ivan";
		s2.prezime = "Ivanovic";
		s2.ispiti = new String[1];
		s2.ispiti[0] = "Matematika";
		s2.espbBodovi = new int[1];
		s2.espbBodovi[0] = 6;
		s2.ocene = new int[1];
		s2.ocene[0] = 8;
				
		Student s3 = new Student();
		s3.brojIndeksa = "3474";
		s3.ime = "Tamara";
		s3.prezime = "Popovic";
		s3.ispiti = new String[2];
		s3.ispiti[0] = "Osnove programiranja";
		s3.ispiti[1] = "Matematika";
		s3.espbBodovi = new int[2];
		s3.espbBodovi[0] = 8;
		s3.espbBodovi[1] = 6;
		s3.ocene = new int[2];
		s3.ocene[0] = 7;
		s3.ocene[1] = 8;
		
		Student s4 = new Student();
		s4.brojIndeksa = "4646";
		s4.ime = "Nikola";
		s4.prezime = "Nikolic";
		s4.ispiti = new String[1];
		s4.ispiti[0] = "Fizika";
		s4.espbBodovi = new int[1];
		s4.espbBodovi[0] = 4;
		s4.ocene = new int[1];
		s4.ocene[0] = 6;
		
		// smestanje studenata u niz zbog lakse manipulacije
		Student[] studenti = {s1, s2, s3, s4};
		
		//meni
		System.out.println("Meni");
		System.out.println("1 - Ispis studenta");
		System.out.println("2 - Ispiti sa ocenom vecom od 8");
		System.out.println("3 - Ispiti sa ocenom vecom od 6 koji nose vise od 5 ESPB");
		System.out.println("4 - Prosecna ocena studenta");
		System.out.println("5 - Ispit na kojem je student dobio najvisu ocenu");
		System.out.println("6 - Ispit na kojem je student dobio najnizu ocenu");
		System.out.println("=========================");
		
		String izabranaOpcija = "1"; // menjati za testiranje svih opcija
		System.out.println("Izabrana je opcija: " + izabranaOpcija);
		String trazeniIndeks = "1783";
		
		//pronalazenje studenta na osnovu broja indeksa
		Student student = null;
		for (int i = 0; i < studenti.length; i++) {
			if (studenti[i].brojIndeksa.equals(trazeniIndeks)) {
				student = studenti[i];
				break;
			}
		}
		
		switch (izabranaOpcija) {
			case "1": 
				student.ispisiStudenta();
				break;
			case "2":
				student.oceneIznad(8);
				break;
			case "3":
				student.oceneIznad(6, 5);
				break;
			case "4":
				double prosek = student.prosecnaOcena();
				System.out.println("Prosecna ocena: " + prosek);
				break;
			case "5":
				String najbolji = student.najboljiIspit();
				System.out.println("Ispit sa najvisom ocenom: " + najbolji);
				break;
			case "6":
				String najlosiji = student.najlosijiIspit();
				System.out.println("Ispit sa najnizom ocenom: " + najlosiji);
				break;
		}
		
	}
}
