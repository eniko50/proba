package vp.spring.securitycountry.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vp.spring.securitycountry.model.user.SecurityUser;

@Repository
public interface UserRepository extends JpaRepository<SecurityUser, Long> {
	  public SecurityUser findByUsername(String username);
}
