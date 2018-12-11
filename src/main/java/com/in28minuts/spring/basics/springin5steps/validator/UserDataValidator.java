package com.in28minuts.spring.basics.springin5steps.validator;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.in28minuts.spring.basics.springin5steps.entity.User;

@Component
public class UserDataValidator {
	
	
	public List<User> validateUserList(List<User> userList)
	{
		List<User> validatedUserList = userList.stream()
				.filter(user -> StringUtils.isNoneBlank(user.getName()))
				.filter(user -> StringUtils.isNoneBlank(user.getEmail()))
				.filter(user -> StringUtils.isNoneBlank(user.getPassword()))
				.collect(Collectors.<User> toList());
		
		return validatedUserList;
	}

}
