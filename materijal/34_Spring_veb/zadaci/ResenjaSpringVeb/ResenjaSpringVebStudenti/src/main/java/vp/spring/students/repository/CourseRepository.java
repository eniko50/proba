package vp.spring.students.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import vp.spring.students.model.Course;

@Component
public class CourseRepository {
	private List<Course> courses;
	
	public CourseRepository() throws IOException {
		// ucitavamo predmete iz fajla pri instanciranju repozitorijuma
		BufferedReader inputStream = new BufferedReader(new FileReader("data/courses.txt"));
		courses = new ArrayList<Course>();

        String line;
		while ((line = inputStream.readLine()) != null) {
			String[] data = line.split(",");
			int id = Integer.valueOf(data[0]);
			String name = data[1];
			int espb = Integer.valueOf(data[2]);
			
			Course course = new Course(id, name, espb);
			
			courses.add(course);
		} 
		inputStream.close();
	}
	
	public List<Course> findAll() {
		return courses;
	}
	
	public Course findOne(int id) {
		for (Course course: courses) {
			if (course.getId() == id) {
				return course;
			}
		}
		return null;
	}
	
	public void save(Course course) {
		// save radi i snimanje i izmenu
		// ako prosledjeni entitet vec postoji u listi, onda je rec o izmeni
		Course existingCourse = findOne(course.getId());
		if (existingCourse == null) {
			courses.add(course);
		} else { 
			existingCourse.setName(course.getName());
			existingCourse.setEspb(course.getEspb());
		}
	}
	
	public void delete(int id) {		
		Iterator<Course> it = courses.iterator();
		while (it.hasNext()) {
			if (it.next().getId() == id) {
				it.remove();
				return;
			}
		}			
	}
	
	public void saveToFile() throws IOException  {
		PrintWriter stream = new PrintWriter(new FileWriter("data/courses.txt"));

		for (Course course : courses) {
			stream.println(course.getId() + "," + course.getName() + "," + 
					course.getEspb());				
		}
		stream.close();
	}
}
