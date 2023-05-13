package vp.ds.ispiti;

import java.util.ArrayList;
import java.util.Stack;

import vp.ds.ispiti.komande.DodajIspitStudenta;
import vp.ds.ispiti.komande.DodajPredmet;
import vp.ds.ispiti.komande.DodajStudenta;
import vp.ds.ispiti.komande.IzmeniPredmet;
import vp.ds.ispiti.komande.IzmeniStudenta;
import vp.ds.ispiti.komande.Komanda;
import vp.ds.ispiti.komande.ObrisiIspitStudenta;
import vp.ds.ispiti.komande.ObrisiPredmet;
import vp.ds.ispiti.komande.ObrisiStudenta;
import vp.ds.ispiti.komande.PrikaziPredmete;
import vp.ds.ispiti.komande.PrikaziStudente;
import vp.ds.ispiti.komande.PronadjiPredmet;
import vp.ds.ispiti.komande.PronadjiStudenta;
import vp.ds.ispiti.komande.PronadjiStudentePoProseku;
import vp.ds.ispiti.model.Predmet;
import vp.ds.ispiti.model.Student;

public class EvidencijaIspita {

	private static EvidencijaIspita instanca = new EvidencijaIspita();

	private ArrayList<Student> studenti;

	private ArrayList<Predmet> predmeti;

	private Stack<Komanda> komande;

	private EvidencijaIspita() {
		studenti = new ArrayList<>();
		predmeti = new ArrayList<>();
		komande = new Stack<Komanda>();
	}

	public static EvidencijaIspita getInstanca() {
		return instanca;
	}

	// undo nije podrzan
	public void prikaziStudente() {
		PrikaziStudente prikaziStudente = new PrikaziStudente(studenti);
		prikaziStudente.izvrsi();
	}

	// undo nije podrzan
	public void pronadjiStudenta() {
		PronadjiStudenta pronadjiStudenta = new PronadjiStudenta(studenti);
		pronadjiStudenta.izvrsi();
	}

	public void dodajStudenta() {
		DodajStudenta dodajStudenta = new DodajStudenta(studenti);
		komande.push(dodajStudenta);
		dodajStudenta.izvrsi();
	}

	public void ponisti() {
		if (komande.size() > 0) {
			Komanda komanda = komande.pop();
			komanda.ponisti();
		}
	}

	public void izmeniStudenta() {
		IzmeniStudenta izmeniStudent = new IzmeniStudenta(studenti);
		komande.push(izmeniStudent);
		izmeniStudent.izvrsi();
	}

	public void obrisiStudenta() {
		ObrisiStudenta obrisiStudenta = new ObrisiStudenta(studenti);
		komande.push(obrisiStudenta);
		obrisiStudenta.izvrsi();
	}

	public void prikaziPredmete() {
		PrikaziPredmete prikaziPredmete = new PrikaziPredmete(predmeti);
		prikaziPredmete.izvrsi();
	}

	public void pronadjiPredmet() {
		PronadjiPredmet pronadjiPredmet = new PronadjiPredmet(predmeti);
		pronadjiPredmet.izvrsi();
	}

	public void dodajPredmet() {
		DodajPredmet dodajPredmet = new DodajPredmet(predmeti);
		komande.push(dodajPredmet);
		dodajPredmet.izvrsi();
	}

	public void izmeniPredmet() {
		IzmeniPredmet izmeniPredmet = new IzmeniPredmet(predmeti);
		komande.push(izmeniPredmet);
		izmeniPredmet.izvrsi();
	}

	public void obrisiPredmet() {
		ObrisiPredmet obrisiPredmet = new ObrisiPredmet(predmeti);
		komande.push(obrisiPredmet);
		obrisiPredmet.izvrsi();
	}

	public void dodajIspitStudenta() {
		DodajIspitStudenta dodajIspitStudenta = new DodajIspitStudenta(
				studenti, predmeti);
		komande.push(dodajIspitStudenta);
		dodajIspitStudenta.izvrsi();
	}

	public void obrisiIspitStudenta() {
		ObrisiIspitStudenta obrisiIspitStudenta = new ObrisiIspitStudenta(
				studenti, predmeti);
		komande.push(obrisiIspitStudenta);
		obrisiIspitStudenta.izvrsi();
	}

	public void pronadjiStudentePoProseku() {
		PronadjiStudentePoProseku pronadjiStudentePoProseku = new PronadjiStudentePoProseku(
				studenti);
		pronadjiStudentePoProseku.izvrsi();
	}
}
