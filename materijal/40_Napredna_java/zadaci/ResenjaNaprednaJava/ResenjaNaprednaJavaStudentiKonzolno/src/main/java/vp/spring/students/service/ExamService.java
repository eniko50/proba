package vp.spring.students.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.students.model.Exam;
import vp.spring.students.repository.ExamRepository;

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
	}

	public void remove(int id) {
		examRepository.delete(id);
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
	
	public List<Exam> findExamsWithHigherGrade(int studentId, int grade) {
		return examRepository.findExamsWithHigherGrade(studentId, grade);
	}
	
	public List<Exam> findExamsWithHigherGradeAndEspb(int studentId, int grade, int espb) {
		return examRepository.findExamsWithHigherGradeAndEspb(studentId, grade, espb);
	}
	
	public Exam findHighestGradeExam(int studentId) {
		return examRepository.findHighestGradeExam(studentId);
	}
	
	public Exam findLowestEspbExam(int studentId) {
		return examRepository.findLowestEspbExam(studentId);
	}
}
