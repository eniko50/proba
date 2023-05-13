package vp.jdbc.places.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import vp.jdbc.places.model.Country;

/**
 * Klasa je zaduzena za evidenciju podataka o drzavama. Podaci se perzistiraju u
 * relacionoj bazi podataka i dobavljaju putem JDBC
 * 
 * @author Goran
 *
 */
@Component
public class CountryRepository {

	Connection conn; // konekcija ka bazi podataka

	public CountryRepository() {
		// ucitavanje MySQL drajvera
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// otvaranje konekcije
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/db_jdbc_places", // adresa servera i
																// ime baze
					"root", "rootroot"); // username i password
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Country> findAll() {
		List<Country> retVal = new ArrayList<>(); // lista drzava koja je
													// rezultat metode

		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt
					.executeQuery("select id, name, population from country");

			while (rset.next()) { // prolazimo kroz dobijeni rezultat
				// svaki slog je nova drzava sa podacima iz polja sloga
				int id = rset.getInt("id");
				String name = rset.getString("name");
				int population = rset.getInt("population");

				Country country = new Country(id, name, population);
				retVal.add(country);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}

	public Country findOne(int id) {
		Country retVal = null; // pronadjena drzava

		try {
			PreparedStatement stmt = conn.prepareStatement(
					"select name, population from country where id = ?");
			stmt.setInt(1, id); // na mesto prvog parametra postavljamo vrednost promenljive id
			ResultSet rset = stmt.executeQuery();
			if (rset.next()) { // ako je dobijen slog, preuzmemo podatke o drzavi
				String name = rset.getString("name");
				int population = rset.getInt("population");

				retVal = new Country(id, name, population);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}

	public Country save(Country country) {
		// save radi i snimanje i izmenu
		// ako prosledjeni entitet ima validan id, smatra se da je rec o izmeni
		
		// razdvojeni create i modify u dve privatne metode zbog preglednosti
		if (country.getId() > 0) {
			return modifyCountry(country);
		} else {
			return createCountry(country);
		}
	}
	
	private Country createCountry(Country country) {
		Country retVal = null; // snimljena drzava
		
		try {
			// id je auto generisan i potrebno je da preuzmemo dobijenu vrednost
			PreparedStatement stmt = conn.prepareStatement(
					"insert into country (name, population) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, country.getName());
			stmt.setInt(2, country.getPopulation());
			
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) { // uspesno ubacen	
				// preuzmemo id koji je baza dodelila
				ResultSet keys = stmt.getGeneratedKeys();
				keys.next(); // pozicioniramo se na slog u result setu
				
				int id = keys.getInt(1); // id je u prvom i jedinom polju sloga result seta
				retVal = new Country(id, country.getName(), country.getPopulation());
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	private Country modifyCountry(Country country) {
		Country retVal = null; // izmenjena drzava
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"update country set name = ?, population = ? where id = ?");
			stmt.setString(1, country.getName());
			stmt.setInt(2, country.getPopulation());
			stmt.setInt(3, country.getId());
			
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) { // uspesno izmenjen	
				retVal = country;
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}

	// brise drzavu sa zadatim id-om
	public void delete(int id) {
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"delete from country where id = ?");
			stmt.setInt(1, id);
			
			stmt.executeUpdate();

			stmt.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// trazi drzave sa naznacenom populacijom
	public List<Country> findByPopulation(int population) {
		List<Country> retVal = new ArrayList<>();

		try {
			PreparedStatement stmt = conn.prepareStatement(
					"select id, name from country where population = ?");
			stmt.setInt(1, population); 
			ResultSet rset = stmt.executeQuery();
			while (rset.next()) { 
				int id = rset.getInt("id");
				String name = rset.getString("name");

				retVal.add(new Country(id, name, population));
			}
			rset.close();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return retVal;
	}

	// trazi drzave ciji naziv sadrzi prosledjenu rec
	public List<Country> findByNameContains(String name) {
		List<Country> retVal = new ArrayList<>();

		try {
			PreparedStatement stmt = conn.prepareStatement(
					"select id, name, population from country where name like ?");
			stmt.setString(1, "%" + name + "%"); // dzoker znaci da bi nasao sve koje sadrze taj naziv 
			ResultSet rset = stmt.executeQuery();
			while (rset.next()) { 
				int id = rset.getInt("id");
				String countryName = rset.getString("name");
				int population = rset.getInt("population");

				retVal.add(new Country(id, countryName, population));
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}

	// trazi drzave ciji naziv sadrzi odredjenu rec ili imaju populaciju vecu od
	// zadate
	public List<Country> findByNameContainsOrPopulationGreaterThan(String name,
			int population) {
		List<Country> retVal = new ArrayList<>();

		try {
			PreparedStatement stmt = conn.prepareStatement(
					"select id, name, population from country where "
					+ "name like ? or population > ?");
			stmt.setString(1, "%" + name + "%"); // dzoker znaci da bi nasao sve koje sadrze taj naziv
			stmt.setInt(2, population);
			
			ResultSet rset = stmt.executeQuery();
			while (rset.next()) { 
				int id = rset.getInt("id");
				String countryName = rset.getString("name");
				int countryPopulation = rset.getInt("population");

				retVal.add(new Country(id, countryName, countryPopulation));
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
}
