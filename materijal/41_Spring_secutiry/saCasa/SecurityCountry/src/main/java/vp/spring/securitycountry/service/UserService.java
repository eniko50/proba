package vp.spring.securitycountry.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vp.spring.securitycountry.data.SecurityAuthorityRepository;
import vp.spring.securitycountry.data.SecurityUserAuthorityRepository;
import vp.spring.securitycountry.data.UserRepository;
import vp.spring.securitycountry.model.user.SecurityUser;
import vp.spring.securitycountry.model.user.SecurityUserAuthority;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SecurityAuthorityRepository securityAuthorityRepository;
	
	@Autowired
	private SecurityUserAuthorityRepository securityUserAuthorityRepository;
	
	public void save(SecurityUser user, List<String> authorities) {
		final SecurityUser savedUser = userRepository.save(user);
		
		Set<SecurityUserAuthority> userAuthorities = 
				securityAuthorityRepository.findByNameIn(authorities)
			.stream() // Stream<SecurityAuthority>
			.map(authority -> {
				SecurityUserAuthority userAuthority
						= new SecurityUserAuthority();
				
				userAuthority.setAuthority(authority);
				userAuthority.setUser(savedUser);
				
				return userAuthority;
			}) // Stream<SecurityUserAuthority>
			.collect(Collectors.toSet());
		
		securityUserAuthorityRepository.saveAll(userAuthorities);
	}

}
