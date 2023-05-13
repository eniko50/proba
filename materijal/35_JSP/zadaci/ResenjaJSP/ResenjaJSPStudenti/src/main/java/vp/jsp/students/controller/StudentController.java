package vp.jsp.students.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vp.jsp.students.model.Student;
import vp.jsp.students.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@RequestMapping(value="/", method = RequestMethod.GET) 
	public String getAllStudents() {
		// home.jsp je osnovna stranica
		return "home";
	}
	
	@RequestMapping(value="/students") 
	public String getAllStudents(Map<String, Object> model) {
		List<Student> students = studentService.findAll(); 
		model.put("students", students); 		
		return "students"; // upucivanje na stranicu students.jsp
	}
	
	@RequestMapping(value="/addStudentPage")
	public String redirectToAddStudentPage() {
		return "addStudent";
	}
	
	// istu metodu koristimo i za dodavanje i za izmenu studenta
	@RequestMapping(value="/students/save", method=RequestMethod.POST)
	public String saveStudent(HttpServletRequest request) {
		int id = Integer.valueOf(request.getParameter("id"));
		String cardNumber = request.getParameter("cardNumber");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		Student student = new Student(id, firstName, lastName, cardNumber);
		studentService.save(student);
		
		return "redirect:/students";  
	}
	
	@RequestMapping(value="/students/remove", method=RequestMethod.GET)
	public String removeStudent(HttpServletRequest request) {
		// parametar zahteva je id drzave koju brisemo
		String id = request.getParameter("id");
		// brisanje drzave
		studentService.remove(Integer.valueOf(id));
		
		// redirekcija na url /countries sto poziva metodu getAllCountries,
		// koja ce inicirati prikaz stranice countries.jsp
		return "redirect:/students";  
	}
	
	@RequestMapping(value="/modifyStudentPage")
	public String redirectToModifyStudentPage(HttpServletRequest request, Map<String, Object> model) {
		String id = request.getParameter("id");
		Student student = studentService.findOne(Integer.valueOf(id));
		model.put("student", student);
		return "addStudent";
	}
}