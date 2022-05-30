package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;

public class FoodOrderDao {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager enityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = enityManager.getTransaction();
	
	public FoodOrder saveOrder(FoodOrder foodOrder)
	{
		
		entityTransaction.begin();
		for(Item item:foodOrder.getItem())
		{
			enityManager.persist(item);
		}
		enityManager.persist(foodOrder);
		entityTransaction.commit();
		if (foodOrder != null) {
			return foodOrder;
		} else {
			return null;
		}
	}
	
	
	//Get Order By Id
		public FoodOrder getOrderById(int id)
		{
			FoodOrder foodOrder=enityManager.find(FoodOrder.class,id);
			if(foodOrder!=null)
			{
			List<Item> list=foodOrder.getItem();
//			System.out.println("------Order details-------");
//			System.out.println("The  name :"+foodOrder.getName());
//			System.out.println("The user phone :"+foodOrder.getPhone());
			for(Item item:list)
			{
				System.out.println("Item name :"+item.getName());
				System.out.println("Item quantity :"+item.getQuantity());
				System.out.println("Item cost :"+item.getCost());
				System.out.println("----------------------------------");
			}
			}
			else
			{
				System.out.println("No order available");
			}
			return foodOrder;
			
		}
		//remove order by id//
		public boolean removeOrder(int id)
		{
			boolean flag=true;
			FoodOrder foodOrder=enityManager.find(FoodOrder.class, id);
			entityTransaction.begin();
			if(foodOrder!=null)
			{
			for(Item item:foodOrder.getItem())
			{
				enityManager.remove(item);
			}
			enityManager.remove(foodOrder);
			entityTransaction.commit();
			return flag;
			}
			else
			{
				flag=false;
				return flag;
			}
		}
		
		//Get all 
		public void getTotal1(List<Item> items) {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			
			FoodOrderDao foodOrderDao=new FoodOrderDao();
			double d=foodOrderDao.getTotal(items);
			
			FoodOrder foodOrder=entityManager.find(FoodOrder.class, 2);
			foodOrder.setTotalcost(d);
			
			entityTransaction.begin();
			entityManager.merge(foodOrder);
			entityTransaction.commit();
		}
		//Get total cost
		public double getTotal(List<Item> items) {
			
			double total=0;
			for(Item item: items) {
				total=total+item.getCost()*item.getQuantity();
				}
				return total;
		}
		
		

}
