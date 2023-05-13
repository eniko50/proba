package vp.spring.JdbcCountry.data;

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

import vp.spring.JdbcCountry.model.Country;
import vp.spring.JdbcCountry.model.Place;

/**
 * Klasa je zaduzena za evidenciju podataka o mestima. Zbog jednostavnosti,
 * podaci se skladiste u radnoj memoriji bez perzistiranja u bazi podataka
 * 
 * @author Goran
 *
 */
@Component
public class PlaceRepository {
	
	@Autowired
	private CountryRepository countryRepository;

	private Connection connection;

	public PlaceRepository() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/dbcountry",
					"root",
					"root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Place> findAll() {
		List<Place> places = new ArrayList<>();

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement
					.executeQuery("select id, name, zip_code, country_id from city");

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String zipCode = resultSet.getString("zip_code");
				int countryId = resultSet.getInt("country_id");
				
				Country country = countryRepository.findOne(countryId);
				
				Place place = new Place(id, zipCode, name, country);
				places.add(place);
			}

			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return places;
	}

	public Place findOne(int id) {
		Place place = null;
		
		try {
			PreparedStatement statement = connection
					.prepareStatement("select * from city where id = ?");
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				String name = resultSet.getString("name");
				String zipCode = resultSet.getString("zip_code");
				int countryId = resultSet.getInt("country_id");

				Country country = countryRepository.findOne(countryId);
				
				place = new Place(id, zipCode, name, country);
			}
			
			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return place;
	}

	public Place save(Place place) {
		if (place.getId() == 0) {
			return create(place);
		}
		
		return null;
	}
	
	private Place create(Place place) {
		Place retVal = null;
		try {
			PreparedStatement statement = connection.prepareStatement(
					"insert into city (name, zip_code, country_id) values "
					+ "(?, ?, ?)");
			statement.setString(1, place.getName());
			statement.setString(2, place.getZipCode());
			statement.setInt(3, place.getCountry().getId());
			
			int rowsEffected = statement.executeUpdate();
			if (rowsEffected > 0) {
				ResultSet keys = statement.getGeneratedKeys();
				keys.next();
				int id = keys.getInt(1);
				
				place.setId(id);
				retVal = place;
				keys.close();
			}
			
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return retVal;
	}

	public void delete(int id) {

	}

	public List<Place> findByNameContains(String name) {
		return null;
	}

	public List<Place> findByCountryId(int id) {
		return null;
	}
}
