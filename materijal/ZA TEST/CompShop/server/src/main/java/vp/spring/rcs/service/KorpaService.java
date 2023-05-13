package vp.spring.rcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import vp.spring.rcs.data.KorpaRepository;
import vp.spring.rcs.model.Korpa;
import vp.spring.rcs.model.user.SecurityUser;




@Component
public class KorpaService {
	@Autowired
	KorpaRepository korpaRepository;
	@Autowired 
	UserDetailsServiceImpl userService;
	

	public Korpa findKorpaByUser(String username) {
		SecurityUser user =  userService.findByUsername(username);
		return korpaRepository.findByUser(user);
	}


	public Korpa save(Korpa korpa) {
		
		return korpaRepository.save(korpa);
	}

	
	

	

}
