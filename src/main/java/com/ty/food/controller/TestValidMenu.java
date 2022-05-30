package com.ty.food.controller;

import com.ty.food.service.MenuService;

public class TestValidMenu {

	public static void main(String[] args) {
		
		MenuService menuService=new MenuService();
		menuService.validMenu("burger", "veg,non-veg");

	}

}
