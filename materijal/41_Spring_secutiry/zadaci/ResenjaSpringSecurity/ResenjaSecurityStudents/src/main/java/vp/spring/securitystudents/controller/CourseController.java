package vp.spring.securitystudents.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.securitystudents.dto.CourseDTO;
import vp.spring.securitystudents.model.Course;
import vp.spring.securitystudents.service.CourseService;
import vp.spring.securitystudents.service.ExamService;

@RestController
public class CourseController {
	@Autowired
	CourseService courseService;
	
	@Autowired
	ExamService examService;

	@RequestMapping(value = "api/courses", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<CourseDTO>> getCoursesPage(Pageable page) {
		Page<Course> courses = courseService.findAll(page);
		
		List<CourseDTO> retVal = new ArrayList<>();
		
		for (Course course: courses) {
			retVal.add(new CourseDTO(course));
		}

		return new ResponseEntity<>(retVal, HttpStatus.OK); 
	}

	@RequestMapping(value = "api/courses/{id}", method = RequestMethod.GET)
	public ResponseEntity<CourseDTO> getCourse(@PathVariable Long id) {
		Course course = courseService.findOne(id);

		if (course != null) {
			CourseDTO courseDTO = new CourseDTO(course);
			return new ResponseEntity<>(courseDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "api/courses", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseDTO> create(@RequestBody CourseDTO courseDTO) {
		Course course = new Course();
		course.setName(courseDTO.getName());
		course.setEspb(courseDTO.getEspb());
		
		course = courseService.save(course);

		return new ResponseEntity<>(new CourseDTO(course), HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "api/courses/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CourseDTO> update(@PathVariable Long id,
			@RequestBody CourseDTO courseDTO) {
		Course course = courseService.findOne(id);
		
		if (course == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		course.setId(id);
		course.setName(courseDTO.getName());
		course.setEspb(courseDTO.getEspb());
		
		course= courseService.save(course);

		return new ResponseEntity<>(new CourseDTO(course), HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "api/courses/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Course course = courseService.findOne(id);
		if (course != null) {
			courseService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "api/courses", method = RequestMethod.GET, params = "sortByExamCount")
	public ResponseEntity<List<CourseDTO>> getCoursesByExamCount(
			@RequestParam boolean sortByExamCount, Pageable page) {
		Page<Course> courses = examService.findCoursesByExamCount(page);
		
		List<CourseDTO> retVal = new ArrayList<>();
		
		for (Course course: courses) {
			retVal.add(new CourseDTO(course));
		}

		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
}
