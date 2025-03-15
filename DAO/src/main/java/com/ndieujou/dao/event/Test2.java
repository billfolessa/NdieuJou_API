package com.ndieujou.dao.event;

import org.springframework.context.ApplicationListener;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.data.rest.core.event.RepositoryEvent;
import org.springframework.stereotype.Component;



public class Test2 implements ApplicationListener<RepositoryEvent> {

	@Override
	public void onApplicationEvent(RepositoryEvent event) {
		// TODO Auto-generated method stub
		int i = 1;
		int j = 1;
		System.out.println("salut "+i+j);
		return;
	}

}
