package vp.jdbc.students.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.jdbc.students.model.Course;
import vp.jdbc.students.model.Exam;
import vp.jdbc.students.model.Student;

@Component
public class ExamRepository {
	Connection conn;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	public ExamRepository() throws IOException {
		// ucitavanje MySQL drajvera
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// otvaranje konekcije
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db_jdbc_students", // adresa servera i
																// ime baze
					"root", "rootroot"); // username i password
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Exam> findAll() {
		List<Exam> retVal = new ArrayList<>(); 

		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt
				.executeQuery("select exam.id, exam.grade, student.id, student.card_number, "
						+ "student.first_name, student.last_name, course.id, course.name, "
						+ "course.espb from exam join student on exam.student_id = student.id "
						+ "join course on exam.course_id = course.id");
		
		while (rset.next()) { 
			int examId = rset.getInt(1);
			int grade = rset.getInt(2);
			int studentId = rset.getInt(3);
			String cardNumber = rset.getString(4);
			String firstName = rset.getString(5);
			String lastName = rset.getString(6);
			int courseId = rset.getInt(7);
			String courseName = rset.getString(8);
			int espb = rset.getInt(9);
		
			Student student = new Student(studentId, firstName, lastName, cardNumber);
			Course course = new Course(courseId, courseName, espb);
			
			Exam exam = new Exam(examId, student, course, grade);
			retVal.add(exam);	
		}
		rset.close();
		stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	public Exam findOne(int id) {
		Exam retVal = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"select exam.id, exam.grade, student.id, student.card_number, "
						+ "student.first_name, student.last_name, course.id, course.name, "
						+ "course.espb from exam join student on exam.student_id = student.id "
						+ "join course on exam.course_id = course.id where exam.id = ?");
			stmt.setInt(1, id); // na mesto prvog parametra postavljamo vrednost promenljive id
			ResultSet rset = stmt.executeQuery();
			
			if (rset.next()) { 
				int examId = rset.getInt(1);
				int grade = rset.getInt(2);
				int studentId = rset.getInt(3);
				String cardNumber = rset.getString(4);
				String firstName = rset.getString(5);
				String lastName = rset.getString(6);
				int courseId = rset.getInt(7);
				String courseName = rset.getString(8);
				int espb = rset.getInt(9);
			
				Student student = new Student(studentId, firstName, lastName, cardNumber);
				Course course = new Course(courseId, courseName, espb);
				
				retVal = new Exam(examId, student, course, grade);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	public List<Exam> findByStudentId(int studentId) {
		List<Exam> retVal = new ArrayList<>();
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"select exam.id, exam.grade, student.id, student.card_number, "
						+ "student.first_name, student.last_name, course.id, course.name, "
						+ "course.espb from exam join student on exam.student_id = student.id "
						+ "join course on exam.course_id = course.id where exam.student_id = ?");
			stmt.setInt(1, studentId); 
			ResultSet rset = stmt.executeQuery();
			
			while (rset.next()) { 
				int examId = rset.getInt(1);
				int grade = rset.getInt(2);
				String cardNumber = rset.getString(4);
				String firstName = rset.getString(5);
				String lastName = rset.getString(6);
				int courseId = rset.getInt(7);
				String courseName = rset.getString(8);
				int espb = rset.getInt(9);
			
				Student student = new Student(studentId, firstName, lastName, cardNumber);
				Course course = new Course(courseId, courseName, espb);
				
				Exam exam = new Exam(examId, student, course, grade);
				retVal.add(exam);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	public List<Exam> findByCourseId(int courseId) {
		List<Exam> retVal = new ArrayList<Exam>();
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"select exam.id, exam.grade, student.id, student.card_number, "
						+ "student.first_name, student.last_name, course.id, course.name, "
						+ "course.espb from exam join student on exam.student_id = student.id "
						+ "join course on exam.course_id = course.id where exam.course_id = ?");
			stmt.setInt(1, courseId); 
			ResultSet rset = stmt.executeQuery();
			
			if (rset.next()) { 
				int examId = rset.getInt(1);
				int grade = rset.getInt(2);
				int studentId = rset.getInt(3);
				String cardNumber = rset.getString(4);
				String firstName = rset.getString(5);
				String lastName = rset.getString(6);
				String courseName = rset.getString(8);
				int espb = rset.getInt(9);
			
				Student student = new Student(studentId, firstName, lastName, cardNumber);
				Course course = new Course(courseId, courseName, espb);
				
				Exam exam = new Exam(examId, student, course, grade);
				retVal.add(exam);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	public Exam save(Exam exam) {
		Exam retVal = null; 
		
		try {
			// id je auto generisan i potrebno je da preuzmemo dobijenu vrednost
			PreparedStatement stmt = conn.prepareStatement(
					"insert into exam (student_id, course_id, grade) values (?, ?, ?)", 
					Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, exam.getStudent().getId());
			stmt.setInt(2, exam.getCourse().getId());
			stmt.setInt(3, exam.getGrade());
			
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) { // uspesno ubacen	
				// preuzmemo id koji je baza dodelila
				ResultSet keys = stmt.getGeneratedKeys();
				keys.next(); // pozicioniramo se na slog u result setu
				
				int id = keys.getInt(1); // id je u prvom i jedinom polju sloga result seta
				retVal = new Exam(id, studentRepository.findOne(exam.getStudent().getId()),
						courseRepository.findOne(exam.getCourse().getId()), exam.getGrade());
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	public void delete(int id) {
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"delete from exam where id = ?");
			stmt.setInt(1, id);
			
			stmt.executeUpdate();

			stmt.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
