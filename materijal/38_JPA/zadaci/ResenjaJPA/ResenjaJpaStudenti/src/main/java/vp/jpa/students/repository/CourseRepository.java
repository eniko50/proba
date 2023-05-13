package vp.jpa.students.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import vp.jpa.students.model.Course;

@Component
@Transactional 
public class CourseRepository {

	@PersistenceContext
	EntityManager em;

	public List<Course> findAll() {
		Query q = em.createQuery("SELECT c FROM Course c");

		return q.getResultList();
	}

	public Course findOne(Long id) {
		return em.find(Course.class, id);
	}

	public Course save(Course course) {
		if (course.getId() != null) {
			return em.merge(course);	
		} else {
			em.persist(course);
			return course;		
		}
	}
	
	public void delete(Long id) {
		em.remove(findOne(id));
	}
}
