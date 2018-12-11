package com.in28minuts.spring.basics.springin5steps;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in28minuts.spring.basics.springin5steps.entity.User;
import com.in28minuts.spring.basics.springin5steps.service.UserDAOService;
import com.in28minuts.spring.basics.springin5steps.validator.UserDataValidator;

@RestController
public class UserController {
	
	@Autowired
	private UserDAOService userDAOService;
	
	@Autowired
	private UserDataValidator userDataValidator;
	
	
	@PostMapping(("/users"))
	public ResponseEntity<Void> createAllUsers(@RequestBody List<User> newUsers)
	{
		
		//validate the user list
		List<User> validatedUserList = userDataValidator.validateUserList(newUsers);
		
		//persist data
		userDAOService.createAllUsers(validatedUserList);

		return ResponseEntity.noContent().build();
	
	}
	
	
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id)
	{
		
		return userDAOService.getUser(id);
		
	}
	
	@PostMapping(("/user"))
	public ResponseEntity<Void> createUser(@Valid @RequestBody User newUser)
	{
		
		long userId = userDAOService.createUser(newUser);
		System.out.println("userId: "+userId);
		return ResponseEntity.noContent().build();
	
	}
	

}
