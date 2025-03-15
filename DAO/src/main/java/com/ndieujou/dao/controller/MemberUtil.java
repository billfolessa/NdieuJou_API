package com.ndieujou.dao.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.security.web.authentication.www.BasicAuthenticationConverter;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class MemberUtil {
	
	@Autowired
	private HttpServletRequest request;
	private SecurityContextHolderStrategy securityContextHolderStrategy = SecurityContextHolder.getContextHolderStrategy();
	private AuthenticationConverter authenticationConverter = new BasicAuthenticationConverter();
    
	public Collection<GrantedAuthority> authoritiesLoggedMember(){  
    	
		SecurityContext securityContext = securityContextHolderStrategy.getContext();
		Authentication authenticate = securityContext.getAuthentication();
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) authenticate.getAuthorities();
		return authorities != null ? authorities : new ArrayList<GrantedAuthority>();
    }
	
	public boolean isAdminLogger() {
		Collection<GrantedAuthority>  authorities = authoritiesLoggedMember();
		boolean result = authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return result;
	}
	
	public Map<String,String> getCredentialCurrentLoggedMember(){
		Map<String,String> credential = new HashMap<String,String>();
		try {
			Authentication authRequest = this.authenticationConverter.convert(request);
			UsernamePasswordAuthenticationToken infosCurrentUser =(UsernamePasswordAuthenticationToken)authRequest;
			String password = (String)infosCurrentUser.getCredentials();
			String username = infosCurrentUser.getName();
			credential.put("pass", password);
			credential.put("email", username);
		}catch(Exception e) {
			log.error("MemberServiceImp ==> getCredential()", e);
		}
		return credential;
	}

}
