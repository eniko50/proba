package vp.spring.reststudents.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.reststudents.model.Exam;
import vp.spring.reststudents.repository.ExamRepository;

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

	public Exam save(Exam exam) {
		examRepository.save(exam);
		// snimanje u fajl pri svakoj izmeni
		try {
			persistExams();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return exam;
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
