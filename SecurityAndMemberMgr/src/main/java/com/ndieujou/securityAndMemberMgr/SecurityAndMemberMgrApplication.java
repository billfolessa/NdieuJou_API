package com.ndieujou.securityAndMemberMgr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SecurityAndMemberMgrApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityAndMemberMgrApplication.class, args);
	}
	
	@Bean
	RestTemplate initRestemplate() {
		return new RestTemplate();
	}

}
