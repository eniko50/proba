package vp.spring.securitystudents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import vp.spring.securitystudents.model.Course;
import vp.spring.securitystudents.repository.CourseRepository;

@Component
public class CourseService {
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	ExamService examService;

	public List<Course> findAll() {
		return courseRepository.findAll();
	}
	
	public Page<Course> findAll(Pageable page) {
		return courseRepository.findAll(page);
	}

	public Course findOne(Long id) {
		return courseRepository.findById(id).get();
	}

	public Course save(Course course) {
		return courseRepository.save(course);
	}

	public void remove(Long id) {
		// dozvoljeno brisanje samo predmeta za koje ne postoje ispiti
		if (examService.findByCourseId(id).isEmpty()) {
			courseRepository.deleteById(id);
		}
	}
}
