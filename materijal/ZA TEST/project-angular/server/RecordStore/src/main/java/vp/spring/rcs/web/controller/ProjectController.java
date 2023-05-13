package vp.spring.rcs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.model.Comment;

import vp.spring.rcs.model.Project;
import vp.spring.rcs.service.CommentService;
import vp.spring.rcs.service.ProjectService;
import vp.spring.rcs.web.dto.CommentDTO;
import vp.spring.rcs.web.dto.ProjectDTO;

@RestController
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	CommentService commentService;
	
	@GetMapping(value="api/projects")
	ResponseEntity<Page<Project>> getAllProjects(Pageable page, @RequestParam (value = "name", required = false  ) String name){
		
		if(name != null) {
			Page<Project> projects1 = projectService.findProjectByName(page, name);
			return new ResponseEntity<>(projects1, HttpStatus.OK);
		} else {
				
		Page<Project> projects = projectService.getAll(page);
		return new ResponseEntity<>(projects, HttpStatus.OK);
	}
	}
	
	@GetMapping(value="api/projects/{id}")
	ResponseEntity<Project> getProject(@PathVariable Long id){
		Project project = projectService.findOne(id);
		if(project != null) {
		
		return new ResponseEntity<>(project, HttpStatus.OK);
		} else {
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
		
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(value = "api/create/project")
	ResponseEntity<Project> createProject( @RequestBody ProjectDTO projectDTO){
		Project project = new Project();
		
		project.setName(projectDTO.getName());
		project.setDescription(projectDTO.getDescription());
		project.setReadme(projectDTO.getReadme());
		
		project = projectService.save(project);
		return new ResponseEntity<>(project, HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping(value = "api/delete/{id}")
	ResponseEntity<Void> deleteProject(@PathVariable Long id){
		
		projectService.deleteProject(id);
		return new ResponseEntity<>( HttpStatus.OK);
		
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(value = "api/update/project/{id}")
	ResponseEntity<Project> updateProject( @RequestBody ProjectDTO updatedProject, @PathVariable Long id){
		Project project = projectService.findOne(id);
		project.setName(updatedProject.getName());
		project.setDescription(updatedProject.getDescription());
		project.setReadme(updatedProject.getReadme());
		project = projectService.save(project);
		return new ResponseEntity<>(project, HttpStatus.OK);
		
	}
	
	@PostMapping(value = "api/project/comment/{id}")
	ResponseEntity<Comment> putComment(@PathVariable Long id, @RequestBody CommentDTO commentDTO){
		Project project = projectService.findOne(id);
		if(project == null) {
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
		Comment comment = new Comment();
		comment.setProject(project);
		comment.setText(commentDTO.getText());
		comment.setUsername(commentDTO.getUsername());
		comment = commentService.save(comment);
		return new ResponseEntity<>(comment, HttpStatus.OK);
		
	}
	
	

	
	
	

	
	
	

}}
