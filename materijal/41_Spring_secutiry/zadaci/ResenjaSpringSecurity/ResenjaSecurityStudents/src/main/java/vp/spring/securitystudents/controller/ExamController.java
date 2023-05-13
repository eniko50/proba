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
import org.springframework.web.bind.annotation.RestController;

import vp.spring.securitystudents.dto.ExamDTO;
import vp.spring.securitystudents.model.Course;
import vp.spring.securitystudents.model.Exam;
import vp.spring.securitystudents.model.Student;
import vp.spring.securitystudents.service.ExamService;

@RestController
public class ExamController {
	@Autowired
	ExamService examService;

	@RequestMapping(value = "api/exams", method = RequestMethod.GET)
	public ResponseEntity<List<ExamDTO>> getExamsPage(Pageable page) {
		Page<Exam> exams = examService.findAll(page);

		List<ExamDTO> retVal = new ArrayList<>();
		
		for (Exam e: exams) {
			retVal.add(new ExamDTO(e));
		}
		
		return new ResponseEntity<>(retVal, HttpStatus.OK); 
	}

	@RequestMapping(value = "api/exams/{id}", method = RequestMethod.GET)
	public ResponseEntity<ExamDTO> getExam(@PathVariable Long id) {
		Exam exam = examService.findOne(id);

		if (exam != null) {
			ExamDTO examDTO = new ExamDTO(exam);
			return new ResponseEntity<>(examDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "api/exams", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ExamDTO> create(@RequestBody ExamDTO examDTO) {
		Exam exam = new Exam();
		exam.setGrade(examDTO.getGrade());
		exam.setStudent(new Student(examDTO.getStudent().getId(), null, null, null));
		exam.setCourse(new Course(examDTO.getCourse().getId(), null, 0));
		
		exam = examService.save(exam);

		return new ResponseEntity<>(new ExamDTO(exam), HttpStatus.CREATED);
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
	public ResponseEntity<List<ExamDTO>> findStudentExams(@PathVariable Long studentId, Pageable page) {
		Page<Exam> exams = examService.findByStudentId(studentId, page);
		
		List<ExamDTO> retVal = new ArrayList<>();
		
		for (Exam e: exams) {
			retVal.add(new ExamDTO(e));
		}
		
		return new ResponseEntity<>(retVal, HttpStatus.OK); 
	}
	
	@RequestMapping(value = "api/students/{studentId}/exams/avg", method = RequestMethod.GET)
	public ResponseEntity<Double> findStudentAvgGrade(@PathVariable Long studentId) {
		double avgGrade = examService.findStudentAvgGrade(studentId);
		
		return new ResponseEntity<>(avgGrade, HttpStatus.OK); 
	}
}
