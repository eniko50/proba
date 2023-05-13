package vp.spring.students.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.students.model.Student;
import vp.spring.students.repository.StudentRepository;

@Component
public class StudentService {
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	ExamService examService;

	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	public Student findOne(int id) {
		return studentRepository.findOne(id);
	}

	public void save(Student student) {
		studentRepository.save(student);
	}

	public void remove(int id) {
		// only students with no exams can be deleted
		if (examService.findByStudentId(id).isEmpty()) {
			studentRepository.delete(id);
		}
	}

	public Student findByCardNumber(String cardNumber) {
		return studentRepository.findByCardNumber(cardNumber);
	}
	
	public void persistStudents() throws IOException {
		studentRepository.saveToFile();
	}
}
