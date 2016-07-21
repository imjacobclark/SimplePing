package com.uk.jacob.document;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;

public class Account {
	@Id
    private String id;
    
    private String email;
    private ArrayList urlsToPing;   

    public String getId(){
    	return this.id;
    }
    
    public String getEmail(){
    	return this.email;
    }
    
    public void setEmail(String email){
    	this.email = email;
    }
}
