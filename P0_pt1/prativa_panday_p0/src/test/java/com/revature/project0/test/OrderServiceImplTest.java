package com.revature.project0.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.project0.pojos.Order;
import com.revature.project0.pojos.Product;
import com.revature.project0.pojos.Product.ProductCategory;
import com.revature.project0.pojos.Supplier;
import com.revature.project0.service.OrderService;
import com.revature.project0.service.OrderServiceImpl;

public class OrderServiceImplTest {
	
	private OrderService orderService;
	private int orderId;
	private Product product;
	private Supplier supplier;
	private Order order;
	private List<Order> allOrders;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		orderId = 23456;
		product = new Product(ProductCategory.BEVERAGES, "coke", null, "good" );
		supplier = new Supplier(23333, "Trade and get", "5566656556", "tg@mial.com");
		
		order = new Order(orderId, product, supplier, 44);
		
		allOrders = new ArrayList<>();
		allOrders.add(order);
		
		orderService = new OrderServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void makeNewOrderTest() {
		assertTrue("makeOrder returned false", orderService.makeOrder(1234, product, supplier, 10));
	}
	
	@Test
	public void getOrderTest() {
		orderService.setOrders(allOrders);
		assertTrue("Order was not found", orderService.getOrder(orderId).equals(order));
	}

}
