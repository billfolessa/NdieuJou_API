package com.ndieujou.securityAndMemberMgr.configuration;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class AuthConfig implements UserDetailsService{
	
	@Bean
	SecurityFilterChain securityFilterChain( HttpSecurity http) throws Exception {
		http.authorizeHttpRequests( (requestAuthentification) -> 
					requestAuthentification
						//.requestMatchers("/user/**").hasRole("User")
					    .requestMatchers("member/admin/**").hasRole("ADMIN")
					    //.requestMatchers("member/admin/**").authenticated()
						.anyRequest().permitAll()
						
				)
				.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
	@Override
    public UserDetails loadUserByUsername(String username) {
    	/*Student student = restTemplate.getForObject("http://STUDENT-SERVICE", null);
    	if(student != null) {*/
    		/*Collection<SimpleGrantedAuthority> mappedAuthorities = new ArrayList<SimpleGrantedAuthority>();
    		mappedAuthorities.add( new SimpleGrantedAuthority("ROLE_ADMIN"));
    		System.out.println("************* "+new BCryptPasswordEncoder().encode("xcvsdf"));
    		String password = new BCryptPasswordEncoder().encode("passa");
    	    User user = new User("username", "{noop}pass", mappedAuthorities);
    		//User user = new User("username1", "pass", mappedAuthorities);
    	    UserDetails admin = User.withDefaultPasswordEncoder()
    				.username("admin")
    				.password("passa")
    				.roles("ADMIN", "USER")
    				.build();
    	    */
    	    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    	    String hashPass = encoder.encode("passbon");
    	    UserDetails user1 = User.withUsername("user")
    	    		      .password(hashPass)
    	    		      .roles("ADMIN", "USER")
    	    		      .build();
    	    
    	    return user1;
    	/*}else {
    		 throw new UsernameNotFoundException("User not foung with username "+username);
    	}*/
	}

	
	
	 

}
