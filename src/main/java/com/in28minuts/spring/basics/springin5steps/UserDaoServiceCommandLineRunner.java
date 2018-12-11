package com.in28minuts.spring.basics.springin5steps;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minuts.spring.basics.springin5steps.entity.User;
import com.in28minuts.spring.basics.springin5steps.service.UserDAOService;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner{
	
	//private static final Logger log = (Logger) LoggerFactory.logger(UserDaoServiceCommandLineRunner.class);
	
	@Autowired
	private UserDAOService userDAOService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User user = new User("Amit", "abc@gmail.com", "test");
		
		long userId = userDAOService.createUser(user);
		
		//log.info("new user created successfully : " + userId);
		
	}
	
	 

}
