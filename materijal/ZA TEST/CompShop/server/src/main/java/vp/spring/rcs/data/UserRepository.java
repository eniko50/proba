package vp.spring.rcs.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vp.spring.rcs.model.Korpa;
import vp.spring.rcs.model.user.SecurityUser;


@Repository
public interface UserRepository extends JpaRepository<SecurityUser, Long> {
	  public SecurityUser findByUsername(String username);

	
	  
//	  @Query(value = "SELECT k.korpa FROM SecurityUser k WHERE k.username = :username")
//	  public Korpa findKorpa(@Param("username")String username);
//	  
	  
	 
	  
	
}
