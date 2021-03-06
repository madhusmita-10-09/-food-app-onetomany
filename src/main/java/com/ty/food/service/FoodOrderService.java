package com.ty.food.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.food.dao.FoodOrderDao;
import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;

public class FoodOrderService {
	FoodOrderDao foodOrderDao=new FoodOrderDao();
	
	public FoodOrder saveOrder(FoodOrder foodOrder)
	{
		
		return foodOrderDao.saveOrder(foodOrder);
	}
	
	public FoodOrder getOrderById(int id) {
		FoodOrderDao foodOrderDao = new FoodOrderDao();
		return foodOrderDao.getOrderById(id);
	}

	public boolean removeOrder(int id) {
		FoodOrderDao foodOrderDao = new FoodOrderDao();
		return foodOrderDao.removeOrder(id);
	}
	public List<Item> getAllItem(){
		FoodOrderDao foodOrderDao = new FoodOrderDao();
		return foodOrderDao.getAllItem();
	}
	
	
	
	//Get Total Cost
		public void getTotal(List<Item> items) {
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
		
		public double generateBill(int id) {
			FoodOrderDao foodOrderDao=new FoodOrderDao();

			FoodOrder foodOrder=foodOrderDao.getOrderById(id);
			double offer=0;
			if(foodOrderDao.getTotal(foodOrder.getItem())>1000) {
				offer=foodOrderDao.getTotal(foodOrder.getItem())/10;
			}
			double a=(foodOrderDao.getTotal(foodOrder.getItem())/SGST)+(foodOrderDao.getTotal(foodOrder.getItem())/CGST);
			return foodOrderDao.getTotal(foodOrder.getItem())-offer+a;
		}

}
