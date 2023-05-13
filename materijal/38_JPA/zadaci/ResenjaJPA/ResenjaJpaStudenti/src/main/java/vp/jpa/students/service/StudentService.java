package vp.jpa.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.jpa.students.model.Student;
import vp.jpa.students.repository.StudentRepository;

@Component
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ExamService examService;

	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	public Student findOne(Long id) {
		return studentRepository.findOne(id);
	}

	public Student save(Student student) {
		return studentRepository.save(student);
	}

	public void remove(Long id) {
		// dozvoljeno brisanje samo studenata koji nemaju ispite
		if (examService.findByStudentId(id).isEmpty()) {
			studentRepository.delete(id);
		}
	}

	public Student findByCardNumber(String cardNumber) {
		return studentRepository.findByCardNumber(cardNumber);
	}
	
	public List<Student> findAllWithExams() {
		return studentRepository.findAllWithExams();
	}
}
