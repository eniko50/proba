package vp.spring.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.students.model.Student;
import vp.spring.students.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="api/students", method = RequestMethod.GET) 
	public String getAllStudents() {
		List<Student> students = studentService.findAll();
		
		StringBuffer sb = new StringBuffer();
		for (Student p: students) {
			sb.append(p).append("\n"); 
		}
		
		return sb.toString();
	}
	
	@RequestMapping(value="pages/students", method = RequestMethod.GET) 
	public String getStudentsHtml() {
		List<Student> students = studentService.findAll();
		
		StringBuffer sb = new StringBuffer();
		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<td>");
		sb.append("Card number");
		sb.append("</td>");
		sb.append("<td>");
		sb.append("First name");
		sb.append("</td>");
		sb.append("<td>");
		sb.append("Last name");
		sb.append("</td>");
		sb.append("</tr>");
		
		for (Student s: students) {
			sb.append("<tr>");
			sb.append("<td>");
			sb.append(s.getCardNumber());
			sb.append("</td>");
			sb.append("<td>");
			sb.append(s.getFirstName());
			sb.append("</td>");
			sb.append("<td>");
			sb.append(s.getLastName());
			sb.append("</td>");
			sb.append("</tr>"); 
		}
		return sb.toString();
	}
	
	@RequestMapping(value="api/students/{id}", method = RequestMethod.GET) 
	public String getStudent(@PathVariable int id) {
		Student student = studentService.findOne(id);
		
		return student.toString();
	}
	
	
}
