package vp.spring.securitystudents.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vp.spring.securitystudents.model.user.SecurityUser;

public interface UserRepository extends JpaRepository<SecurityUser, Long> {
	  public SecurityUser findByUsername(String username);
}
