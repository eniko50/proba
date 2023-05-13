package vp.spring.rcs.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name ;
	private String description;
	private String readme;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
	List<Comment> comment = new ArrayList<Comment>();

	public Project(Long id, String name, String description, String readme, List<Comment> comment) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.readme = readme;
		this.comment = comment;
	}

	public Project() {
		super();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getReadme() {
		return readme;
	}

	public void setReadme(String readme) {
		this.readme = readme;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	
	
	
	
	

}










