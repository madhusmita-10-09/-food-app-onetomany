package com.ty.food.service;

import java.util.List;

import com.ty.food.dao.MenuDao;
import com.ty.food.dao.UserDao;
import com.ty.food.dto.Item;
import com.ty.food.dto.Menu;
import com.ty.food.dto.User;

public class MenuService {
	MenuDao menuDao = new MenuDao();

	public Menu saveMenu(Menu menu)
	{

		menu.setName("burger");
		menu.setDescription("veg burger, chicken burger");
		menu.setCost(608);
		menu.setType("veg,non-veg");
		menu.setOffer("10%");
		menu.setImage("https://media.istockphoto.com/photos/junk-food-homemade-beef-burgers-on-vintage-wooden-background-picture-id1302436326?b=1&k=20&m=1302436326&s=170667a&w=0&h=MvSjb8R4lOJT_NteIiZxfIoZvXIkKucRUVeViFBLVN4=");

		return  menuDao .saveMenu(menu);
	}
	
	public Menu getMenuById(int id) {
		return menuDao.getMenuById(id);
	}
	
	public List<Menu>getAllMenu()
	{
		return menuDao.getAllMenu();
	}
	
	public boolean delectMenuById(int id)
	{
		return menuDao.delectMenuById(id);
	}
	public Menu validMenu(String name,String type)
	{
		return menuDao.validMenu(name, type);
	}


}
