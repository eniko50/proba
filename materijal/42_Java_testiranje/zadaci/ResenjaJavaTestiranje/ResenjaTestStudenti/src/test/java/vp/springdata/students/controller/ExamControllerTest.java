package vp.springdata.students.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

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
import vp.springdata.students.dto.ExamDTO;
import vp.springdata.students.dto.StudentDTO;
import vp.springdata.students.model.Course;
import vp.springdata.students.model.Exam;
import vp.springdata.students.model.Student;
import vp.springdata.students.service.ExamService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ExamControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private ExamService examService;

	@Test
	public void testGetExams() {
		ResponseEntity<ExamDTO[]> responseEntity = restTemplate.getForEntity(
				"/api/exams?page=0&size=2", ExamDTO[].class);

		ExamDTO[] exams = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(2, exams.length);
		assertEquals("e44", exams[0].getStudent().getCardNumber());
		assertEquals("Web programiranje", exams[0].getCourse().getName());
		assertEquals(8, exams[0].getGrade());
		assertEquals("e44", exams[1].getStudent().getCardNumber());
		assertEquals("Testiranje softvera", exams[1].getCourse().getName());
		assertEquals(7, exams[1].getGrade());
	}

	@Test
	public void testGetExam() {
		ResponseEntity<ExamDTO> responseEntity = restTemplate.getForEntity(
				"/api/exams/3", ExamDTO.class);

		ExamDTO exam = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertNotNull(exam);
		assertEquals("e352", exam.getStudent().getCardNumber());
		assertEquals("Algebra", exam.getCourse().getName());
		assertEquals(10, exam.getGrade());
	}

	@Test
	public void testCreateExam() {
		int size = examService.findAll().size(); // broj slogova pre
													// ubacivanja novog

		ResponseEntity<ExamDTO> responseEntity = restTemplate.postForEntity(
				"/api/exams", new ExamDTO(null, new StudentDTO(1L, "Zoran", "Zoranovic", "e44"),
						new CourseDTO(3L, "Algebra", 8), 9), ExamDTO.class); 

		// provera odgovora servera
		ExamDTO exam = responseEntity.getBody();
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertNotNull(exam);
		assertEquals(Long.valueOf(1L), exam.getStudent().getId());
		assertEquals(Long.valueOf(3L), exam.getCourse().getId());
		assertEquals(9, exam.getGrade());

		List<Exam> exams = examService.findAll();
		System.out.println(exams.size());
		assertEquals(size + 1, exams.size());
		assertEquals("e44", exams.get(exams.size()-1).getStudent().getCardNumber());
		assertEquals("Algebra", exams.get(exams.size()-1).getCourse().getName());
		assertEquals(9, exams.get(exams.size()-1).getGrade());
		
		examService.remove(exam.getId());
	}

	@Test
	public void testDeleteExam() {
		Exam exam = examService.save(new Exam(null, new Student(1L, "Zoran", "Zoranovic", "e44"),
				new Course(3L, "Algebra", 8), 9));
		int size = examService.findAll().size();

		// poziv REST servisa za brisanje
		ResponseEntity<Void> responseEntity = restTemplate.exchange(
				"/api/exams/" + exam.getId(), HttpMethod.DELETE,
				new HttpEntity<Object>(null), Void.class);

		// provera odgovora servera
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

		// mora biti jedan manje slog sada nego pre
		assertEquals(size - 1, examService.findAll().size());
	}
	
	@Test
	public void testFindStudentExams() {
		ResponseEntity<ExamDTO[]> responseEntity = restTemplate.getForEntity(
				"/api/students/1/exams?page=0&size=2", ExamDTO[].class);
		
		ExamDTO[] exams = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(2, exams.length);
		assertEquals("e44", exams[0].getStudent().getCardNumber());
		assertEquals("Web programiranje", exams[0].getCourse().getName());
		assertEquals(8, exams[0].getGrade());
		assertEquals("e44", exams[1].getStudent().getCardNumber());
		assertEquals("Testiranje softvera", exams[1].getCourse().getName());
		assertEquals(7, exams[1].getGrade());
	}
	
	@Test
	public void testFindStudentAvgGrade() {
		ResponseEntity<Double> responseEntity = restTemplate.getForEntity(
				"/api/students/1/exams/avg", Double.class);

		double avg = responseEntity.getBody();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		// poslednji parametar je tolerancija greske. Koliko se dva decimalna broja mogu razlikovati
		// da bismo ih smatrali jednakim. Ovde je tolerancija stavljena na 0, sto znaci da moraju biti
		// potpuno isti
		assertEquals(7.5, avg, 0); 
	}
}
