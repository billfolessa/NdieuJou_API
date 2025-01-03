package com.ndieujou.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import com.ndieujou.dao.entity.Article;

@PreAuthorize("hasRole('ROLE_SYSTEM')")
@RepositoryRestResource(path = "daoArticle", collectionResourceRel = "articles")
public interface ArticleRepository extends JpaRepository<Article, Long>{

}
