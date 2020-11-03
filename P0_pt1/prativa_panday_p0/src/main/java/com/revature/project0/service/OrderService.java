package com.revature.project0.service;

import java.util.List;

import com.revature.project0.pojos.Order;
import com.revature.project0.pojos.Product;
import com.revature.project0.pojos.Supplier;

public interface OrderService {
	
	public List<Order> getOrders();
	
	public void setOrders(List<Order> orders);
	
	public boolean makeOrder(int id, Product product, Supplier supplier, int quantity);
	
	public Order getOrder(int id);
}
