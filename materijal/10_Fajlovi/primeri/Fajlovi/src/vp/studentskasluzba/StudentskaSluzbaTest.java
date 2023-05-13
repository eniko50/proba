package vp.studentskasluzba;

public class StudentskaSluzbaTest {
	
	public static void main(String[] args) {
		StudentskaSluzba sSluzba = new StudentskaSluzba();
		sSluzba.upisiStudenta(new Student("e22", "Mihajlo", "Mihajlovic", 3));
		System.out.println(sSluzba.getStudenti());
	}
}
