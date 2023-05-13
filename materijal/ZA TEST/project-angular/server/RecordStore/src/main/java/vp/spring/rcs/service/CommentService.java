package vp.spring.rcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vp.spring.rcs.data.CommentRepository;
import vp.spring.rcs.model.Comment;
import vp.spring.rcs.model.Project;

@Service
public class CommentService {
	@Autowired
	CommentRepository commentRepository;

	public Comment save(Comment comment) {
		
		return commentRepository.save(comment);
		
		
	}
	
	public void delete(Long id) {
		commentRepository.delete(id);
	}

	public void findAllByPrject(Project project) {
		List<Comment> comments = commentRepository.findByProject(project);
		
		for(Comment c : comments) {
			Long id = c.getId();
			commentRepository.delete(id);
		}
		
		
		
	}
	
	
	
	
	
	
	
	

}
