package vp.jsp.students.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vp.jsp.students.model.Course;
import vp.jsp.students.model.Exam;
import vp.jsp.students.model.Student;
import vp.jsp.students.service.CourseService;
import vp.jsp.students.service.ExamService;
import vp.jsp.students.service.StudentService;

@Controller
public class ExamController {
	@Autowired
	StudentService studentService;
	
	@Autowired
	CourseService courseService;
	
	@Autowired
	ExamService examService;
	
	@RequestMapping(value="/examsPage")
	public String redirectToExamsPage(HttpServletRequest request, Map<String, Object> model) {
		String studentId = request.getParameter("studentId");
		Student student = studentService.findOne(Integer.valueOf(studentId));
		model.put("student", student);
		
		List<Exam> exams = examService.findByStudentId(Integer.valueOf(studentId));
		
		model.put("exams", exams);
		
		// prikaz JSP stranice studentExams.jsp
		return "studentExams";
	}
	
	@RequestMapping(value="/addExamPage")
	public String redirectToAddExamPage(HttpServletRequest request, Map<String, Object> model) {
		String studentId = request.getParameter("studentId");
		Student student = studentService.findOne(Integer.valueOf(studentId));
		model.put("student", student);
		
		// JSP stranici treba spisak svih kurseva da prikaze kako bi korisnik izabrao kurs koji zeli
		List<Course> courses = courseService.findAll();
		model.put("courses", courses);
		
		return "addExam";
	}
	
	@RequestMapping(value="/exams/add", method=RequestMethod.POST)
	public String addExam(HttpServletRequest request) {
		int studentId = Integer.valueOf(request.getParameter("studentId"));
		int courseId = Integer.valueOf(request.getParameter("courseId"));
		int grade = Integer.valueOf(request.getParameter("grade"));
		
		Student student = studentService.findOne(studentId);
		Course course = courseService.findOne(courseId);
		
		Exam exam = new Exam(-1, student, course, grade); 
		examService.save(exam);
		
		return "redirect:/examsPage?studentId=" + studentId;  
	}
	
	@RequestMapping(value="/exams/remove", method=RequestMethod.GET)
	public String removeExam(HttpServletRequest request) {
		int id = Integer.valueOf(request.getParameter("id"));
		
		Exam exam = examService.findOne(id);
		int studentId = exam.getStudent().getId();
		
		// brisemo mesto
		examService.remove(id);
		
		return "redirect:/examsPage?studentId=" + studentId;  
	}
}
