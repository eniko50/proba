package vp.spring.autocountry.service;

import org.springframework.stereotype.Service;

@Service // ili @Component - RADE ISTO!!
public class SecurityService {
	
	private String role;
	
	public boolean isLoggedIn() {
		return role != null;
	}
	
	public void logIn(String role) {
		this.role = role;
	}
	
	public void logout() {
		this.role = null;
	}
	
	public boolean isAdmin() {
		return "admin".equalsIgnoreCase(this.role);
	}
}
