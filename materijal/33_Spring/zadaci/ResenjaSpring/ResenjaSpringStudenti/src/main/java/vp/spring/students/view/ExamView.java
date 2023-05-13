package vp.spring.students.view;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.students.model.Course;
import vp.spring.students.model.Exam;
import vp.spring.students.model.Student;
import vp.spring.students.service.CourseService;
import vp.spring.students.service.ExamService;
import vp.spring.students.service.StudentService;
import vp.spring.students.util.Helper;

@Component
public class ExamView {
	@Autowired
	ExamService examService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	CourseService courseService;
	
	public void start()  {
		int option = 0;

		do {
			// unos opcije
			displayMenu();
			System.out.println("\nPlease choose the option: ");	
			option = Integer.parseInt(Helper.input());

			switch (option) {
			case 1:
				showExams();
				break;
			case 2:
				addExam();
				break;
			case 3:
				removeExam();
				break;
			case 4:
				showStudentExams();
				break;
			}
		} while (option != 5);
		
		// pri napustanju menija, snimaju se podaci u fajl
		try {
			examService.persistExams();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void displayMenu() {
		System.out.println("1. Show all exams");
		System.out.println("2. Add exam");
		System.out.println("3. Remove exam");
		System.out.println("4. Show student exams");
		System.out.println("5. Back to main menu");
	}
	
	private void showExams() {
		List<Exam> exams = examService.findAll();
		for (Exam exam: exams) {
			System.out.println(exam);
		}
	}
	
	private void addExam() {
		System.out.print("id: ");
		int id = Integer.valueOf(Helper.input());
		
		System.out.print("Student card number: ");
		String cardNumber = Helper.input();
		Student student = studentService.findByCardNumber(cardNumber);
		
		System.out.print("Course id: ");
		int courseId = Integer.valueOf(Helper.input());
		Course course = courseService.findOne(courseId);
		
		System.out.print("Grade: ");
		int grade = Integer.valueOf(Helper.input());
		
		if (student != null && course != null) {
			examService.save(new Exam(id, student, course, grade));
		} else {
			System.out.println("Unknown student or course.");
		}		
	}
	
	private void removeExam() {
		System.out.print("Id: ");
		int id = Integer.valueOf(Helper.input());
		
		examService.remove(id);
	}
	
	private void showStudentExams() {
		System.out.print("Student card number: ");
		String cardNumber = Helper.input();
		
		Student student = studentService.findByCardNumber(cardNumber);
		
		List<Exam> exams = examService.findByStudentId(student.getId());
		
		for (Exam exam: exams) {
			System.out.println(exam);
		}
	}
}