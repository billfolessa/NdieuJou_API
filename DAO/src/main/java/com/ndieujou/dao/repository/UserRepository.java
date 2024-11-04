package com.ndieujou.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ndieujou.dao.entity.Utilisateur;

@RepositoryRestResource(collectionResourceRel = "users", path="user")
public interface UserRepository extends JpaRepository<Utilisateur, Long>{

	
	Utilisateur findByEmail( @Param("email") String emain);
}
