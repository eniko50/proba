package vp.jpa.worldcup.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Stadium {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "stadium", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<FootballMatch> matches = new HashSet<FootballMatch>();
	
	public Stadium() {
		
	}

	public Stadium(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<FootballMatch> getMatches() {
		return matches;
	}

	public void setMatches(Set<FootballMatch> matches) {
		this.matches = matches;
	}

	@Override
	public String toString() {
		return "Stadium [id=" + id + ", name=" + name + "]";
	}
}
