package vp.spring.rcs.web.dto;

import vp.spring.rcs.model.Project;

public class ProjectDTO {
	
	private String name ;
	private String description;
	private String readme;
	
	public ProjectDTO(Project project) {
		super();
		this.name = project.getName();
		this.description = project.getDescription();
		this.readme = project.getReadme();
	}

	public ProjectDTO() {
		super();
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
	
	
	

}
