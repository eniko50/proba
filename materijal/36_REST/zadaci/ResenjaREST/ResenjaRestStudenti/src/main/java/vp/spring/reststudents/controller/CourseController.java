package vp.spring.reststudents.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.reststudents.model.Course;
import vp.spring.reststudents.service.CourseService;

@RestController
public class CourseController {
	@Autowired
	CourseService courseService;

	@RequestMapping(value = "api/courses", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Course>> getAllCourses() {
		List<Course> courses = courseService.findAll();

		return new ResponseEntity<>(courses, HttpStatus.OK); 
	}

	@RequestMapping(value = "api/courses/{id}", method = RequestMethod.GET)
	public ResponseEntity<Course> getCourse(@PathVariable int id) {
		Course Course = courseService.findOne(id);

		return new ResponseEntity<>(Course, HttpStatus.OK);
	}

	@RequestMapping(value = "api/courses", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> create(@RequestBody Course course) {
		Course retVal = courseService.save(course);

		return new ResponseEntity<>(retVal, HttpStatus.CREATED);
	}

	@RequestMapping(value = "api/courses/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Course> update(@PathVariable int id,
			@RequestBody Course course) {
		course.setId(id);
		Course retVal = courseService.save(course);

		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}

	@RequestMapping(value = "api/courses/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable int id) {
		Course course = courseService.findOne(id);
		if (course != null) {
			courseService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
