package com.ndieujou.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import com.ndieujou.dao.entity.Comment;

@PreAuthorize("hasRole('ROLE_SYSTEM')")
@RepositoryRestResource(path="daoComment", collectionResourceRel = "comments")
public interface CommentRepository extends JpaRepository<Comment, Long>{

}
