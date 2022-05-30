package com.ty.food.controller;

import java.util.ArrayList;
import java.util.List;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;
import com.ty.food.service.FoodOrderService;

public class TestSaveFoodOrder {

	public static void main(String[] args) {
		FoodOrderService foodOrderService = new FoodOrderService();
		FoodOrder foodOrder=new FoodOrder();
		 foodOrder.setName("burger");
		 foodOrder.setPhone(846464646646l);
		 
		 Item item1=new Item();
		 item1.setName("chicken burger");
		 item1.setQuantity(1);
		 item1.setCost(600);
		 
		 Item item2=new Item();
		 item2.setName("pannir burger");
		 item2.setQuantity(1);
		 item2.setCost(400);
		 
		 Item item3=new Item();
		 item3.setName("crispy burger");
		 item3.setQuantity(2);
		 item3.setCost(500);
		 
		 List<Item>items=new ArrayList();
		 items.add(item1);
		 items.add(item2);
		 items.add(item3);
		 
		 foodOrder.setItem(items);
		 item1.setFoodOrder(foodOrder);
		 item2.setFoodOrder(foodOrder);
		 item3.setFoodOrder(foodOrder);
		 
		 foodOrderService.saveOrder(foodOrder);
		 



	}

}
