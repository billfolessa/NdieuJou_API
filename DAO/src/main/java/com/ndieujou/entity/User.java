package com.ndieujou.entity;

import java.util.List;

import com.ndieujou.model.Role;

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
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false, name = "username")
	private String username;
	@Column(nullable = false, name = "email")
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
