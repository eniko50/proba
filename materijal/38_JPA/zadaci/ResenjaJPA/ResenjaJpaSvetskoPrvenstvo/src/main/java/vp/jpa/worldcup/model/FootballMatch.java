package vp.jpa.worldcup.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FootballMatch {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private int homeGoals;
	
	private int awayGoals;
	
	@ManyToOne
	private Stadium stadium;
	
	@ManyToOne
	private Team homeTeam;
	
	@ManyToOne
	private Team awayTeam;

	public FootballMatch(Long id, int homeGoals, int awayGoals, Stadium stadium,
			Team homeTeam, Team awayTeam) {
		super();
		this.id = id;
		this.homeGoals = homeGoals;
		this.awayGoals = awayGoals;
		this.stadium = stadium;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
	}
	
	public FootballMatch() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getHomeGoals() {
		return homeGoals;
	}

	public void setHomeGoals(int homeGoals) {
		this.homeGoals = homeGoals;
	}

	public int getAwayGoals() {
		return awayGoals;
	}

	public void setAwayGoals(int awayGoals) {
		this.awayGoals = awayGoals;
	}

	public Stadium getStadium() {
		return stadium;
	}

	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}

	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	public Team getAwayTeam() {
		return awayTeam;
	}

	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}

	@Override
	public String toString() {
		return "Match [id=" + id + ", homeGoals=" + homeGoals + ", awayGoals="
				+ awayGoals + ", stadium=" + stadium + ", homeTeam=" + homeTeam
				+ ", awayTeam=" + awayTeam + "]";
	}
}
