package vp.spring.rcs.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vp.spring.rcs.model.Korpa;
import vp.spring.rcs.model.user.SecurityUser;

public interface KorpaRepository extends JpaRepository<Korpa, Long>{

	Korpa findByUser(SecurityUser user);

	
	

}
