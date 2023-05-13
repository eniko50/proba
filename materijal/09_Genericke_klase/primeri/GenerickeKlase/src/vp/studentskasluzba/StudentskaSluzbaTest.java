package vp.studentskasluzba;

public class StudentskaSluzbaTest {
	
	public static void main(String[] args) {
		StudentskaSluzba studentskaSluzba = new StudentskaSluzba();
		Student peraPeric = new Student("e12", "Pera", "Peric", 1);
		Student markoMarkovic = new Student("e15", "Marko", "Markovic", 2);
		studentskaSluzba.upisiStudenta(peraPeric);
		studentskaSluzba.upisiStudenta(markoMarkovic);
		System.out.println(studentskaSluzba.getStudenti());
		studentskaSluzba.izbrisiStudenta("e12");
		System.out.println(studentskaSluzba.getStudenti());
		studentskaSluzba.upisiNarednuGodinu("e15");
		System.out.println(studentskaSluzba.getStudenti());
	}
}
