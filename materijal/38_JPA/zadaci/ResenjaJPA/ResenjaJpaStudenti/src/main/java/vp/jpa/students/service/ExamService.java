package vp.jpa.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.jpa.students.model.Course;
import vp.jpa.students.model.Exam;
import vp.jpa.students.repository.ExamRepository;

@Component
public class ExamService {
	@Autowired
	ExamRepository examRepository;

	public List<Exam> findAll() {
		return examRepository.findAll();
	}

	public Exam findOne(Long id) {
		return examRepository.findOne(id);
	}

	public Exam save(Exam exam) {
		return examRepository.save(exam);
	}

	public void remove(Long id) {
		examRepository.delete(id);
	}
	
	public List<Exam> findByStudentId(Long studentId) {
		return examRepository.findByStudentId(studentId);
	}
	
	public List<Exam> findByCourseId(Long courseId) {
		return examRepository.findByCourseId(courseId);
	}
	
	public double findStudentAvgGrade(Long studentId) {
		return examRepository.findStudentAvgGrade(studentId);
	}

	public List<Course> findCoursesByExamCount() {
		return examRepository.findCoursesByExamCount();
	}
}