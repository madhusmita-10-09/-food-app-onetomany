package com.ty.food.controller;

import com.ty.food.dto.User;
import com.ty.food.service.UserService;

public class TestValidUser {

	public static void main(String[] args) {
		UserService userservice=new UserService();
		User user=new User();
		
		userservice.validUser("madhu","madhu@gmail.com");
		
	}

}
