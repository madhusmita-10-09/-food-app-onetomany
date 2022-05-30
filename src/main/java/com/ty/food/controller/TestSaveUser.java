package com.ty.food.controller;

import com.ty.food.dto.User;
import com.ty.food.service.UserService;


public class TestSaveUser {
	public static void main(String[] args) {
		UserService userservice=new UserService();
		
		User user=new User();
		
		userservice.saveUser(user);
		System.out.println("data saved");
	}

	
}
