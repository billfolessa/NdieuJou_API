package com.ndieujou.logement.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	@Bean
	Queue logementQueue() {
		return new Queue("logement.queue",true);
	}
	
	@Bean
	RabbitTemplate template() {
		return new RabbitTemplate();
	}

}
