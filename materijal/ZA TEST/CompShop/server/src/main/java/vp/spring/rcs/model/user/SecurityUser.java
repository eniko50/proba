package vp.spring.rcs.model.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import vp.spring.rcs.model.Artikal;
import vp.spring.rcs.model.Korpa;

@Entity
public class SecurityUser {
	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<SecurityUserAuthority> userAuthorities = new HashSet<SecurityUserAuthority>();
	
	@JsonIgnore
	@OneToOne(mappedBy = "user")	
	private Korpa korpa;
	
	
	







	public SecurityUser() {
		super();
	}













	public SecurityUser(Long id, String username, String password, String firstName, String lastName,
			Set<SecurityUserAuthority> userAuthorities, Korpa korpa) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userAuthorities = userAuthorities;
		this.korpa = korpa;
	}













	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Set<SecurityUserAuthority> getUserAuthorities() {
		return userAuthorities;
	}

	public void setUserAuthorities(Set<SecurityUserAuthority> userAuthorities) {
		this.userAuthorities = userAuthorities;
	}
}
