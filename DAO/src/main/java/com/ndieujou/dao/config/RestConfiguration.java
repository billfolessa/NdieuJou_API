package com.ndieujou.dao.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import jakarta.persistence.EntityManager;

@Configuration
public class RestConfiguration implements RepositoryRestConfigurer{
	
	@Autowired
	private EntityManager entityManager;
	
	 @Override
	 public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
	  Class[] classes = 	entityManager.getMetamodel().getEntities()
			  .stream().map( item -> item.getJavaType()).toArray(Class[]::new); 
	  config.exposeIdsFor(classes);
	}
	 
	 @Override
	public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener v) {
	 //  v.addValidator("beforeSave", new BeforeSaveValidator());
	 }

}
