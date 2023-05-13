package vp.spring.rcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import vp.spring.rcs.data.ProjectRepository;
import vp.spring.rcs.model.Project;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	CommentService commentService;

	public Page<Project> getAll(Pageable page) {
		
		return projectRepository.findAll(page);
	}

	public Page<Project> findProjectByName(Pageable page, String name) {
		
		return projectRepository.findByName(name, page);
	}

	public Project findOne(Long id) {
		
		return projectRepository.findOne(id);
	}

	public Project save(Project project) {
		
		return projectRepository.save(project);
	}

	public void deleteProject(Long id) {
		Project project = projectRepository.findOne(id);
		commentService.findAllByPrject(project);
		
		 projectRepository.delete(id);
	}

}
