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
			case 5:
				showStudentExamsWithHigherGrade();
				break;
			case 6:
				showStudentExamsWithHigherGradeAndEspb();
				break;
			case 7:
				showStudentHighestGradeExam();
				break;
			case 8:
				showStudentLowestEspbExam();
				break;
			}
		} while (option != 9);
		
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
		System.out.println("5. Show student exams with grade greater than 8");
		System.out.println("6. Show student exams with grade greater than 8 and ECTS greater than 5");
		System.out.println("7. Show a student exam with the highest grade");
		System.out.println("8. Show a student exam the lowest ECTS");
		System.out.println("9. Back to main menu");
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
	
	private void showStudentExamsWithHigherGrade() {
		System.out.print("Student card number: ");
		String cardNumber = Helper.input();
		
		Student student = studentService.findByCardNumber(cardNumber);
		
		List<Exam> exams = examService.findExamsWithHigherGrade(student.getId(), 8); 
		
		exams.stream().forEach(System.out::println);
	}
	
	private void showStudentExamsWithHigherGradeAndEspb() {
		System.out.print("Student card number: ");
		String cardNumber = Helper.input();
		
		Student student = studentService.findByCardNumber(cardNumber);
		
		List<Exam> exams = examService.findExamsWithHigherGradeAndEspb(student.getId(), 8, 5); 
		
		exams.stream().forEach(System.out::println);
	}
	
	private void showStudentHighestGradeExam() {
		System.out.print("Student card number: ");
		String cardNumber = Helper.input();
		
		Student student = studentService.findByCardNumber(cardNumber);
		
		Exam exam = examService.findHighestGradeExam(student.getId()); 
		
		System.out.println(exam);
	}
	
	private void showStudentLowestEspbExam() {
		System.out.print("Student card number: ");
		String cardNumber = Helper.input();
		
		Student student = studentService.findByCardNumber(cardNumber);
		
		Exam exam = examService.findLowestEspbExam(student.getId()); 
		
		System.out.println(exam);
	}
}
