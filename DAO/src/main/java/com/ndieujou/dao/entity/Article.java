package com.ndieujou.dao.entity;

import java.util.Date;
import java.util.List;

import com.ndieujou.dao.model.Category;
import com.ndieujou.dao.model.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String description;
	private String address;
	private String prix;
	private List<String> illustration;
	private Date pdate;
	private Category category;
	private Status status;
	private int pstatus;
	private String ville;
	
	@OneToOne(optional = false)
	private User author;
	
	@OneToMany
	List<Comment> comments;

}
