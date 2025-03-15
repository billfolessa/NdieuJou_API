package com.ndieujou.securityAndMemberMgr.model;

import lombok.Getter;

@Getter
public class AuthenticationReponse {
	
	private String jwt;
	
	public AuthenticationReponse(String jwt) {
		this.jwt = jwt;
	}

}
