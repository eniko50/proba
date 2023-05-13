package vp.spring.securitycountry.data;

import org.springframework.data.jpa.repository.JpaRepository;

import vp.spring.securitycountry.model.user.SecurityAuthority;

public interface AuthorityRepository extends JpaRepository<SecurityAuthority, Long> {
	SecurityAuthority findByName(String name);
}
