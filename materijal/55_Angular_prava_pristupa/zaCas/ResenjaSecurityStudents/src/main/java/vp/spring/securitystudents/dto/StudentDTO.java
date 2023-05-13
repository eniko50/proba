package vp.spring.securitystudents.dto;

import java.util.ArrayList;
import java.util.List;

import vp.spring.securitystudents.model.Student;

public class StudentDTO {
	private Long id;
	private String firstName;
	private String lastName;
	private String cardNumber;
	
	private List<ExamDTO> exams = new ArrayList<ExamDTO>();

	public StudentDTO() {

	}

	public StudentDTO(Long id, String firstName, String lastName,
			String cardNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cardNumber = cardNumber;
	}
	

	public StudentDTO(Student student) {
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.cardNumber = student.getCardNumber();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public List<ExamDTO> getExams() {
		return exams;
	}

	public void setExams(List<ExamDTO> exams) {
		this.exams = exams;
	}

	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", cardNumber=" + cardNumber + "]";
	}
}
