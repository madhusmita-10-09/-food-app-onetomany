package com.ty.food.controller;

import com.ty.food.dto.Menu;
import com.ty.food.dto.User;
import com.ty.food.service.MenuService;
import com.ty.food.service.UserService;

public class TestSaveMenu {

	public static void main(String[] args) {
    MenuService menuService=new MenuService();
		
		Menu menu=new Menu();
		
		menuService.saveMenu(menu);
		
		System.out.println("data saved");

	}

}
