package vp.spring.rcs.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vp.spring.rcs.model.Style;

@Repository
public interface StyleRepository extends JpaRepository<Style, Long>{
	List<Style> findByNameContains(String name);

}
