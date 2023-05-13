package vp.studentskasluzba;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StudentiIO {

	private static String putanja = "src/vp/studentskasluzba/studenti.txt";

	private static Student string2Student(String red) {
		String[] s = red.split(",");
		Student retVal = new Student(s[0], s[1], s[2], Integer.parseInt(s[3]));
		return retVal;
	}

	private static String student2String(Student student) {
		return student.brojIndeksa + "," + student.ime + "," + student.prezime
				+ "," + student.godinaStudija;
	}

	public static ArrayList<Student> ucitajStudente() throws IOException {
		BufferedReader inputStream = null;
		ArrayList<Student> studenti = null;
		try {
			inputStream = new BufferedReader(new FileReader(putanja));
			studenti = new ArrayList<Student>();
            String l;
			while ((l = inputStream.readLine()) != null) {
				studenti.add(string2Student(l));
			}
			return studenti;
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}
	
	public static void snimiStudente(ArrayList<Student> studenti) throws IOException{
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileWriter(putanja));
			for (int i = 0; i < studenti.size(); i++) {
				outputStream.println(student2String(studenti.get(i)));
			}
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
		}
		
	}
}
