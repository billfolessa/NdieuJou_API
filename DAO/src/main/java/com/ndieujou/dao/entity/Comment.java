package com.ndieujou.dao.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Comment {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private long id;
	private String message;
	private Date pdate;
	private User author;
	@OneToOne(optional = false)
	private Article article;

}
