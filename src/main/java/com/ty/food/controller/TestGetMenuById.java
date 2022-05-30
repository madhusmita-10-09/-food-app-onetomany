package com.ty.food.controller;

import javax.persistence.EntityManagerFactory;

import com.ty.food.dto.Menu;
import com.ty.food.dto.User;
import com.ty.food.service.MenuService;
import com.ty.food.service.UserService;

public class TestGetMenuById {

	public static void main(String[] args) {
		
		MenuService menuService=new MenuService();
		Menu menu=new Menu();
		menuService.getMenuById(1);

	}

}
