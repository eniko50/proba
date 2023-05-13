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
import org.springframework.web.bind.annotation.RestController;

import vp.jpa.students.model.Exam;
import vp.jpa.students.service.ExamService;

@RestController
public class ExamController {
	@Autowired
	ExamService examService;

	@RequestMapping(value = "api/exams", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<Exam>> getAllExams() {
		List<Exam> exams = examService.findAll();

		return new ResponseEntity<>(exams, HttpStatus.OK); 
	}

	@RequestMapping(value = "api/exams/{id}", method = RequestMethod.GET)
	public ResponseEntity<Exam> getExam(@PathVariable Long id) {
		Exam exam = examService.findOne(id);

		return new ResponseEntity<>(exam, HttpStatus.OK);
	}

	@RequestMapping(value = "api/exams", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Exam> create(@RequestBody Exam exam) {
		Exam retVal = examService.save(exam);

		return new ResponseEntity<>(retVal, HttpStatus.CREATED);
	}

	@RequestMapping(value = "api/exams/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		Exam exam = examService.findOne(id);
		if (exam != null) {
			examService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "api/students/{studentId}/exams", method = RequestMethod.GET)
	public ResponseEntity<List<Exam>> findStudentExams(@PathVariable Long studentId) {
		List<Exam> exams = examService.findByStudentId(studentId);
		
		return new ResponseEntity<>(exams, HttpStatus.OK); 
	}
	
	@RequestMapping(value = "api/students/{studentId}/exams/avg", method = RequestMethod.GET)
	public ResponseEntity<Double> findStudentAvgGrade(@PathVariable Long studentId) {
		double avgGrade = examService.findStudentAvgGrade(studentId);
		
		return new ResponseEntity<>(avgGrade, HttpStatus.OK); 
	}
}
