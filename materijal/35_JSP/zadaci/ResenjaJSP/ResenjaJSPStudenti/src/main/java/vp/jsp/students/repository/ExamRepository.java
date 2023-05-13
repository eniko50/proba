package vp.jsp.students.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.jsp.students.model.Exam;

@Component
public class ExamRepository {
	private List<Exam> exams;
	
	@Autowired
	public ExamRepository(StudentRepository studentRepository, CourseRepository courseRepository) throws IOException {
		// ucitavamo ispite iz fajla pri instanciranju repozitorijuma
		BufferedReader inputStream = new BufferedReader(new FileReader("data/exams.txt"));
		exams = new ArrayList<Exam>();

        String line;
		while ((line = inputStream.readLine()) != null) {
			String[] data = line.split(",");
			int id = Integer.valueOf(data[0]);
			int studentId = Integer.valueOf(data[1]);
			int courseId = Integer.valueOf(data[2]);
			int grade = Integer.valueOf(data[3]);
			
			// studenta i predmet dobijamo iz njihovih repozitorijuma preko id-a
			Exam exam = new Exam(id, studentRepository.findOne(studentId), 
					courseRepository.findOne(courseId), grade);
			
			exams.add(exam);
		} 
		inputStream.close();
	}
	
	public List<Exam> findAll() {
		return exams;
	}
	
	public Exam findOne(int id) {
		for (Exam exam: exams) {
			if (exam.getId() == id) {
				return exam;
			}
		}
		return null;
	}
	
	public List<Exam> findByStudentId(int studentId) {
		List<Exam> retVal = new ArrayList<>();
		for (Exam exam: exams) {
			if (exam.getStudent().getId() == studentId) {
				retVal.add(exam);
			}
		}
		return retVal;
	}
	
	public List<Exam> findByCourseId(int courseId) {
		List<Exam> retVal = new ArrayList<>();
		for (Exam exam: exams) {
			if (exam.getCourse().getId() == courseId) {
				retVal.add(exam);
			}
		}
		return retVal;
	}
	
	public void save(Exam exam) {
		exam.setId(exams.size() + 1);
		exams.add(exam);
	}
	
	public void delete(int id) {		
		Iterator<Exam> it = exams.iterator();
		while (it.hasNext()) {
			if (it.next().getId() == id) {
				it.remove();
				return;
			}
		}			
	}
	
	public void saveToFile() throws IOException  {
		PrintWriter stream = new PrintWriter(new FileWriter("data/exams.txt"));

		for (Exam exam : exams) {
			stream.println(exam.getId() + "," + exam.getStudent().getId() + "," + 
					exam.getCourse().getId() + "," + exam.getGrade());				
		}
		stream.close();
	}
}
