package com.ndieujou.securityAndMemberMgr.model;

import java.util.List;

import lombok.Data;

@Data
public class Member {

	private long id;
	private String username;
	private String email;
	private String password;
	private String phone;
	private String address; 
	private String profilPicture;
	private String aboutMe;
	private Role role;
	private List<String> articleId; 
}


