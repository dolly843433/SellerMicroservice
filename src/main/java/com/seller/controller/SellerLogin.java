package com.seller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.seller.entity.Model;
import com.seller.jwt.JwtUtelis;
import com.seller.repository.Repository;
import com.seller.selleruser.SellerUserDetail;

@RestController
@CrossOrigin("http://localhost:4200")
public class SellerLogin {
	
	@Autowired
	Repository  repository;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtelis util;
	
	
	@PostMapping ("/registration")
	
	public String addmodel(@RequestBody Model model) {
	
	if(repository.findById(model.getEmail_id()).isEmpty()) {
	
	try {
	BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
	String encodedPassword=bCryptPasswordEncoder.encode(model.getPassword());
	model.setPassword(encodedPassword);
	repository.save(model);
	
	return "Added";
	}catch(Exception e) {
	return	e.toString();
	}
	}
	else {
		return "User is already in Database";
	}

}

@PostMapping("/login")
public String loginModel(@RequestBody Model model ) {
	try {
		Authentication auth=authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(model.getEmail_id(),model.getPassword()));
	
	  if(auth.isAuthenticated()) {
		  SellerUserDetail details=new SellerUserDetail(model);
		  String token =util.generateToken(details);
		  
		  return token;
	  }
	  return "User not Authenticated";
	}
	catch(Exception e) {
		return "User or Password does not Matched.";
	}

		
	}
}




	
	




