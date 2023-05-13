package vp.spring.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.students.model.Exam;
import vp.spring.students.service.ExamService;

@RestController
public class ExamController {
	@Autowired
	ExamService examService;
	
	@RequestMapping(value="api/exams", method = RequestMethod.GET) 
	public String getAllExams() {
		List<Exam> exams = examService.findAll();
		
		StringBuffer sb = new StringBuffer();
		for (Exam p: exams) {
			sb.append(p).append("\n"); 
		}
		
		return sb.toString();
	}
	
	@RequestMapping(value="pages/exams", method = RequestMethod.GET) 
	public String getExamsHtml() {
		List<Exam> exams = examService.findAll();
		
		StringBuffer sb = new StringBuffer();
		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<td>");
		sb.append("Student");
		sb.append("</td>");
		sb.append("<td>");
		sb.append("Course");
		sb.append("</td>");
		sb.append("<td>");
		sb.append("Grade");
		sb.append("</td>");
		sb.append("</tr>");
		
		for (Exam e: exams) {
			sb
			.append("<tr>")
			.append("<td>")
			.append(e.getStudent().getCardNumber())
			.append(" ")
			.append(e.getStudent().getFirstName())
			.append(" ")
			.append(e.getStudent().getLastName())
			.append("</td>")
			.append("<td>")
			.append(e.getCourse().getName())
			.append("</td>")
			.append("<td>")
			.append(e.getGrade())
			.append("</td>")
			.append("</tr>"); 
		}
		return sb.toString();
	}
	
	@RequestMapping(value="api/exams/{id}", method = RequestMethod.GET) 
	public String getExam(@PathVariable int id) {
		Exam exam = examService.findOne(id);
		
		return exam.toString();
	}
	
	@RequestMapping(value="api/students/{studentId}/exams", method = RequestMethod.GET) 
	public String getStudentExams(@PathVariable int studentId) {
		List<Exam> exams = examService.findByStudentId(studentId);
		
		StringBuffer sb = new StringBuffer();
		for (Exam p: exams) {
			sb.append(p).append("\n"); 
		}
		
		return sb.toString();
	}
	
	@RequestMapping(value="pages/students/{studentId}/exams", method = RequestMethod.GET) 
	public String getStudentExamsHtml(@PathVariable int studentId) {
		List<Exam> exams = examService.findByStudentId(studentId);
		
		StringBuffer sb = new StringBuffer();
		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<td>");
		sb.append("Student");
		sb.append("</td>");
		sb.append("<td>");
		sb.append("Course");
		sb.append("</td>");
		sb.append("<td>");
		sb.append("Grade");
		sb.append("</td>");
		sb.append("</tr>");
		
		for (Exam e: exams) {
			sb
			.append("<tr>")
			.append("<td>")
			.append(e.getStudent().getCardNumber())
			.append(" ")
			.append(e.getStudent().getFirstName())
			.append(" ")
			.append(e.getStudent().getLastName())
			.append("</td>")
			.append("<td>")
			.append(e.getCourse().getName())
			.append("</td>")
			.append("<td>")
			.append(e.getGrade())
			.append("</td>")
			.append("</tr>"); 
		}
		return sb.toString();
	}
}
