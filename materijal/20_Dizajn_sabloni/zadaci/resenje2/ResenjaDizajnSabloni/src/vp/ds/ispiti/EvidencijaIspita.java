package vp.ds.ispiti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import vp.ds.ispiti.model.Ispit;
import vp.ds.ispiti.model.Predmet;
import vp.ds.ispiti.model.Student;

/**
 * Ova klasa ima ulogu Receiver-a:
 * ona zapravo izvrsava svaku od akcija koje komande enkapsuliraju.
 */
public class EvidencijaIspita {

	private static EvidencijaIspita instanca = new EvidencijaIspita();

	private ArrayList<Student> studenti;
	private ArrayList<Predmet> predmeti;

	private EvidencijaIspita() {
		studenti = new ArrayList<>();
		predmeti = new ArrayList<>();
	}

	public static EvidencijaIspita getInstanca() {
		return instanca;
	}

	public void dodajStudenta(Student noviStudent) {
		studenti.add(noviStudent);
	}

	public void izmeniStudenta(String brojIndeksa, Student noviStudent) {
		Student stariStudent = preuzmiPoBrojuIndeksa(brojIndeksa);
		stariStudent.setIme(noviStudent.getIme());
		stariStudent.setPrezime(noviStudent.getPrezime());
	}
	
	// trajno brisanje
	public void obrisiStudenta(Student student) {
		studenti.remove(student);
	}

	// brisanje setovanjem atributa "obrisan"
	public void oznaciStudentaKaoObrisanog(Student student) {
		student.setObrisan(true);
	}
	
	public void oznaciStudentaKaoNeobrisanog(Student student) {
		student.setObrisan(false);
	}
	
	public Student preuzmiPoBrojuIndeksa(String brojIndeksa) {
		for (int i = 0; i < studenti.size(); i++) {
			if (studenti.get(i).getBrIndeksa().equals(brojIndeksa) &&
					!studenti.get(i).isObrisan()) {
				return studenti.get(i);
			}
		}
		return null;
	}
	
	public int getBrojPredmeta() {
		return predmeti.size();
	}

	public void dodajPredmet(Predmet predmet) {
		predmeti.add(predmet);
	}

	public void izmeniPredmet(String staraOznakaPredmeta, Predmet noviPredmet) {
		Predmet stariPredmet = preuzmiPredmetPoOznaci(staraOznakaPredmeta);
		stariPredmet.setNaziv(noviPredmet.getNaziv());
		stariPredmet.setEspb(noviPredmet.getEspb());
	}

	public void obrisiPredmet(Predmet predmet) {
		predmeti.remove(predmet);
	}
	
	public void oznaciPredmetKaoObrisan(Predmet predmet) {
		predmet.setObrisan(true);
	}
	
	public void oznaciPredmetKaoNeobrisan(Predmet predmet) {
		predmet.setObrisan(false);
	}
	
	public Predmet preuzmiPredmetPoOznaci(String trazenaOznaka) {
		for (Predmet p : predmeti) {
			if (p.getOznaka().equals(trazenaOznaka) && !p.isObrisan()) {
				return p;
			}
		}
		return null;
	}

	public void dodajIspitStudenta(Student student, Ispit ispit) {
		student.dodajPolozeniIspit(ispit);
	}

	public void obrisiIspitStudenta(Student student, Ispit ispit) {
		student.getIspiti().remove(ispit);
	}

	public List<Student> preuzmiStudente() {
		return Collections.unmodifiableList(studenti);
	}
	
	public List<Predmet> preuzmiPredmete() {
		return Collections.unmodifiableList(predmeti);
	}
	
	public void inicijalizujPodatke() {
		Student s = new Student("Petar", "Petrovic", "3453");

		Predmet p = new Predmet("1", "Matematika", 6);
		predmeti.add(p);
		Ispit ispit = new Ispit();
		ispit.setPredmet(p);
		ispit.setOcena(7);
		s.dodajPolozeniIspit(ispit);

		p = new Predmet("2", "Fizika", 4);
		predmeti.add(p);
		ispit = new Ispit();
		ispit.setPredmet(p);
		ispit.setOcena(8);
		s.dodajPolozeniIspit(ispit);

		p = new Predmet("3", "Informatika", 8);
		predmeti.add(p);
		ispit = new Ispit();
		ispit.setPredmet(p);
		ispit.setOcena(10);
		s.dodajPolozeniIspit(ispit);

		p = new Predmet("4", "Sociologija", 2);
		predmeti.add(p);
		ispit = new Ispit();
		ispit.setPredmet(p);
		ispit.setOcena(9);
		s.dodajPolozeniIspit(ispit);

		p = new Predmet("5", "Statistika", 6);
		predmeti.add(p);
		ispit = new Ispit();
		ispit.setPredmet(p);
		ispit.setOcena(9);
		s.dodajPolozeniIspit(ispit);

		p = new Predmet("6", "Osnove racunara", 7);
		predmeti.add(p);
		ispit = new Ispit();
		ispit.setPredmet(p);
		ispit.setOcena(8);
		s.dodajPolozeniIspit(ispit);

		p = new Predmet("7", "Osnove elektrotehnike", 6);
		predmeti.add(p);
		ispit = new Ispit();
		ispit.setPredmet(p);
		ispit.setOcena(6);
		s.dodajPolozeniIspit(ispit);

		p = new Predmet("8", "Objektno programiranje", 8);
		predmeti.add(p);
		ispit = new Ispit();
		ispit.setPredmet(p);
		ispit.setOcena(7);
		s.dodajPolozeniIspit(ispit);

		p = new Predmet("9", "Veb programiranje", 6);
		predmeti.add(p);
		ispit = new Ispit();
		ispit.setPredmet(p);
		ispit.setOcena(7);
		s.dodajPolozeniIspit(ispit);

		p = new Predmet("10", "Racunarska inteligencija", 5);
		predmeti.add(p);
		ispit = new Ispit();
		ispit.setPredmet(p);
		ispit.setOcena(9);
		s.dodajPolozeniIspit(ispit);

		studenti.add(s);

		s = new Student("Marko", "Markovic", "2366");
		ispit = new Ispit();
		ispit.setPredmet(p);
		ispit.setOcena(8);
		s.dodajPolozeniIspit(ispit);
		studenti.add(s);
	}
}
