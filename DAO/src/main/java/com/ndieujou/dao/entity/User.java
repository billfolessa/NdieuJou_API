package com.ndieujou.dao.entity;

import java.io.Serializable;
import java.util.List;

import com.ndieujou.dao.model.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false, name = "username")
	private String username;
	@Column(nullable = false, name = "email", unique = true)
	private String email;
	@Column(nullable = false, name = "password")
	private String password;
	private String phone;
	private String address; 
	private String profilPicture;
	private String aboutMe;
	@Column(nullable = false, name = "role")
	private Role role;
		
	@OneToMany()
	private List<Article> article; 
	
	

}
