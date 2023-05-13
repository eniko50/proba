package vp.spring.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.students.model.Course;
import vp.spring.students.service.CourseService;

@RestController
public class CourseController {
	@Autowired
	CourseService courseService;
	
	@RequestMapping(value="api/courses", method = RequestMethod.GET) 
	public String getAllCourses() {
		List<Course> courses = courseService.findAll();
		
		StringBuffer sb = new StringBuffer();
		for (Course p: courses) {
			sb.append(p).append("\n"); 
		}
		
		return sb.toString();
	}
	
	@RequestMapping(value="pages/courses", method = RequestMethod.GET) 
	public String getCoursesHtml() {
		List<Course> courses = courseService.findAll();
		
		StringBuffer sb = new StringBuffer();
		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<td>");
		sb.append("Name");
		sb.append("</td>");
		sb.append("<td>");
		sb.append("ESPB");
		sb.append("</td>");
		sb.append("</tr>");
		
		for (Course c: courses) {
			sb.append("<tr>");
			sb.append("<td>");
			sb.append(c.getName());
			sb.append("</td>");
			sb.append("<td>");
			sb.append(c.getEspb());
			sb.append("</td>");
			sb.append("</tr>"); 
		}
		return sb.toString();
	}
	
	@RequestMapping(value="api/courses/{id}", method = RequestMethod.GET) 
	public String getCourse(@PathVariable int id) {
		Course course = courseService.findOne(id);
		
		return course.toString();
	}
}
