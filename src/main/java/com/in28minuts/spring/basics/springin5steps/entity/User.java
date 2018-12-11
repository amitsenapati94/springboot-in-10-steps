package com.in28minuts.spring.basics.springin5steps.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2,message="Name should contain at least 2 characters")
	private String name;
	private String email;
	private String password;
	private Date birthDate;
	
	
	public User() {
	
		
	}
	
	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Date getBirthDate() {
		return birthDate;
	}

}
