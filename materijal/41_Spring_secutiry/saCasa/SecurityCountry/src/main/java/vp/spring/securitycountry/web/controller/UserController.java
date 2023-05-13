package vp.spring.securitycountry.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.securitycountry.model.user.SecurityUser;
import vp.spring.securitycountry.security.TokenUtils;
import vp.spring.securitycountry.service.UserService;
import vp.spring.securitycountry.web.dto.LoginDTO;
import vp.spring.securitycountry.web.dto.RegisterDTO;

@RestController
public class UserController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	TokenUtils tokenUtils;
		
	@RequestMapping(value = "/api/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
					loginDTO.getUsername(), loginDTO.getPassword());
            Authentication authentication = authenticationManager.authenticate(token);
            return new ResponseEntity<String>(tokenUtils.generateToken(loginDTO.getUsername()), 
            		HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<String>("Invalid login", HttpStatus.UNAUTHORIZED);
        }
	}
	
	@PostMapping("/api/register")
	public ResponseEntity<Void> register(@RequestBody RegisterDTO dto) {
		SecurityUser user = new SecurityUser();
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		user.setUsername(dto.getUsername());
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		
		userService.save(user, dto.getAuthorities());
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}




