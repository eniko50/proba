package vp.springdata.students.controller;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import vp.springdata.students.dto.CourseDTO;
import vp.springdata.students.model.Course;
import vp.springdata.students.service.CourseService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CourseControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private CourseService courseService;

	@Test
	public void testGetCourses() {
		ResponseEntity<CourseDTO[]> responseEntity = restTemplate.getForEntity(
				"/api/courses?page=0&size=2", CourseDTO[].class);

		CourseDTO[] courses = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(2, courses.length);
		assertEquals("Web programiranje", courses[0].getName());
		assertEquals(6, courses[0].getEspb());
		assertEquals("Testiranje softvera", courses[1].getName());
		assertEquals(4, courses[1].getEspb());
	}

	@Test
	public void testGetCourse() {
		ResponseEntity<CourseDTO> responseEntity = restTemplate.getForEntity(
				"/api/courses/3", CourseDTO.class);

		CourseDTO course = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertNotNull(course);
		assertEquals("Algebra", course.getName());
		assertEquals(8, course.getEspb());
	}

	@Test
	public void testCreateCourse() {
		int size = courseService.findAll().size(); // broj slogova pre
													// ubacivanja novog

		ResponseEntity<CourseDTO> responseEntity = restTemplate.postForEntity(
				"/api/courses", new CourseDTO(null, "Matematika", 6),
				CourseDTO.class);

		// provera odgovora servera
		CourseDTO course = responseEntity.getBody();
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertNotNull(course);
		assertEquals("Matematika", course.getName());
		assertEquals(6, course.getEspb());

		List<Course> courses = courseService.findAll();
		System.out.println(courses.size());
		assertEquals(size + 1, courses.size());		
		assertEquals("Matematika", courses.get(courses.size() - 1).getName());
		assertEquals(6, courses.get(courses.size() - 1)
				.getEspb());

		courseService.remove(course.getId());
	}

	@Test
	public void testUpdateCourse() {
		ResponseEntity<CourseDTO> responseEntity = restTemplate
				.exchange("/api/courses/1", HttpMethod.PUT,
						new HttpEntity<CourseDTO>(new CourseDTO(1L, "Web programiranje",
								7)), CourseDTO.class);

		CourseDTO course = responseEntity.getBody();

		// provera odgovora servera
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertNotNull(course);
		assertEquals(Long.valueOf(1L), course.getId());
		assertEquals("Web programiranje", course.getName());
		assertEquals(7, course.getEspb());

		// provera da li je izmenjen slog u bazi
		Course dbCourse = courseService.findOne(1L);
		assertEquals(Long.valueOf(1L), dbCourse.getId());
		assertEquals("Web programiranje", dbCourse.getName());
		assertEquals(7, dbCourse.getEspb());

		// vracanje podatka na staru vrednost
		dbCourse.setEspb(6);
		courseService.save(dbCourse);
	}

	@Test
	public void testDeleteCourse() {
		Course course = courseService.save(new Course(null, "Matematika", 6));
		int size = courseService.findAll().size();

		// poziv REST servisa za brisanje
		ResponseEntity<Void> responseEntity = restTemplate.exchange(
				"/api/courses/" + course.getId(), HttpMethod.DELETE,
				new HttpEntity<Object>(null), Void.class);

		// provera odgovora servera
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

		// mora biti jedan manje slog sada nego pre
		assertEquals(size - 1, courseService.findAll().size());
	}

	@Test
	public void testGetCoursesByExamCount() {
		ResponseEntity<CourseDTO[]> responseEntity = restTemplate.getForEntity(
				"/api/courses?sortByExamCount=true&page=0&size=2", CourseDTO[].class);

		CourseDTO[] courses = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(2, courses.length);
		assertEquals("Testiranje softvera", courses[0].getName());
		assertEquals(4, courses[0].getEspb());
		assertEquals("Algoritmi i strukture podataka", courses[1].getName());
		assertEquals(6, courses[1].getEspb());
	}	
}
