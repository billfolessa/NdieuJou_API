package com.ndieujou.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import com.ndieujou.dao.entity.User;

@PreAuthorize("hasRole('ROLE_SYSTEM')")
@RepositoryRestResource(collectionResourceRel = "user", path="daoUsers" )
public interface UserRepository extends JpaRepository<User, Long>{

	
	User findByEmail( @Param("email") String emain);
	
	@RestResource(exported = false)
	User save(User user);
	
	
}
