package vp.spring.country.authorization;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Klasa zaduzena za prijavu na aplikaciju.
 * 
 * @author Goran
 *
 */
@Component
public class AuthorizationManager {
	private List<User> users = new ArrayList<>();
	
	private User loggedUser; // trenutno ulogovani korisnik
	
	public AuthorizationManager() {
		// korisnici su predefinisani i inicijalizuju se pri konstruisanju objekta
		users.add(new User("marko", "12345", "admin"));
		users.add(new User("petar", "xyz", "radnik"));
		users.add(new User("milan", "abc", "radnik"));		
	}
	
	// metoda pokusava da prijavi korisnika i vraca true ako uspe	
	public boolean login(String username, String password) {
		// trazimo korisnika sa zadatim korisnickim imenom i lozinkom
		for (User user: users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				loggedUser = user; // upamtimo trenutno ulogovanog korisnika
				return true;
			}
		}
		return false;
	}

	public User getLoggedUser() {
		return loggedUser;
	}
}
