package vp.internet.mrezno.studenti;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	ArrayList<Student> studenti = new ArrayList<Student>();
	
	private Server() {
		inicijalizujStudente();
	}
	
	private void inicijalizujStudente() {
		studenti.add(new Student("1783", "Marko", "Markovic"));
		studenti.add(new Student("3345", "Ivan", "Ivanovic"));
		studenti.add(new Student("3474", "Tamara", "Popovic"));
	}
	
	private void pokreni() {
		ServerSocket ss;
		try {
			ss = new ServerSocket(9100);
			System.out.println("Server pokrenut.");
			while (true) {
				System.out.println("Ocekuje povezivanje ...");

				Socket sock = ss.accept();
				
				System.out.println("Primljena veza ...");
					
				BufferedReader in = new BufferedReader(new InputStreamReader(
						sock.getInputStream()));
				
				PrintWriter out = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(sock.getOutputStream())), true);
				
				String zahtev = in.readLine();
				// opcija je prva rec u zahtevu
				String opcija = zahtev.split(" ")[0];
				
				switch (opcija) {
					case "list":
						posaljiSpisakStudenata(out);
						break;
					case "find":
						// ako je opcija find, druga rec je broj indeksa studenta koji se trazi
						posaljiPodatkeOStudentu(out, zahtev.split(" ")[1]);
						break;
					case "add":
						// u zahtevu su razmakom razdvojeni podaci o studentu
						String[] podaci = zahtev.split(" ");
						dodajStudenta(out, podaci[1], podaci[2], podaci[3]);
						break;
					case "modify":
						// u zahtevu su razmakom razdvojeni podaci o studentu
						podaci = zahtev.split(" ");
						izmeniStudenta(out, podaci[1], podaci[2], podaci[3]);
						break;
					case "delete":
						// druga rec zahteva je broj indeksa studenta kojeg brisemo
						obrisiStudenta(out, zahtev.split(" ")[1]);
						break;
				}
				System.out.println("Vracen odgovor");
				in.close();
				out.close();
				sock.close();
			}	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void posaljiSpisakStudenata(PrintWriter out) { // stream u koji treba da upise odgovor
		StringBuilder odgovor = new StringBuilder();
		for (Student s: studenti) {
			odgovor.append(s.toString()).append(";"); // delimiter je ;
		}
		out.println(odgovor);
	}
	
	private void posaljiPodatkeOStudentu(PrintWriter out, String brIndeksa) { 
		// pronalazenje studenta
		String odgovor = "not_found"; // ovaj odgovor ce biti samo ako se ne pronadje student
		for (Student s: studenti) {
			if (s.getBrIndeksa().equals(brIndeksa)) {
				odgovor = s.toString();
				break;
			}
		}
		out.println(odgovor);		
	}
	
	private void dodajStudenta(PrintWriter out, String brIndeksa, String ime, String prezime) { 
		Student student = new Student(brIndeksa, ime, prezime);
		studenti.add(student);
		out.println("ok");
	}
	
	private void izmeniStudenta(PrintWriter out, String brIndeksa, String ime, String prezime) { 
		String odgovor = "not_found";
		// pronalazenje studenta
		for (Student s: studenti) {
			if (s.getBrIndeksa().equals(brIndeksa)) {
				// izmena pronadjenog
				s.setIme(ime);
				s.setPrezime(prezime);
				odgovor = "ok";
				break;
			}
		}
		out.println(odgovor);		
	}
	
	private void obrisiStudenta(PrintWriter out, String brIndeksa) { 
		String odgovor = "not_found";
		// pronalazenje studenta
		for (Student s: studenti) {
			if (s.getBrIndeksa().equals(brIndeksa)) {
				// brisanje pronadjenog
				studenti.remove(s);
				odgovor = "ok";
				break;
			}
		}
		out.println(odgovor);		
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.pokreni();
	}
}
