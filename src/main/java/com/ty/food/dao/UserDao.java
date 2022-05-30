package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food.dto.User;



public class UserDao {
	public User saveUser(User user) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager enityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = enityManager.getTransaction();

		// User user1=new User();
		// user.setName("madhu");
		// user.setEmail("madhu@gmail.com");
		// user.setPhone(9876543265l);
		// user.setPassword("chemistry");

		entityTransaction.begin();
		enityManager.persist(user);
		entityTransaction.commit();
		if (user != null) {
			return user;
		} else {
			return null;
		}

	}

	public User getUserById(int id) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager enityManager = entityManagerFactory.createEntityManager();
		User user = enityManager.find(User.class, id);

		if (user != null) {
			System.out.println("Id is:" + user.getId());
			System.out.println("Name is: " + user.getName());
			System.out.println("Email is:" + user.getPhone());
			System.out.println("Password is " + user.getPassword());
		} else {
            return user;
		}
		return null;
	}
	public List<User>getAllUser()
	{
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		String sql="SELECT u FROM User u";
		Query query=entityManager.createQuery(sql);
		List<User> users=query.getResultList();
		
		for(User user:users)
		{
			System.out.println("Id is: "+user.getId());
			System.out.println("Name is: "+user.getName());
			System.out.println("Email is :"+user.getEmail());
			System.out.println("Phone is :"+user.getPhone());
			System.out.println("password is :"+user.getPassword());
			
			System.out.println("--------------------");
		}
		
		return null;
	}
	
	public User validUser(String name,String email)
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("SELECT u FROM User u WHERE u.name= ?1 AND u.email= ?2");
		
		
		
		query.setParameter(1,"madhu");
		query.setParameter(2, "madhu@gmail.com");
		
		List<User> users=query.getResultList();
		if(users.size()>0)
		{
			User user=users.get(0);
			System.out.println("Id is:"+user.getId());
			System.out.println("Name is :"+user.getName());
			System.out.println("Email is: "+user.getEmail());
			System.out.println("Password is:"+user.getPassword());
			
			System.out.println("---------------------------");
		}
		else
		{
			System.out.println("invalid name and password");
		}
		return null;
	}
	
	public boolean delectUserById(int id)
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager enityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=enityManager.getTransaction();
		
		User user=enityManager.find(User.class,id);
		if(user!=null)
		{
			entityTransaction.begin();
			enityManager.remove(user);
			entityTransaction.commit();
			System.out.println("delecting id is: "+id);
		}
		else
		{
			System.out.println("No record to deelect");
		}
		
		return false;
	}

}
