package com.revature.project0.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.revature.project0.pojos.Order;
import com.revature.project0.pojos.Product;
import com.revature.project0.pojos.Supplier;

public class OrderServiceImpl implements OrderService {
	
    private static Logger Log = Logger.getLogger("orderServiceLog");

	List<Order> allOrder = new ArrayList<Order>();
	
	@Override
	public List<Order> getOrders() {
		return this.allOrder;
	}

	@Override
	public void setOrders(List<Order> orders) {
		this.allOrder = orders;
	}	
	
	/*method to make order of the provided quantity of the product to the supplier*/
	@Override
	public boolean makeOrder(int id, Product product, Supplier supplier, int quantity) {
	
		Order order = new Order(id, product, supplier, quantity);
		allOrder.add(order);
		return true;
	}
	
	//method to retrieve order on the basis of order id passed
	@Override
	public Order getOrder(int id) {
		for(Order o : allOrder ) {
			if(o.getOrderId() == id) {
				return o;
			}
		}
		Log.info("Order was not found that has order id " +id);
		return null;
	}

}
