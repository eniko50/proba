package vp.spring.rcs.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vp.spring.rcs.service.BrendService;
import vp.spring.rcs.web.dto.BrendDTO;

@RestController
public class BrendController {
	@Autowired
	BrendService brendService;
	
	


}
