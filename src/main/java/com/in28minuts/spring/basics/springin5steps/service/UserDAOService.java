package com.in28minuts.spring.basics.springin5steps.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.in28minuts.spring.basics.springin5steps.entity.User;
import com.in28minuts.spring.basics.springin5steps.service.exception.UserNotFoundException;

@Repository
@Transactional
public class UserDAOService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public long createUser(User user)
	{
		entityManager.persist(user);
		return user.getId();
	}
	
	public User getUser(Integer userId)
	{
		User user = entityManager.find(User.class, userId);
		
		if (user == null)
		{
			throw new UserNotFoundException("userId-"+userId);
		}
		
		return user;
	}
	
	public void createAllUsers(List<User> userList)
	{
		userList.stream().forEach(user -> createUser(user));
		
	}

}
