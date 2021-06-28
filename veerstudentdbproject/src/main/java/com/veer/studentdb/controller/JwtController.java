package com.veer.studentdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.veer.studentdb.jwtrequest.JwtRequest;
import com.veer.studentdb.jwtrequest.JwtResponse;
import com.veer.studentdb.service.JwtService;

@RestController
@CrossOrigin
public class JwtController {

	@Autowired
	private JwtService jwtService;
	
	public JwtController() {
		System.out.println("Jwt auth");
	}

	@PostMapping("/authenticate")
	public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		System.out.println("create token service");
		return jwtService.createJwtToken(jwtRequest);
	}
}
