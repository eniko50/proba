package vp.nezavisnebiblioteke.komande;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import vp.nezavisnebiblioteke.studenti.Student;
import vp.nezavisnebiblioteke.studenti.Util;

public class DodajStudenta implements Komanda {
	
	private List<Student> studenti;
	private Student noviStudent;
	
	public DodajStudenta(List<Student> studenti) {
		this.studenti = studenti;
	}

	@Override
	public void izvrsi() {
		System.out.print("Unesite ime studenta: ");
		String unesenoIme = Util.unesi();
		System.out.print("Unesite prezime studenta: ");
		String unesenoPrezime = Util.unesi();
		System.out.print("Unesite broj indeksa studenta: ");
		String uneseniIndeks = Util.unesi();

		System.out
				.print("Unesite datum rodjenja studenta (primer 03.09.1998.): ");
		String uneseniDatum = Util.unesi();
		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("dd.MM.yyyy.");
		LocalDate datum = LocalDate.parse(uneseniDatum, formatter);

		System.out.print("Unesite grad rodjenja: ");
		String uneseniGrad = Util.unesi();
		System.out.print("Unesite drzavu rodjenja: ");
		String unesenaDrzava = Util.unesi();

		noviStudent = new Student(unesenoIme, unesenoPrezime,
				uneseniIndeks, datum, uneseniGrad, unesenaDrzava);
		studenti.add(noviStudent);
	}

	@Override
	public void ponisti() {
		studenti.remove(noviStudent);
	}

}
