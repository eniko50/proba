package vp.spring.students.view;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.students.model.Student;
import vp.spring.students.service.StudentService;
import vp.spring.students.util.Helper;

@Component
public class StudentView {
	@Autowired
	StudentService studentService;
	
	public StudentView(StudentService studentService) {
		this.studentService = studentService;
	}
	
	public void start()  {
		int option = 0;

		do {
			// unos opcije
			displayMenu();
			System.out.println("\nPlease choose the option: ");	
			option = Integer.parseInt(Helper.input());

			switch (option) {
			case 1:
				showStudents();
				break;
			case 2:
				findStudent();
				break;
			case 3:
				addStudent();
				break;
			case 4: 
				modifyStudent();
				break;
			case 5:
				removeStudent();
				break;
			}
		} while (option != 6);
		
		// pri napustanju menija, snimaju se podaci u fajl
		try {
			studentService.persistStudents();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void displayMenu() {
		System.out.println("1. Show all students");
		System.out.println("2. Find student");
		System.out.println("3. Add student");
		System.out.println("4. Modify student");
		System.out.println("5. Remove student");
		System.out.println("6. Back to main menu");
	}
	
	private void showStudents() {
		List<Student> students = studentService.findAll();
		for (Student s: students) {
			System.out.println(s);
		}
	}
	
	private void findStudent() {
		System.out.print("Card number: ");
		String cardNumber = Helper.input();
		
		Student student = studentService.findByCardNumber(cardNumber);
		if (student != null) {
			System.out.println(student);
		}
	}
	
	private void addStudent() {
		System.out.print("id: ");
		int id = Integer.valueOf(Helper.input());
		
		System.out.print("Card number: ");
		String cardNumber = Helper.input();
		
		System.out.print("First name: ");
		String firstName = Helper.input();
		
		System.out.print("Last name: ");
		String lastName = Helper.input();
		
		studentService.save(new Student(id, firstName, lastName, cardNumber));
	}
	
	private void modifyStudent() {
		System.out.print("Id: ");
		int id = Integer.valueOf(Helper.input());
		Student student = studentService.findOne(id);
		
		if (student == null) {
			System.out.println("Student does not exist.");
		} else { 
			System.out.print("Card number: ");
			String cardNumber = Helper.input();
			
			System.out.print("First name: ");
			String firstName = Helper.input();
			
			System.out.print("Last name: ");
			String lastName = Helper.input();
			
			studentService.save(new Student(id, firstName, lastName, cardNumber));
		}
	}
	
	private void removeStudent() {
		System.out.print("Id: ");
		int id = Integer.valueOf(Helper.input());
		
		studentService.remove(id);
	}
}
