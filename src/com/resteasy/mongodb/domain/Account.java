package com.resteasy.mongodb.domain;

import java.io.Serializable;

import com.google.code.morphia.annotations.Entity;

@Entity
public class Account implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	private String name;
	 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }


}
