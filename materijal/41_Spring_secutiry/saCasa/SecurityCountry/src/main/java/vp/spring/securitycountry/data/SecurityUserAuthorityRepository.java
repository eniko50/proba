package vp.spring.securitycountry.data;

import org.springframework.data.jpa.repository.JpaRepository;

import vp.spring.securitycountry.model.user.SecurityUserAuthority;

public interface SecurityUserAuthorityRepository
	extends JpaRepository<SecurityUserAuthority, Long> {

}
