package com.ndieujou.apigetway.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import java.lang.reflect.Array;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ndieujou.apigetway.model.Member;

@Service
public class AuthService implements UserDetailsService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	private Member findMemberByTocken(String tocken) {
		if(tocken != null) {
			ResponseEntity<Member> memberResult = restTemplate.postForEntity("http://SecurityAndMemberMgr/auth/validate", tocken, Member.class);
		    return memberResult !=  null ? memberResult.getBody() : null;
		}
		return null;
	}


	@Override
	public UserDetails loadUserByUsername(String tocken) throws UsernameNotFoundException {
		
		Member member = findMemberByTocken(tocken);
		if (member == null) {
            throw new UsernameNotFoundException("member not found with token: " + tocken);
        }
		
		List<String> listRoles = member.getRole();
		String[] roles =   listRoles != null ? listRoles.toArray(new String[] {}) : null; 
		UserDetails userDetail = User.withUsername(member.getUsername())
  		      .roles(roles)
  		      .build();
  
		return userDetail;
	}

}
