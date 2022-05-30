package com.ty.food.controller;

import com.ty.food.dto.FoodOrder;
import com.ty.food.service.FoodOrderService;

public class TestDeleteFoodOrderById {

	public static void main(String[] args) {
		FoodOrderService foodOrderService = new FoodOrderService();
		FoodOrder foodOrder=new FoodOrder();
		 foodOrderService.removeOrder(2);
		if(foodOrder != null)
		{
			System.out.println("Deleted successfully");
		} else {
			System.out.println("no data is found");
		}

	}

}
