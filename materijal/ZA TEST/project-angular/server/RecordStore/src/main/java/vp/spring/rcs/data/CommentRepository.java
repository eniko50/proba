package vp.spring.rcs.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vp.spring.rcs.model.Comment;
import vp.spring.rcs.model.Project;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByProject(Project project);

}
