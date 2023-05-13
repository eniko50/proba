package vp.spring.rcs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Style {
	public Style(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Style() {
		super();
	}

	public Style(String name) {
		super();
		this.name = name;
	}

	@Id
	@GeneratedValue
	Long id;

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Style [id=" + id + ", name=" + name + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
