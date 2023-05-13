package vp.spring.reststudents.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.reststudents.model.Student;
import vp.spring.reststudents.repository.StudentRepository;

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

	public Student save(Student student) {
		studentRepository.save(student);
		// snimanje u fajl pri svakoj izmeni
		try {
			persistStudents();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return student;
	}

	public void remove(int id) {
		// dozvoljeno brisanje samo studenata koji nemaju ispite
		if (examService.findByStudentId(id).isEmpty()) {
			studentRepository.delete(id);
		}
		// snimanje u fajl pri svakoj izmeni
		try {
			persistStudents();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Student findByCardNumber(String cardNumber) {
		return studentRepository.findByCardNumber(cardNumber);
	}
	
	public void persistStudents() throws IOException {
		studentRepository.saveToFile();
	}
}
