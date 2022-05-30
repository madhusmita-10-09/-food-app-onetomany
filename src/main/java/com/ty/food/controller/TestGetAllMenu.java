package com.ty.food.controller;

import java.util.List;

import com.ty.food.dto.Menu;
import com.ty.food.service.MenuService;

public class TestGetAllMenu {

	public static void main(String[] args) {
		

		MenuService menuService=new MenuService();
		Menu menu=new Menu();
			List<Menu> menus=menuService.getAllMenu();
			

	}

}
