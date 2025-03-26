package com.ndieujou.securityAndMemberMgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ndieujou.securityAndMemberMgr.entity.Member;
import com.ndieujou.securityAndMemberMgr.model.AuthenticationReponse;
import com.ndieujou.securityAndMemberMgr.model.AuthenticationRequest;
import com.ndieujou.securityAndMemberMgr.service.AuthService;
import com.ndieujou.securityAndMemberMgr.service.MemberService;
import com.ndieujou.securityAndMemberMgr.util.JwtUtils;

import jakarta.ws.rs.NotFoundException;

@RestController
@RequestMapping("auth/")
public class AuthController {

	@Autowired
	private AuthService authService;

	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	private MemberService memberService;


	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest){
		AuthenticationReponse jwtResponse = null;
		try {
			jwtResponse = authService.Authenticate(authenticationRequest);
		}catch( Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
		}
		HttpStatusCode status = jwtResponse != null ? HttpStatus.ACCEPTED : HttpStatus.BAD_REQUEST;
		return new ResponseEntity<AuthenticationReponse>(jwtResponse,status);
	}  


	@GetMapping("validate")
	public ResponseEntity<?> validateTocken(@RequestParam String jwt){
		String email = jwtUtils.extractEmail(jwt);
		Member member = memberService.findMemberByEmail(email);


		if(member != null && jwtUtils.validateToken(jwt, member.getEmail())) {
			member.setPassword("");
			return new ResponseEntity<Member>(member,HttpStatus.OK);

		}else {
			return new ResponseEntity<String>("jwt invalide",HttpStatus.BAD_GATEWAY);
		}

	}






}
