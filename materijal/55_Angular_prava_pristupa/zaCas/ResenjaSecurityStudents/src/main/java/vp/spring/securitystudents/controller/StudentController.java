package vp.spring.securitystudents.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.securitystudents.dto.ExamDTO;
import vp.spring.securitystudents.dto.StudentDTO;
import vp.spring.securitystudents.model.Exam;
import vp.spring.securitystudents.model.Student;
import vp.spring.securitystudents.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping(value = "api/students", method = RequestMethod.GET)
	public ResponseEntity<List<StudentDTO>> getStudentsPage(Pageable page) {
		Page<Student> students = studentService.findAll(page);
		
		List<StudentDTO> retVal = new ArrayList<>();
		for (Student s: students) {
			retVal.add(new StudentDTO(s));
		}
		
		return new ResponseEntity<>(retVal, HttpStatus.OK); 
	}
	
	@RequestMapping(value = "api/students", method = RequestMethod.GET, params = "withExams")
	public ResponseEntity<List<StudentDTO>> getStudentsPageWithExams(Pageable page, 
			@RequestParam boolean withExams) {
		Page<Student> students = studentService.findAll(page);
		
		List<StudentDTO> retVal = new ArrayList<>();
		for (Student s: students) {
			StudentDTO studentDTO = new StudentDTO(s);
			if (withExams) {
				for (Exam e: s.getExams()) {
					studentDTO.getExams().add(new ExamDTO(e));
				}
			}
			retVal.add(studentDTO);
		}
		
		return new ResponseEntity<>(retVal, HttpStatus.OK); 
	}
	

	@RequestMapping(value = "api/students/{id}", method = RequestMethod.GET)
	public ResponseEntity<StudentDTO> getStudent(@PathVariable Long id) {
		Student student = studentService.findOne(id);

		if (student != null) {
			StudentDTO studentDTO = new StudentDTO(student);
			return new ResponseEntity<>(studentDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "api/students", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentDTO> create(@RequestBody StudentDTO studentDTO) {
		Student student = new Student();
		student.setCardNumber(studentDTO.getCardNumber());
		student.setFirstName(studentDTO.getFirstName());
		student.setLastName(studentDTO.getLastName());
		
		student = studentService.save(student);

		return new ResponseEntity<>(new StudentDTO(student), HttpStatus.CREATED);
	}

	@RequestMapping(value = "api/students/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentDTO> update(@PathVariable Long id,
			@RequestBody StudentDTO studentDTO) {
		Student student = studentService.findOne(id);
		
		if (student == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		student.setId(id);
		student.setCardNumber(studentDTO.getCardNumber());
		student.setFirstName(studentDTO.getFirstName());
		student.setLastName(studentDTO.getLastName());
		
		student= studentService.save(student);

		return new ResponseEntity<>(new StudentDTO(student), HttpStatus.OK);
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
	public ResponseEntity<StudentDTO> getStudentsByCardNumber(
			@RequestParam String cardNumber) {
		Student student = studentService.findByCardNumber(cardNumber);

		return new ResponseEntity<>(new StudentDTO(student), HttpStatus.OK);
	}
}
