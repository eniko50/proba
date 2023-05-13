package vp.spring.rcs.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import vp.spring.rcs.model.user.SecurityUser;

@Entity
public class ShoppingCart {
	public ShoppingCart() {
		super();
	}

	public ShoppingCart(String username, Set<Record> records) {
		super();
		this.username = username;
		this.records = records;
	}

	@Id
	@GeneratedValue
	Long id;

	String username;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	Set<Record> records = new HashSet<Record>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Record> getRecords() {
		return records;
	}

	public void setRecords(Set<Record> records) {
		this.records = records;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
