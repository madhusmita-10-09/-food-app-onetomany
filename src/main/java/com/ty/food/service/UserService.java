package com.ty.food.service;

import java.util.List;

import com.ty.food.dao.UserDao;
import com.ty.food.dto.User;



public class UserService {
	UserDao userDao=new UserDao();
	
	public User saveUser(User user) {
		
		
		user.setName("soumya");
		user.setEmail("soumya@gmail.com");
		user.setPhone(8889878950l);
 		user.setPassword("u7e55e4");
		
		return userDao.saveUser(user);
	}
		
		public User getUserById(int id)
		{
			return userDao.getUserById(id);
		}
		
		public  List<User> getAllUser()
		{
			return userDao.getAllUser();
		}
		
		public boolean delectUserById(int id)
		{
			return userDao.delectUserById(id);
		}
		
		public  User validUser(String name,String email)
		{
			return userDao.validUser(name, email);
		}
	
	
	
}
