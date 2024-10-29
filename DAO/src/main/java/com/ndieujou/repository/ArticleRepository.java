package com.ndieujou.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ndieujou.entity.Article;

@RepositoryRestResource(path = "article", collectionResourceRel = "articles")
public interface ArticleRepository extends JpaRepository<Article, Long>{

}
