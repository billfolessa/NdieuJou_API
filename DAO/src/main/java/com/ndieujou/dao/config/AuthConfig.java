package com.ndieujou.dao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.ndieujou.dao.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class AuthConfig implements UserDetailsService{
	
	private UserRepository userRepository;
	
	@Bean
	SecurityFilterChain securityFilterChain( HttpSecurity http) throws Exception {
		http.authorizeHttpRequests( (requestAuthentification) -> 
					requestAuthentification
						//.requestMatchers("/user/**").hasRole("User")
					    .requestMatchers("**").hasRole("SYSTEM")
					    //.requestMatchers("member/admin/**").authenticated()
						//.anyRequest().permitAll()
						
				)
				.csrf(AbstractHttpConfigurer::disable)
				.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
	@Override
    public UserDetails loadUserByUsername(String email) { 
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
    	    /*com.ndieujou.dao.entity.User user =  userRepository.findByEmail(email); 
    	    if(user != null) {*/
    	    	 String hashPass = /*user.getPassword();*/encoder.encode("passbon");
    	    	    UserDetails userDetail = User.withUsername("user")
    	    	    		      .password(hashPass)
    	    	    		      .roles("ADMIN", "USER","SYSTEM")
    	    	    		      .build();
    	    	    
    	    	    return userDetail;
    	    /*}
    	    return null;*/
    	   
    	/*}else {
    		 throw new UsernameNotFoundException("User not foung with username "+username);
    	}*/
	}

	
	
	 

}
