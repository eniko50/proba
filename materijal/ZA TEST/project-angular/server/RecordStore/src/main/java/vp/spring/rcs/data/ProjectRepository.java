package vp.spring.rcs.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import vp.spring.rcs.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

	Page<Project> findByName(String naziv, Pageable page);

}
