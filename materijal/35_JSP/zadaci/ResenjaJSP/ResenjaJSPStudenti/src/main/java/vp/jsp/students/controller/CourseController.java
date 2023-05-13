package vp.jsp.students.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vp.jsp.students.model.Course;
import vp.jsp.students.service.CourseService;

@Controller
public class CourseController {
	@Autowired
	CourseService courseService;
		
	@RequestMapping(value="/courses") 
	public String getAllCourses(Map<String, Object> model) {
		List<Course> courses = courseService.findAll(); 
		model.put("courses", courses); 		
		return "courses"; // upucivanje na stranicu courses.jsp
	}
	
	@RequestMapping(value="/addCoursePage")
	public String redirectToAddCoursePage() {
		return "addCourse";
	}
	
	// istu metodu koristimo i za dodavanje i za izmenu kurseva
	@RequestMapping(value="/courses/save", method=RequestMethod.POST)
	public String saveCourse(HttpServletRequest request) {
		int id = Integer.valueOf(request.getParameter("id"));
		String name = request.getParameter("name");
		int espb = Integer.valueOf(request.getParameter("espb"));
		
		Course course = new Course(id, name, espb);
		courseService.save(course);
		
		return "redirect:/courses";  
	}
	
	@RequestMapping(value="/courses/remove", method=RequestMethod.GET)
	public String removeCourse(HttpServletRequest request) {
		// parametar zahteva je id drzave koju brisemo
		String id = request.getParameter("id");
		// brisanje drzave
		courseService.remove(Integer.valueOf(id));
		
		// redirekcija na url /countries sto poziva metodu getAllCountries,
		// koja ce inicirati prikaz stranice countries.jsp
		return "redirect:/courses";  
	}
	
	@RequestMapping(value="/modifyCoursePage")
	public String redirectToModifyCoursePage(HttpServletRequest request, Map<String, Object> model) {
		String id = request.getParameter("id");
		Course course = courseService.findOne(Integer.valueOf(id));
		model.put("course", course);
		return "addCourse";
	}
}