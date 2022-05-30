package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food.dto.Item;
import com.ty.food.dto.Menu;
import com.ty.food.dto.User;

public class MenuDao {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager enityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = enityManager.getTransaction();
	
	public Menu saveMenu(Menu menu)
	{
		entityTransaction.begin();
		enityManager.persist(menu);
		entityTransaction.commit();
		if (menu != null) {
			return menu;
		} else {
			return null;
		}
	}
	
	public Menu getMenuById(int id) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager enityManager = entityManagerFactory.createEntityManager();
		Menu menu = enityManager.find(Menu.class, id);

		if (menu != null) {
			System.out.println("Menu name is :"+menu.getName());
			System.out.println("Menu description :"+menu.getDescription());
			System.out.println("Cost: "+menu.getCost());
			System.out.println("Type is: "+menu.getType());
			System.out.println("Image: "+menu.getImage());
		} else {
            return menu;
		}
		return null;
	}
	
	public List<Menu>getAllMenu()
	{
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		String sql="SELECT m FROM Menu m";
		Query query=entityManager.createQuery(sql);
		List<Menu> menus=query.getResultList();
		
		for(Menu menu:menus)
		{
			System.out.println("Menu name is :"+menu.getName());
			System.out.println("Menu description :"+menu.getDescription());
			System.out.println("Cost: "+menu.getCost());
			System.out.println("Type is: "+menu.getType());
			System.out.println("Image: "+menu.getImage());
			
			System.out.println("--------------------");
		}
		
		return null;
	}
	
	public boolean delectMenuById(int id)
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager enityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=enityManager.getTransaction();
		
		Menu menu=enityManager.find(Menu.class,id);
		if(menu!=null)
		{
			entityTransaction.begin();
			enityManager.remove(menu);
			entityTransaction.commit();
			System.out.println("delecting id is: "+id);
		}
		else
		{
			System.out.println("No record to deelect");
		}
		
		return false;
	}
	
	public Menu validMenu(String name,String type)
	{
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Query query=entityManager.createQuery("SELECT m FROM Menu m WHERE m.name= ?1 AND m.type= ?2");
		
		
		
		query.setParameter(1,name);
				
		query.setParameter(2, type);
		
		List<Menu> menus=query.getResultList();
		if(menus.size()>0)
		{
			Menu menu=menus.get(0);
			
			System.out.println("Menu name is :"+menu.getName());
			System.out.println("Menu description :"+menu.getDescription());
			System.out.println("Cost: "+menu.getCost());
			System.out.println("Type is: "+menu.getType());
			System.out.println("Image: "+menu.getImage());
			
			System.out.println("---------------------------");
		}
		else
		{
			System.out.println("invalid name and type");
		}
		return null;
	}


}
