package vp.spring.securitycountry.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vp.spring.securitycountry.model.user.SecurityAuthority;

public interface SecurityAuthorityRepository
	extends JpaRepository<SecurityAuthority, Long> {

	List<SecurityAuthority> findByNameIn(List<String> names);
	
}
