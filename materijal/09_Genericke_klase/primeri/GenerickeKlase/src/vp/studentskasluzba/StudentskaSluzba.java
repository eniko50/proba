package vp.studentskasluzba;

import java.util.ArrayList;

public class StudentskaSluzba {

	private ArrayList<Student> studenti;

	public StudentskaSluzba(){
		this.studenti = new ArrayList<Student>();
	}

	public Student pronadjiStudenta(String brojIndeksa){
		Student student;
		for (int i = 0; i < studenti.size(); i++) {
			student = studenti.get(i);
			if(student.getBrojIndeksa().equals(brojIndeksa)){
				return student;
			}
		}
		return null;
	}
	
	public boolean upisiStudenta(Student student){
		if(pronadjiStudenta(student.getBrojIndeksa())==null){
			studenti.add(student);
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean izbrisiStudenta(String brojIndeksa){
		Student student = pronadjiStudenta(brojIndeksa);
		return studenti.remove(student);
	}
	
	public boolean upisiNarednuGodinu(String brojIndeksa){
		Student student = pronadjiStudenta(brojIndeksa);
		if(student!=null&&student.getGodinaStudija()<5){
			student.setGodinaStudija(student.getGodinaStudija()+1);
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
