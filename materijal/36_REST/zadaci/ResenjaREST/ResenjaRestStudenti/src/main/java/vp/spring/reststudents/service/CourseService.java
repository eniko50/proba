package vp.spring.reststudents.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.reststudents.model.Course;
import vp.spring.reststudents.repository.CourseRepository;

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

	public Course save(Course course) {
		courseRepository.save(course);
		// snimanje u fajl pri svakoj izmeni
		try {
			persistCourses();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return course; 
	}

	public void remove(int id) {
		// dozvoljeno brisanje samo predmeta za koje ne postoje ispiti
		if (examService.findByCourseId(id).isEmpty()) {
			courseRepository.delete(id);
		}
		// snimanje u fajl pri svakoj izmeni
		try {
			persistCourses();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void persistCourses() throws IOException {
		courseRepository.saveToFile();
	}
}
