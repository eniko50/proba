package com.vp.priprema.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vp.priprema.security.TokenUtils;
import com.vp.priprema.web.dto.LoginDTO;

@RestController
public class UserController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	TokenUtils tokenUtils;
	
//	@PreAuthorize("hasAnyAuthority('ADMIN', 'SKORO_ADMIN')")
//	@PreAuthorize("isAuthenticated()") // Mora biti ulogovan, nebitna uloga.
	@RequestMapping(value = "/api/login", method = RequestMethod.POST)
	public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
					loginDTO.getUsername(), loginDTO.getPassword());
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails details = userDetailsService.loadUserByUsername(loginDTO.getUsername());
            return new ResponseEntity<String>(tokenUtils.generateToken(details), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<String>("Invalid login", HttpStatus.BAD_REQUEST);
        }
	}
	
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
	@GetMapping("/api/test")
	public ResponseEntity<String> countries() {
		return new ResponseEntity<>("HELLO ADMIN", HttpStatus.OK);
	}
}
