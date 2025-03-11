package com.ndieujou.apigetway.model;


import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Member implements Serializable{
	private long id;
	private String username;
	private String email;
	private String phone;
	private String address; 
	private String profilPicture;
	private String aboutMe;
	private List<String> role;
	
	

}


