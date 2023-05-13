package vp.spring.securitycountry.data;

import org.springframework.data.jpa.repository.JpaRepository;

import vp.spring.securitycountry.model.user.SecurityUser;

public interface UserRepository extends JpaRepository<SecurityUser, Long> {
	  public SecurityUser findByUsername(String username);
}
