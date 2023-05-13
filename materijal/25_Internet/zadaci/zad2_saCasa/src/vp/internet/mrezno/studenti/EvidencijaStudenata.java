package vp.internet.mrezno.studenti;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EvidencijaStudenata {
	private List<Student> studenti = new ArrayList<Student>();
	
	public EvidencijaStudenata() {
		inicijalizujStudente();
	}
	
	private void inicijalizujStudente() {
		studenti.add(new Student("1783", "Marko", "Markovic"));
		studenti.add(new Student("3345", "Ivan", "Ivanovic"));
		studenti.add(new Student("3474", "Tamara", "Popovic"));
	}
	
	public static void main(String[] args) {
		EvidencijaStudenata evidencijaServer = new EvidencijaStudenata();
		
		ServerSocket ss;
		try {
			ss = new ServerSocket(9100);
			
			while (true) {
				Socket sock = ss.accept();
				
				BufferedReader in = new BufferedReader(new InputStreamReader(
						sock.getInputStream()));
				
				PrintWriter out = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(sock.getOutputStream())), true);
				
				String request = in.readLine();
				System.out.println("Klijent je poslao poruku: " + request);
				
				String[] reci = request.split(" ");
				switch (reci[0]) {
				case "dodaj":
					evidencijaServer.dodajStudenta(reci[1], reci[2], reci[3]);
					out.println("ok");
					break;
				case "obrisi":
					break;
				case "ispis":
					break;
				}
				
				in.close();
				out.close();
				sock.close();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void ispisiStudente() {
		for (Student s: studenti) {
			System.out.println(s);
		}
	}
	
	public Student getStudent(String brIndeksa) { 
		for (Student s: studenti) {
			if (s.getBrIndeksa().equals(brIndeksa)) {
				return s;
			}
		}
		return null;		
	}
	
	public boolean dodajStudenta(String brIndeksa, String ime, String prezime) { 
		Student student = new Student(brIndeksa, ime, prezime);
		return studenti.add(student);
	}
	
	public boolean izmeniStudenta(String brIndeksa, String ime, String prezime) { 
		for (Student s: studenti) {
			if (s.getBrIndeksa().equals(brIndeksa)) {
				s.setIme(ime);
				s.setPrezime(prezime);
				return true;
			}
		}
		return false;		
	}
	
	public boolean obrisiStudenta(String brIndeksa) { 
		for (Student s: studenti) {
			if (s.getBrIndeksa().equals(brIndeksa)) {
				studenti.remove(s);
				return true;
			}
		}
		return false;		
	}
}
