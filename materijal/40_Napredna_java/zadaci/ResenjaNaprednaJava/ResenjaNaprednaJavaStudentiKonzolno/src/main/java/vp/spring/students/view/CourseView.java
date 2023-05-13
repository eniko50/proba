package vp.spring.students.view;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.students.model.Course;
import vp.spring.students.service.CourseService;
import vp.spring.students.util.Helper;

@Component
public class CourseView {
	@Autowired
	CourseService courseService;
	
	
	public void start()  {
		int option = 0;

		do {
			// unos opcije
			displayMenu();
			System.out.println("\nPlease choose the option: ");	
			option = Integer.parseInt(Helper.input());

			switch (option) {
			case 1:
				showCourses();
				break;
			case 2:
				findCourse();
				break;
			case 3:
				addCourse();
				break;
			case 4: 
				modifyCourse();
				break;
			case 5:
				removeCourse();
				break;
			}
		} while (option != 6);
		
		// pri napustanju menija, snimaju se podaci u fajl
		try {
			courseService.persistCourses();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void displayMenu() {
		System.out.println("1. Show all courses");
		System.out.println("2. Find course");
		System.out.println("3. Add course");
		System.out.println("4. Modify course");
		System.out.println("5. Remove course");
		System.out.println("6. Back to main menu");
	}
	
	private void showCourses() {
		List<Course> courses = courseService.findAll();
		for (Course s: courses) {
			System.out.println(s);
		}
	}
	
	private void findCourse() {
		System.out.print("Id: ");
		int id = Integer.valueOf(Helper.input());
		
		Course course = courseService.findOne(id);
		if (course != null) {
			System.out.println(course);
		}
	}
	
	private void addCourse() {
		System.out.print("id: ");
		int id = Integer.valueOf(Helper.input());
		
		System.out.print("Name: ");
		String name = Helper.input();
		
		System.out.print("Espb: ");
		int espb = Integer.valueOf(Helper.input());
		
		courseService.save(new Course(id, name, espb));
	}
	
	private void modifyCourse() {
		System.out.print("Id: ");
		int id = Integer.valueOf(Helper.input());
		Course course = courseService.findOne(id);
		
		if (course == null) {
			System.out.println("Course does not exist.");
		} else { 
			System.out.print("Name: ");
			String name = Helper.input();
			
			System.out.print("Espb: ");
			int espb = Integer.valueOf(Helper.input());
			
			courseService.save(new Course(id, name, espb));
		}
	}
	
	private void removeCourse() {
		System.out.print("Id: ");
		int id = Integer.valueOf(Helper.input());
		
		courseService.remove(id);
	}
}
