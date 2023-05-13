package vp.jdbc.students.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import vp.jdbc.students.model.Student;

@Component
public class StudentRepository {
	Connection conn;
	
	public StudentRepository() throws IOException {
		// ucitavanje MySQL drajvera
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// otvaranje konekcije
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db_jdbc_students", // adresa servera i
																// ime baze
					"root", "rootroot"); // username i password
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Student> findAll() {
		List<Student> retVal = new ArrayList<>(); 

		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt
				.executeQuery("select id, card_number, first_name, last_name from student");
		
		while (rset.next()) { 
			int id = rset.getInt("id");
			String cardNumber = rset.getString("card_number");
			String firstName = rset.getString("first_name");
			String lastName = rset.getString("last_name");
		
			Student student = new Student(id, firstName, lastName, cardNumber);
			retVal.add(student);	
		}
		rset.close();
		stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	public Student findOne(int id) {
		Student retVal = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"select card_number, first_name, last_name from student where id = ?");
			stmt.setInt(1, id); // na mesto prvog parametra postavljamo vrednost promenljive id
			ResultSet rset = stmt.executeQuery();
			
			if (rset.next()) { 
				String cardNumber = rset.getString("card_number");
				String firstName = rset.getString("first_name");
				String lastName = rset.getString("last_name");
			
				retVal = new Student(id, firstName, lastName, cardNumber);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	public Student save(Student student) {
		// save radi i snimanje i izmenu
		// ako prosledjeni entitet ima validan id, smatra se da je rec o izmeni
		
		// razdvojeni create i modify u dve privatne metode zbog preglednosti
		if (student.getId() > 0) {
			return modifyStudent(student);
		} else {
			return createStudent(student);
		}
	}
	
	private Student createStudent(Student student) {
		Student retVal = null; 
		
		try {
			// id je auto generisan i potrebno je da preuzmemo dobijenu vrednost
			PreparedStatement stmt = conn.prepareStatement(
					"insert into student (card_number, first_name, last_name) values (?, ?, ?)", 
					Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, student.getCardNumber());
			stmt.setString(2, student.getFirstName());
			stmt.setString(3, student.getLastName());
			
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) { // uspesno ubacen	
				// preuzmemo id koji je baza dodelila
				ResultSet keys = stmt.getGeneratedKeys();
				keys.next(); // pozicioniramo se na slog u result setu
				
				int id = keys.getInt(1); // id je u prvom i jedinom polju sloga result seta
				retVal = new Student(id, student.getFirstName(),  
						student.getLastName(), student.getCardNumber());
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	private Student modifyStudent(Student student) {
		Student retVal = null; // izmenjena drzava
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"update student set card_number = ?, first_name = ?, last_name = ? where id = ?");
			stmt.setString(1, student.getCardNumber());
			stmt.setString(2, student.getFirstName());
			stmt.setString(3, student.getLastName());
			stmt.setInt(4, student.getId());
			
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) { // uspesno izmenjen	
				retVal = student;
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}

	public void delete(int id) {
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"delete from student where id = ?");
			stmt.setInt(1, id);
			
			stmt.executeUpdate();

			stmt.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Student findByCardNumber(String cardNumber) {
		Student retVal = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"select id, first_name, last_name from student where card_number = ?");
			stmt.setString(1, cardNumber); 
			ResultSet rset = stmt.executeQuery();
			
			if (rset.next()) { 
				int id = rset.getInt("id");
				String firstName = rset.getString("first_name");
				String lastName = rset.getString("last_name");
			
				retVal = new Student(id, firstName, lastName, cardNumber);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}

	
}
