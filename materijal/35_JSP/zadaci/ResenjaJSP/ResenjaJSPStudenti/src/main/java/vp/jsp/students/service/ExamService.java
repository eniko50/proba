package vp.jsp.students.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.jsp.students.model.Exam;
import vp.jsp.students.repository.ExamRepository;

@Component
public class ExamService {
	@Autowired
	ExamRepository examRepository;

	public List<Exam> findAll() {
		return examRepository.findAll();
	}

	public Exam findOne(int id) {
		return examRepository.findOne(id);
	}

	public void save(Exam exam) {
		examRepository.save(exam);
		// snimanje u fajl pri svakoj izmeni
		try {
			persistExams();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void remove(int id) {
		examRepository.delete(id);
		// snimanje u fajl pri svakoj izmeni
		try {
			persistExams();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Exam> findByStudentId(int studentId) {
		return examRepository.findByStudentId(studentId);
	}
	
	public List<Exam> findByCourseId(int courseId) {
		return examRepository.findByCourseId(courseId);
	}

	public void persistExams() throws IOException {
		examRepository.saveToFile();
	}
}
