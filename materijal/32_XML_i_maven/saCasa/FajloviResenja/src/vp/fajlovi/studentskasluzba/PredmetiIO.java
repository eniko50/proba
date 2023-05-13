package vp.fajlovi.studentskasluzba;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class PredmetiIO {
	private static String putanja = "src/vp/fajlovi/studentskasluzba/predmeti.xml";

	private static Predmet string2Predmet(String red) {
		String[] s = red.split(",");
		Predmet retVal = new Predmet(s[0], s[1], Integer.parseInt(s[2]), Boolean.parseBoolean(s[3]));
		return retVal;
	}

	private static String predmet2String(Predmet predmet) {
		return predmet.getOznaka() + "," + predmet.getNaziv() + "," + predmet.getEspb() + "," + predmet.isObrisan();
	}

	public static ArrayList<Predmet> ucitajPredmete() {
		ArrayList<Predmet> subjects = new ArrayList<>();
		try {
			File subjectFile = new File(putanja);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(subjectFile);
			
			NodeList nodes = document.getElementsByTagName("predmet");
			
			for (int i = 0; i < nodes.getLength(); i++) {
				Predmet subject = new Predmet();
				Node subjectNode = nodes.item(i);
				
				String id = subjectNode.getAttributes().getNamedItem("id").getNodeValue();
				
				
				subjects.add(subject);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return subjects;
	}

	public static void snimiPredmete(List<Predmet> predmeti) throws IOException {
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileWriter(putanja));
			for (int i = 0; i < predmeti.size(); i++) {
				outputStream.println(predmet2String(predmeti.get(i)));
			}
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
		}

	}

}
