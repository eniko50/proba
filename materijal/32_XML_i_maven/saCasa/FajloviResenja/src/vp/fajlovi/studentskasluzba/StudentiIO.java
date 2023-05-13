package vp.fajlovi.studentskasluzba;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class StudentiIO {

	private static String putanjaStudenti = "src/vp/fajlovi/studentskasluzba/studenti.txt";
	private static String putanjaIspiti = "src/vp/fajlovi/studentskasluzba/ispiti.txt";

	private static Student string2Student(String red) {
		String[] s = red.split(",");
		Student retVal = new Student(s[0], s[1], s[2], Boolean.parseBoolean(s[3]));
		return retVal;
	}

	private static String student2String(Student student) {
		return student.getBrIndeksa() + "," + student.getIme() + "," + student.getPrezime()
				+ "," + student.isObrisan();
	}

	public static ArrayList<Student> ucitajStudente(List<Predmet> predmeti) throws IOException {
		BufferedReader inputStream = null;
		ArrayList<Student> studenti = null;
		try {
			inputStream = new BufferedReader(new FileReader(putanjaStudenti));
			studenti = new ArrayList<Student>();
            String l;
			while ((l = inputStream.readLine()) != null) {
				studenti.add(string2Student(l));
			}
			ucitajIspite(studenti, predmeti);
			return studenti;
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}
	
	private static void ucitajIspite(List<Student> studenti, List<Predmet> predmeti)throws IOException {
		BufferedReader inputStream = null;
		try {
			inputStream = new BufferedReader(new FileReader(putanjaIspiti));
            String l;
			while ((l = inputStream.readLine()) != null) {
				String[] s = l.split(",");
				Student student = pronadjiStudentaPoBrojuIndeksa(studenti, s[0]);
				Predmet predmet = pronadjiPredmetPoOznaci(predmeti, s[1]);
				if(student!=null&&predmet!=null){
					Ispit ispit = new Ispit(predmet, Integer.parseInt(s[2]));
					student.dodajPolozeniIspit(ispit);
				}
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
		
	}
	
	private static Student pronadjiStudentaPoBrojuIndeksa(List<Student> studenti, String brojIndeksa){
		for (Student student : studenti) {
			if(student.getBrIndeksa().equals(brojIndeksa)){
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
	
	public static void snimiStudente(List<Student> studenti) throws IOException{
		PrintWriter studentiOutputStream = null;
		PrintWriter ispitiOutputStream = null;
		try {
			studentiOutputStream = new PrintWriter(new FileWriter(putanjaStudenti));
			ispitiOutputStream = new PrintWriter(new FileWriter(putanjaIspiti));
			for (Student student : studenti) {
				studentiOutputStream.println(student2String(student));				
				for (Ispit ispit : student.getIspiti()) {
					String red = student.getBrIndeksa()+","+ispit.getPredmet().getOznaka()+","+ispit.getOcena();
					ispitiOutputStream.println(red);
				}
			}
		} finally {
			if (studentiOutputStream != null) {
				studentiOutputStream.close();
			}
			if (ispitiOutputStream != null) {
				ispitiOutputStream.close();
			}
		}	
	}

}
