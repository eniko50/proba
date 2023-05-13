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

import vp.jdbc.students.model.Course;

@Component
public class CourseRepository {
	Connection conn;
	
	public CourseRepository() throws IOException {
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
	
	public List<Course> findAll() {
		List<Course> retVal = new ArrayList<>(); 

		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt
				.executeQuery("select id, name, espb from course");
		
		while (rset.next()) { 
			int id = rset.getInt("id");
			String name = rset.getString("name");
			int espb = rset.getInt("espb");
		
			Course course = new Course(id, name, espb);
			retVal.add(course);	
		}
		rset.close();
		stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	public Course findOne(int id) {
		Course retVal = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"select name, espb from course where id = ?");
			stmt.setInt(1, id); // na mesto prvog parametra postavljamo vrednost promenljive id
			ResultSet rset = stmt.executeQuery();
			
			if (rset.next()) { 
				String name = rset.getString("name");
				int espb = rset.getInt("espb");
						
				retVal = new Course(id, name, espb);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	public Course save(Course course) {
		// save radi i snimanje i izmenu
		// ako prosledjeni entitet ima validan id, smatra se da je rec o izmeni
		
		// razdvojeni create i modify u dve privatne metode zbog preglednosti
		if (course.getId() > 0) {
			return modifyCourse(course);
		} else {
			return createCourse(course);
		}
	}
	
	private Course createCourse(Course course) {
		Course retVal = null; 
		
		try {
			// id je auto generisan i potrebno je da preuzmemo dobijenu vrednost
			PreparedStatement stmt = conn.prepareStatement(
					"insert into course (name, espb) values (?, ?)", 
					Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, course.getName());
			stmt.setInt(2, course.getEspb());
			
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) { // uspesno ubacen	
				// preuzmemo id koji je baza dodelila
				ResultSet keys = stmt.getGeneratedKeys();
				keys.next(); // pozicioniramo se na slog u result setu
				
				int id = keys.getInt(1); // id je u prvom i jedinom polju sloga result seta
				retVal = new Course(id, course.getName(), course.getEspb());
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	private Course modifyCourse(Course course) {
		Course retVal = null; // izmenjena drzava
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"update course set name = ?, espb = ? where id = ?");
			stmt.setString(1, course.getName());
			stmt.setInt(2, course.getEspb());
			stmt.setInt(3, course.getId());
			
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) { // uspesno izmenjen	
				retVal = course;
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
					"delete from course where id = ?");
			stmt.setInt(1, id);
			
			stmt.executeUpdate();

			stmt.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
