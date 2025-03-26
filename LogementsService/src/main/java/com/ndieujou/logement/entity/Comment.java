package com.ndieujou.logement.entity;

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
	private String author;
	@OneToOne(optional = false)
	private Logement article;

}
