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

import vp.springdata.students.dto.StudentDTO;
import vp.springdata.students.model.Student;
import vp.springdata.students.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private StudentService studentService;

	@Test
	public void testGetStudents() {
		ResponseEntity<StudentDTO[]> responseEntity = restTemplate.getForEntity(
				"/api/students?page=0&size=2", StudentDTO[].class);

		StudentDTO[] students = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(2, students.length);
		assertEquals("Zoran", students[0].getFirstName());
		assertEquals("Zoranovic", students[0].getLastName());
		assertEquals("e44", students[0].getCardNumber());
		assertEquals("Ana", students[1].getFirstName());
		assertEquals("Krunic", students[1].getLastName());
		assertEquals("e352", students[1].getCardNumber());
	}

	@Test
	public void testGetStudent() {
		ResponseEntity<StudentDTO> responseEntity = restTemplate.getForEntity(
				"/api/students/3", StudentDTO.class);

		StudentDTO student = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertNotNull(student);
		assertEquals("Stevan", student.getFirstName());
		assertEquals("Stevic", student.getLastName());
		assertEquals("e20", student.getCardNumber());
	}

	@Test
	public void testCreateStudent() {
		int size = studentService.findAll().size(); // broj slogova pre
													// ubacivanja novog

		ResponseEntity<StudentDTO> responseEntity = restTemplate.postForEntity(
				"/api/students", new StudentDTO(null, "Milan", "Milanovic", "e90"), 
				StudentDTO.class);

		// provera odgovora servera
		StudentDTO student = responseEntity.getBody();
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertNotNull(student);
		assertEquals("Milan", student.getFirstName());
		assertEquals("Milanovic", student.getLastName());
		assertEquals("e90", student.getCardNumber());

		List<Student> students = studentService.findAll();
		System.out.println(students.size());
		assertEquals(size + 1, students.size());		
		assertEquals("Milan", students.get(students.size() - 1).getFirstName());
		assertEquals("Milanovic", students.get(students.size() - 1).getLastName());
		assertEquals("e90", students.get(students.size() - 1).getCardNumber());

		studentService.remove(student.getId());
	}

	@Test
	public void testUpdateStudent() {
		ResponseEntity<StudentDTO> responseEntity = restTemplate
				.exchange("/api/students/1", HttpMethod.PUT,
						new HttpEntity<StudentDTO>(new StudentDTO(1L, "Danilo",
								"Popovic", "e446")), StudentDTO.class);

		StudentDTO student = responseEntity.getBody();

		// provera odgovora servera
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertNotNull(student);
		assertEquals("Danilo", student.getFirstName());
		assertEquals("Popovic", student.getLastName());
		assertEquals("e446", student.getCardNumber());

		// provera da li je izmenjen slog u bazi
		Student dbStudent = studentService.findOne(1L);
		assertEquals(Long.valueOf(1L), dbStudent.getId());
		assertEquals("Danilo", dbStudent.getFirstName());
		assertEquals("Popovic", dbStudent.getLastName());
		assertEquals("e446", dbStudent.getCardNumber());

		// vracanje podatka na staru vrednost
		dbStudent.setFirstName("Zoran");
		dbStudent.setLastName("Zoranovic");
		dbStudent.setCardNumber("e44");
		studentService.save(dbStudent);
	}

	@Test
	public void testDeleteStudent() {
		Student student = studentService.save(new Student(null, "Milan", "Milanovic", "e90"));
		int size = studentService.findAll().size();

		// poziv REST servisa za brisanje
		ResponseEntity<Void> responseEntity = restTemplate.exchange(
				"/api/students/" + student.getId(), HttpMethod.DELETE,
				new HttpEntity<Object>(null), Void.class);

		// provera odgovora servera
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

		// mora biti jedan manje slog sada nego pre
		assertEquals(size - 1, studentService.findAll().size());
	}

	@Test
	public void testGetStudentByCardNumber() {
		ResponseEntity<StudentDTO> responseEntity = restTemplate.getForEntity(
				"/api/students?cardNumber=e20", StudentDTO.class);

		StudentDTO student = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("Stevan", student.getFirstName());
		assertEquals("Stevic", student.getLastName());
		assertEquals("e20", student.getCardNumber());
	}	
}
