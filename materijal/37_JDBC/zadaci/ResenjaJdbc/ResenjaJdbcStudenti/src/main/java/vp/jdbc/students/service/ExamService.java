package vp.jdbc.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.jdbc.students.model.Exam;
import vp.jdbc.students.repository.ExamRepository;

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
		return examRepository.save(exam);
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
}
