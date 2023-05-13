package vp.jpa.students.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.jpa.students.model.Course;
import vp.jpa.students.model.Exam;
import vp.jpa.students.model.Student;

@Component
@Transactional 
public class ExamRepository {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;

	public List<Exam> findAll() {
		Query q = em.createQuery("SELECT e FROM Exam e");

		return q.getResultList();
	}

	public Exam findOne(Long id) {
		return em.find(Exam.class, id);
	}

	public Exam save(Exam exam) {
		em.persist(exam);
		return exam;		
	}
	
	public void delete(Long id) {
		em.remove(findOne(id));
	}
	
	public List<Exam> findByStudentId(Long studentId) {
		Student student = studentRepository.findOne(studentId);
		return new ArrayList<Exam>(student.getExams());
	}
	
	public List<Exam> findByCourseId(Long courseId) {
		Course course = courseRepository.findOne(courseId);
		return new ArrayList<Exam>(course.getExams());
	}
	
	public double findStudentAvgGrade(Long studentId) {
		Query q = em.createQuery("SELECT avg(e.grade) from Exam e where e.student.id = :id");
		q.setParameter("id", studentId);
		return (double) q.getSingleResult();
	}
	
	public List<Course> findCoursesByExamCount() {
		Query q = em.createQuery("SELECT e.course from Exam e group by e.course order by count(e.course)");
		return q.getResultList();
	}
}
