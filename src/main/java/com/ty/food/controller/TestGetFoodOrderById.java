package com.ty.food.controller;

import java.util.List;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;
import com.ty.food.service.FoodOrderService;

public class TestGetFoodOrderById {

	public static void main(String[] args) {

		FoodOrderService foodOrderService = new FoodOrderService();
		foodOrderService.getOrderById(2);
		

	}

}
