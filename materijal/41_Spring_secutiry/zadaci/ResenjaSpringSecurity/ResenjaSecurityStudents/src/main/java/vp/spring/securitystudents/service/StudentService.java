package vp.spring.securitystudents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import vp.spring.securitystudents.model.Student;
import vp.spring.securitystudents.repository.StudentRepository;

@Component
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ExamService examService;

	public List<Student> findAll() {
		return studentRepository.findAll();
	}
	
	public Page<Student> findAll(Pageable page) {
		return studentRepository.findAll(page);
	}

	public Student findOne(Long id) {
		return studentRepository.findById(id).get();
	}

	public Student save(Student student) {
		return studentRepository.save(student);
	}

	public void remove(Long id) {
		// dozvoljeno brisanje samo studenata koji nemaju ispite
		if (examService.findByStudentId(id).isEmpty()) {
			studentRepository.deleteById(id);
		}
	}

	public Student findByCardNumber(String cardNumber) {
		return studentRepository.findByCardNumber(cardNumber);
	}
}
