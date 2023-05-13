package vp.spring.SpringDataJPACountry.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
//neophodno definisati i bazu jer Hibernate pravi problem ako u drugoj bazi ima istoimena tabela 
@Table(catalog = "dbcountry", name = "country") 
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	private int population;
	
	@OneToMany(mappedBy = "country", cascade = CascadeType.REFRESH)
	private Set<Place> places = new HashSet<Place>();
	
	public Country() {
		
	}
	
	public Country(Long id, String name, int population) {
		super();
		this.id = id;
		this.name = name;
		this.population = population;
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

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public Set<Place> getPlaces() {
		return places;
	}

	public void setPlaces(Set<Place> places) {
		this.places = places;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", population="
				+ population + "]";
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return id == other.id;
	}
	
	
}
