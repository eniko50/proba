package vp.spring.students.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.students.model.Course;
import vp.spring.students.repository.CourseRepository;

@Component
public class CourseService {
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	ExamService examService;

	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	public Course findOne(int id) {
		return courseRepository.findOne(id);
	}

	public void save(Course course) {
		courseRepository.save(course);
	}

	public void remove(int id) {
		// only courses with no exams can be deleted
		if (examService.findByCourseId(id).isEmpty()) {
			courseRepository.delete(id);
		}
	}

	public void persistCourses() throws IOException {
		courseRepository.saveToFile();
	}
}
