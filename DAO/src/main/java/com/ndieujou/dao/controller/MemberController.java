package com.ndieujou.dao.controller;

import java.util.Map;
import java.util.Optional;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.security.web.authentication.www.BasicAuthenticationConverter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ndieujou.dao.entity.User;
import com.ndieujou.dao.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("user/")
@Log4j2
public class MemberController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MemberUtil memberUtil;
	
	@PostMapping("save")
	public ResponseEntity<User> createMember(@RequestBody User user){
		try {
			user.setId(0);
			User userResult = userRepository.save(user);
			return new ResponseEntity<User>(userResult,null, HttpStatus.SC_OK);
			
		}catch(Exception e) {
			log.error("MemberController ==> createMember()",e);
			return new ResponseEntity(e.getMessage(),null, HttpStatus.SC_BAD_REQUEST);
		}
		
		
	}
	
	/*
	 * only admin member can update infos about another member
	 * A member can only update their own information
	 */
	@PutMapping("save")
	public ResponseEntity<User> updateMember(@RequestBody User user){
		User newUser =  null;
		if(user != null) {
			if(memberUtil.isAdminLogger()) {
				 newUser = userRepository.save(user);
			}
			else {
				Optional<User> OldUserOptional = userRepository.findById(user.getId());
				if(OldUserOptional != null) {
					User oldUser = OldUserOptional.get();
					Map<String,String> credential = memberUtil.getCredentialCurrentLoggedMember();
					String emailCurrentLogged = credential.get("email");
					emailCurrentLogged = emailCurrentLogged != null ? emailCurrentLogged : "";
					if( emailCurrentLogged.equals(oldUser.getEmail()) ) {
						 newUser = userRepository.save(user);
					}else {
						return new ResponseEntity("You can't update another membre than you ",null, HttpStatus.SC_FORBIDDEN);
					}
				}
			}
		}
		if(newUser != null) {
			return new ResponseEntity<User>(newUser,null, HttpStatus.SC_OK);
		}else {
			return new ResponseEntity<User>(newUser,null, HttpStatus.SC_BAD_REQUEST);
		}
	}
}
