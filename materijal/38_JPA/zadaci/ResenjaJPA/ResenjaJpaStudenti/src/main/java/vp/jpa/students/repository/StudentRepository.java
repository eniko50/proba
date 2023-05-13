package vp.jpa.students.repository;

import java.sql.Connection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import vp.jpa.students.model.Student;

@Component
@Transactional 
public class StudentRepository {

	@PersistenceContext
	EntityManager em;

	public List<Student> findAll() {
		Query q = em.createQuery("SELECT s FROM Student s");

		return q.getResultList();
	}

	public Student findOne(Long id) {
		return em.find(Student.class, id);
	}

	public Student save(Student student) {
		if (student.getId() != null) {
			return em.merge(student);	
		} else {
			em.persist(student);
			return student;		
		}
		
	}
	
	public void delete(Long id) {
		em.remove(findOne(id));
	}

	public Student findByCardNumber(String cardNumber) {
		Query q = em.createQuery("SELECT s FROM Student s WHERE cardNumber = :cardNumber");
		q.setParameter("cardNumber", cardNumber); 
		return (Student) q.getSingleResult();
	}
	
	public List<Student> findAllWithExams() {
		Query q = em.createQuery("SELECT s FROM Student s left join fetch s.exams");
		return q.getResultList();
	}
}
