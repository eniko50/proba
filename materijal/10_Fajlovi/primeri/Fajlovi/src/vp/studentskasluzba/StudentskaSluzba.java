package vp.studentskasluzba;

import java.io.IOException;
import java.util.ArrayList;

public class StudentskaSluzba {

	private ArrayList<Student> studenti;

	public StudentskaSluzba(){
//		this.studenti = new ArrayList<Student>();
		try {
			this.studenti = StudentiIO.ucitajStudente();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void sacuvaj(){
		try {
			StudentiIO.snimiStudente(studenti);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Student pronadjiStudenta(String brojIndeksa){
		Student student;
		for (int i = 0; i < studenti.size(); i++) {
			student = studenti.get(i);
			if(student.brojIndeksa.equals(brojIndeksa)){
				return student;
			}
		}
		return null;
	}
	
	public boolean upisiStudenta(Student student){
		if(pronadjiStudenta(student.brojIndeksa)==null){
			studenti.add(student);
			sacuvaj();
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean izbrisiStudenta(String brojIndeksa){
		Student student = pronadjiStudenta(brojIndeksa);
		boolean retVal = studenti.remove(student);
		sacuvaj();
		return retVal;
	}
	
	public boolean upisiNarednuGodinu(String brojIndeksa){
		Student student = pronadjiStudenta(brojIndeksa);
		if(student!=null&&student.godinaStudija<5){
			student.godinaStudija+=1;
			sacuvaj();
			return true;
		}
		else{
			return false;
		}
	}

	public ArrayList<Student> getStudenti(){
		return studenti;
	}
	
}
