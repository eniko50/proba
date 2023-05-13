package vp.jsp.students.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import vp.jsp.students.model.Student;

@Component
public class StudentRepository {
	private List<Student> students;
	
	public StudentRepository() throws IOException {
		// ucitavamo studente iz fajla pri instanciranju repozitorijuma
		BufferedReader inputStream = new BufferedReader(new FileReader("data/students.txt"));
		students = new ArrayList<Student>();

        String line;
		while ((line = inputStream.readLine()) != null) {
			String[] data = line.split(",");
			int id = Integer.valueOf(data[0]);
			String cardNumber = data[1];
			String firstName = data[2];
			String lastName = data[3];
			
			Student student = new Student(id, firstName, lastName, cardNumber);
			
			students.add(student);
		} 
		inputStream.close();
	}
	
	public List<Student> findAll() {
		return students;
	}
	
	public Student findOne(int id) {
		for (Student student: students) {
			if (student.getId() == id) {
				return student;
			}
		}
		return null;
	}
	
	public Student findByCardNumber(String cardNumber) {
		for (Student student: students) {
			if (student.getCardNumber().equals(cardNumber)) {
				return student;
			}
		}
		return null;
	}
	
	
	public void save(Student student) {
		// save radi i snimanje i izmenu
		// ako prosledjeni entitet vec postoji u listi, onda je rec o izmeni
		Student existingStudent = findOne(student.getId());
		if (existingStudent == null) {
			student.setId(students.size() + 1);
			students.add(student);
		} else { 
			existingStudent.setCardNumber(student.getCardNumber());
			existingStudent.setFirstName(student.getFirstName());
			existingStudent.setLastName(student.getLastName());
		}
	}
	
	public void delete(int id) {		
		Iterator<Student> it = students.iterator();
		while (it.hasNext()) {
			if (it.next().getId() == id) {
				it.remove();
				return;
			}
		}			
	}
	
	public void saveToFile() throws IOException  {
		PrintWriter stream = new PrintWriter(new FileWriter("data/students.txt"));

		for (Student student : students) {
			stream.println(student.getId() + "," + student.getCardNumber() + "," + 
					student.getFirstName() + "," + student.getLastName());				
		}
		stream.close();
	}
}
