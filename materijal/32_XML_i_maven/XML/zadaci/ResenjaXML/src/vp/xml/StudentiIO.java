package vp.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class StudentiIO {
	public static ArrayList<Student> ucitajStudente(List<Predmet> predmeti)  {
		ArrayList<Student> studenti = new ArrayList<Student>();
		
		// ucitavamo fajl
		try {			
			File inputFile = new File("data/studenti.xml");
	        DocumentBuilderFactory dbFactory 
	           = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(inputFile);
			
	        NodeList studentCvorovi = doc.getElementsByTagName("student");
	        for (int i = 0; i < studentCvorovi.getLength(); i++) {
	        	Student student = new Student();
	        	
	        	Node cvor = studentCvorovi.item(i);
	        	
	        	// id studenta je u atributu cvora
	        	String idStudenta = cvor.getAttributes().getNamedItem("id").getNodeValue();
	        	student.setId(idStudenta);
	        	
	        	NodeList cvoroviDetaljiStudenta = cvor.getChildNodes(); // indeks, ime, prezime
	        	
	        	for (int j = 0; j < cvoroviDetaljiStudenta.getLength(); j++) {
	        		Node cvorDetalj = cvoroviDetaljiStudenta.item(j);
	        		
	        		if (cvorDetalj.getNodeName().equals("indeks")) {
	        			// unutar taga indeks je tekst sa cvor sa vrednoscu indeksa;
	        			String brIndeksa = cvorDetalj.getFirstChild().getNodeValue();
	        			student.setBrIndeksa(brIndeksa);
	        		} else if (cvorDetalj.getNodeName().equals("ime")) {
	        			String ime = cvorDetalj.getFirstChild().getNodeValue();
	        			student.setIme(ime);
	        		} else if (cvorDetalj.getNodeName().equals("prezime")) {
	        			String prezime = cvorDetalj.getFirstChild().getNodeValue();
	        			student.setPrezime(prezime);
	        		}
	        	}
	        	studenti.add(student);
	        }
	        
	        // kada smo ucitali sve studente, mozemo da ucitamo i ispite
	        NodeList ispitCvorovi = doc.getElementsByTagName("ispit");
	        for (int i = 0; i < ispitCvorovi.getLength(); i++) {
	        	Ispit ispit = new Ispit();
	        	
	        	Node cvor = ispitCvorovi.item(i);
	        	
	        	NodeList cvoroviDetaljiIspita = cvor.getChildNodes(); // id-studenta, id-predmeta, ocena
	        	
	        	for (int j = 0; j < cvoroviDetaljiIspita.getLength(); j++) {
	        		Node cvorDetalj = cvoroviDetaljiIspita.item(j);
	        		
	        		if (cvorDetalj.getNodeName().equals("id-studenta")) {
	        			// unutar taga indeks je tekst sa cvor sa vrednoscu indeksa;
	        			String id = cvorDetalj.getFirstChild().getNodeValue();
	        			Student student = pronadjiStudentaPoId(studenti, id);
	        			student.dodajPolozeniIspit(ispit);
	        		} else if (cvorDetalj.getNodeName().equals("id-predmeta")) {
	        			String idPredmeta = cvorDetalj.getFirstChild().getNodeValue();
	        			Predmet predmet = pronadjiPredmetPoOznaci(predmeti, idPredmeta);
	        			ispit.setPredmet(predmet);
	        		} else if (cvorDetalj.getNodeName().equals("ocena")) {
	        			String ocena = cvorDetalj.getFirstChild().getNodeValue();
	        			ispit.setOcena(Integer.valueOf(ocena));
	        		}
	        	}
	        		
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studenti;
	}
	
	private static Student pronadjiStudentaPoId(List<Student> studenti, String id){
		for (Student student : studenti) {
			if(student.getId().equals(id)){
				return student;
			}
		}
		return null;
	}
	
	private static Predmet pronadjiPredmetPoOznaci(List<Predmet> predmeti, String oznaka){
		for (Predmet predmet : predmeti) {
			if(predmet.getOznaka().equals(oznaka)){
				return predmet;
			}
		}
		return null;
	}
}
