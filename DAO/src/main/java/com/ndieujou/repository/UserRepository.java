package com.ndieujou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ndieujou.entity.User;

@RepositoryRestResource(collectionResourceRel = "users", path="user")
public interface UserRepository extends JpaRepository<User, Long>{

	
	User findByEmail( @Param("email") String emain);
}
