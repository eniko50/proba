package vp.jpa.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.jpa.students.model.Course;
import vp.jpa.students.repository.CourseRepository;

@Component
public class CourseService {
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	ExamService examService;

	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	public Course findOne(Long id) {
		return courseRepository.findOne(id);
	}

	public Course save(Course course) {
		return courseRepository.save(course);
	}

	public void remove(Long id) {
		// dozvoljeno brisanje samo predmeta za koje ne postoje ispiti
		if (examService.findByCourseId(id).isEmpty()) {
			courseRepository.delete(id);
		}
	}
}
