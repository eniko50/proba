package vp.spring.rcs.web.dto;

import java.util.List;

import vp.spring.rcs.model.user.SecurityUser;

public class UserDTO {
	
     String username;
	
	
	
	 String firstName;
	
	 String lastName;
	 
	 List<KorpaDTO>  korpaDTO;

	public void setKorpaDTO(List<KorpaDTO> korpaDTO) {
		this.korpaDTO = korpaDTO;
	}

	public UserDTO(SecurityUser user) {
		super();
		this.username = user.getUsername();
		
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	

//	public String getFirstName() {
//		return firstName;
//	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

//	public String getLastName() {
//		return lastName;
//	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	 
	 

}
