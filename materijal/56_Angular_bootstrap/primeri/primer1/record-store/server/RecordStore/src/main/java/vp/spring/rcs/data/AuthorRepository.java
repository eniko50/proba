package vp.spring.rcs.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vp.spring.rcs.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
	List<Author> findByNameContains(String name);
}
