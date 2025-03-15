package com.ndieujou.dao.event;

import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeLinkSave;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.data.rest.core.event.AbstractRepositoryEventListener;
import org.springframework.data.rest.core.event.RepositoryEvent;
import org.springframework.stereotype.Component;

import com.ndieujou.dao.entity.User;

@Component
public class UserEventHandler extends AbstractRepositoryEventListener<User> {
	
	 @Override
	    protected void onBeforeCreate(User entity) {
	        // Custom logic after a book is created
	        System.out.println("Book created before: " + entity.getId());
	        //entity.setEmail(null);
	        return;
	    }
	    
	@Override
	    protected void onAfterCreate(User entity) {
	        // Custom logic after a book is created
	        System.out.println("Book created: " + entity.getId());
	        return;
	    }

	    @Override
	    protected void onAfterSave(User entity) {
	        // Custom logic after a book is saved
	        System.out.println("Book saved: " + entity.getId());
	    }

	    @Override
	    protected void onAfterDelete(User entity) {
	        // Custom logic after a book is deleted
	        System.out.println("Book deleted: " + entity.getId());
	    }
	
	
	@HandleBeforeSave
	public void handleBeforeSaveUser(User user) {
	    // … you can now deal with Person in a type-safe way
		System.out.println(" handleBeforeSaveUser handleBeforeSaveUser handleBeforeSaveUser ");
	}
	
	@HandleBeforeLinkSave
	public void handleBeforeLinkSaveUser(User user) {
	    // … you can now deal with Person in a type-safe way
		System.out.println("handleBeforeLinkSaveUser handleBeforeLinkSaveUser handleBeforeLinkSaveUser");
	}
	
	@HandleBeforeDelete
	public void handleBeforeDelete(User user) {
		System.out.println("handleBeforeDelete handleBeforeDelete handleBeforeDelete");
	    // … you can now deal with Person in a type-safe way
	}

}
