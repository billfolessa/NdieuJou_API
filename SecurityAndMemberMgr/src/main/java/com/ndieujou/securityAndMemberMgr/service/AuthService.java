package com.ndieujou.securityAndMemberMgr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ndieujou.securityAndMemberMgr.entity.Member;
import com.ndieujou.securityAndMemberMgr.exception.NotFoundException;
import com.ndieujou.securityAndMemberMgr.model.AuthenticationReponse;
import com.ndieujou.securityAndMemberMgr.model.AuthenticationRequest;
import com.ndieujou.securityAndMemberMgr.util.JwtUtils;

@Service
public class AuthService {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtUtils jwtUtil;
	
	public AuthenticationReponse Authenticate(AuthenticationRequest authenticationRequest) throws NotFoundException  {
		AuthenticationReponse response  = null;
		if(authenticationRequest != null) {
			Member member = memberService.memberByEmail(authenticationRequest.getEmail());
			if(member != null) {
				boolean isMatchPassword = passwordEncoder.matches(authenticationRequest.getPassword(), member.getPassword());
				if(isMatchPassword) {
					String jwt = jwtUtil.generateToken(authenticationRequest.getEmail());
					response = new AuthenticationReponse(jwt);
				}
			}else {
				throw new NotFoundException(" member not found");
			}
		}
		return response;
	}

}
