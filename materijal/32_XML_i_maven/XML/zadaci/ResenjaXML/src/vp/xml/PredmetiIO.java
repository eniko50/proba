package vp.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PredmetiIO {
	
	public static ArrayList<Predmet> ucitajPredmete() throws IOException {
		ArrayList<Predmet> predmeti = new ArrayList<Predmet>();
		
		// ucitavamo fajl
		try {			
			File inputFile = new File("data/studenti.xml");
	        DocumentBuilderFactory dbFactory 
	           = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(inputFile);
			
	        NodeList predmetCvorovi = doc.getElementsByTagName("predmet");
	        for (int i = 0; i < predmetCvorovi.getLength(); i++) {
	        	Predmet predmet = new Predmet();
	        	
	        	Node cvor = predmetCvorovi.item(i);
	        	
	        	// oznaka je u atributu id
	        	String oznaka = cvor.getAttributes().getNamedItem("id").getNodeValue();
	        	predmet.setOznaka(oznaka);
	        	
	        	NodeList cvoroviDetaljiPredmeta = cvor.getChildNodes(); // naziv, espb
	        	
	        	for (int j = 0; j < cvoroviDetaljiPredmeta.getLength(); j++) {
	        		Node cvorDetalj = cvoroviDetaljiPredmeta.item(j);
	        		
	        		if (cvorDetalj.getNodeName().equals("naziv")) {
	        			String naziv = cvorDetalj.getFirstChild().getNodeValue();
	        			predmet.setNaziv(naziv);
	        		} else if (cvorDetalj.getNodeName().equals("espb")) {
	        			String espb = cvorDetalj.getFirstChild().getNodeValue();
	        			predmet.setEspb(Integer.valueOf(espb));
	        		} 
	        	}
	        	predmeti.add(predmet);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return predmeti;
	}
}
