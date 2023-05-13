package vp.jpa.students.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vp.jpa.students.model.Student;
import vp.jpa.students.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping(value = "api/students", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> students = studentService.findAll();
		
		// proba preuzimanja svih studenata sa ispitima
		// trenutno ne mogu biti poslani klijentu jer su ispiti u studentu stavljeni na JsonIgnore
		// zato ovde ispis u konzolu kao provera rada metode
//		List<Student> studentsWithExams = studentService.findAllWithExams();
//		for (Student s: studentsWithExams) {
//			System.out.println("==================");
//			System.out.println(s);
//			for (Exam e: s.getExams()) {
//				System.out.println(e);
//			}
//		}

		return new ResponseEntity<>(students, HttpStatus.OK); 
	}

	@RequestMapping(value = "api/students/{id}", method = RequestMethod.GET)
	public ResponseEntity<Student> getStudent(@PathVariable Long id) {
		Student student = studentService.findOne(id);

		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	@RequestMapping(value = "api/students", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> create(@RequestBody Student student) {
		Student retVal = studentService.save(student);

		return new ResponseEntity<>(retVal, HttpStatus.CREATED);
	}

	@RequestMapping(value = "api/students/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> update(@PathVariable Long id,
			@RequestBody Student student) {
		student.setId(id);
		Student retVal = studentService.save(student);

		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}

	@RequestMapping(value = "api/students/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Student student = studentService.findOne(id);
		if (student != null) {
			studentService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "api/students", method = RequestMethod.GET, params = "cardNumber")
	public ResponseEntity<Student> getStudentsByCardNumber(
			@RequestParam String cardNumber) {
		Student student = studentService.findByCardNumber(cardNumber);

		return new ResponseEntity<>(student, HttpStatus.OK);
	}
}
