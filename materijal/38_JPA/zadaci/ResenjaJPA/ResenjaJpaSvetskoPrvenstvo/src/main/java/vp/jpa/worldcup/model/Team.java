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
public class Team {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "homeTeam", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<FootballMatch> homeMatches = new HashSet<FootballMatch>();
	
	@OneToMany(mappedBy = "awayTeam", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<FootballMatch> awayMatches = new HashSet<FootballMatch>();


	public Team(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Team() {
		
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
	
	public Set<FootballMatch> getHomeMatches() {
		return homeMatches;
	}

	public void setHomeMatches(Set<FootballMatch> homeMatches) {
		this.homeMatches = homeMatches;
	}

	public Set<FootballMatch> getAwayMatches() {
		return awayMatches;
	}

	public void setAwayMatches(Set<FootballMatch> awayMatches) {
		this.awayMatches = awayMatches;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
}
