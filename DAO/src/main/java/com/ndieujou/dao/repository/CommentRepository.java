package com.ndieujou.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ndieujou.dao.entity.Comment;

@RepositoryRestResource(path="comment", collectionResourceRel = "comments")
public interface CommentRepository extends JpaRepository<Comment, Long>{

}
