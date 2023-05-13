package vp.jdbc.places.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.jdbc.places.model.Country;
import vp.jdbc.places.model.Place;

@Component
public class PlaceRepository {

	Connection conn; // konekcija ka bazi podataka
	
	@Autowired
	CountryRepository countryRepository;

	public PlaceRepository() {
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

	public List<Place> findAll() {
		List<Place> retVal = new ArrayList<>(); 

		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt
					.executeQuery("select place.id, place.zip_code, place.name, country.id, country.name, "
							+ "country.population from place left join country "
							+ "on place.country_id = country.id");

			while (rset.next()) { 
				int placeId = rset.getInt(1);
				int zipCode = rset.getInt(2);
				String placeName = rset.getString(3);
				int countryId = rset.getInt(4);
				String countryName = rset.getString(5);
				int population = rset.getInt(6);
				
				Country country = new Country(countryId, countryName, population);
				Place place = new Place(placeId, zipCode, placeName, country);
				retVal.add(place);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}

	public Place findOne(int id) {
		Place retVal = null; 

		try {
			PreparedStatement stmt = conn.prepareStatement(
					"select place.id, place.zip_code, place.name, country.id, country.name, "
							+ "country.population from place left join country "
							+ "on place.country_id = country.id where place.id = ?");
			stmt.setInt(1, id); // na mesto prvog parametra postavljamo vrednost promenljive id
			ResultSet rset = stmt.executeQuery();
			if (rset.next()) { // ako je dobijen slog, preuzmemo podatke o mestu
				int placeId = rset.getInt(1);
				int zipCode = rset.getInt(2);
				String placeName = rset.getString(3);
				int countryId = rset.getInt(4);
				String countryName = rset.getString(5);
				int population = rset.getInt(6);
				
				Country country = new Country(countryId, countryName, population);
				retVal = new Place(placeId, zipCode, placeName, country);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}

	public Place save(Place place) {
		// save radi i snimanje i izmenu
		// ako prosledjeni entitet ima validan id, smatra se da je rec o izmeni
		
		// razdvojeni create i modify u dve privatne metode zbog preglednosti
		if (place.getId() > 0) {
			return modifyPlace(place);
		} else {
			return createPlace(place);
		}
	}
	
	private Place createPlace(Place place) {
		Place retVal = null; // snimljeno mesto
		
		try {
			// id je auto generisan i potrebno je da preuzmemo dobijenu vrednost
			PreparedStatement stmt = conn.prepareStatement(
					"insert into place (zip_code, name, country_id) values (?, ?, ?)", 
					Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, place.getZipCode());
			stmt.setString(2, place.getName());
			stmt.setInt(3, place.getCountry().getId());
			
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) { // uspesno ubacen	
				// preuzmemo id koji je baza dodelila
				ResultSet keys = stmt.getGeneratedKeys();
				keys.next(); // pozicioniramo se na slog u result setu
				
				int id = keys.getInt(1); // id je u prvom i jedinom polju sloga result seta
				
				// u mesto ubacimo drzavu preuzetu iz baze na osnovu id-a
				retVal = new Place(id, place.getZipCode(), place.getName(), 
						countryRepository.findOne(place.getCountry().getId()));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	private Place modifyPlace(Place place) {
		Place retVal = null; // izmenjeno mesto
		try {
			PreparedStatement stmt = conn.prepareStatement(
					"update place set zip_code = ?, name = ?, country_id = ? where id = ?");
			stmt.setInt(1, place.getZipCode());
			stmt.setString(2, place.getName());
			stmt.setInt(3, place.getCountry().getId());
			stmt.setInt(4,  place.getId());
			
			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) { // uspesno izmenjen	
				retVal = place;
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
					"delete from place where id = ?");
			stmt.setInt(1, id);
			
			stmt.executeUpdate();

			stmt.close();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// trazi mesta ciji naziv sadrzi prosledjenu rec
	public List<Place> findByNameContains(String name) {
		List<Place> retVal = new ArrayList<>();

		try {
			PreparedStatement stmt = conn.prepareStatement(
					"select place.id, place.zip_code, place.name, country.id, country.name, "
				+ "country.population from place left join country "
				+ "on place.country_id = country.id where place.name like ?");
			stmt.setString(1, "%" + name + "%"); // dzoker znaci da bi nasao sve koje sadrze taj naziv 
			ResultSet rset = stmt.executeQuery();
			while (rset.next()) { 
				int placeId = rset.getInt(1);
				int zipCode = rset.getInt(2);
				String placeName = rset.getString(3);
				int countryId = rset.getInt(4);
				String countryName = rset.getString(5);
				int population = rset.getInt(6);
				
				Country country = new Country(countryId, countryName, population);
				Place place = new Place(placeId, zipCode, placeName, country);
				retVal.add(place);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}

	// trazi mesta u odredjenoj drzavi
	public List<Place> findByCountryId(int countryId) {
		List<Place> retVal = new ArrayList<>();

		try {
			PreparedStatement stmt = conn.prepareStatement(
					"select place.id, place.zip_code, place.name, country.id, country.name, "
				+ "country.population from place left join country "
				+ "on place.country_id = country.id where country.id = ?");
			stmt.setInt(1, countryId);  
			ResultSet rset = stmt.executeQuery();
			while (rset.next()) { 
				int placeId = rset.getInt(1);
				int zipCode = rset.getInt(2);
				String placeName = rset.getString(3);
				String countryName = rset.getString(5);
				int population = rset.getInt(6);
				
				Country country = new Country(countryId, countryName, population);
				Place place = new Place(placeId, zipCode, placeName, country);
				retVal.add(place);
			}
			rset.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
}
