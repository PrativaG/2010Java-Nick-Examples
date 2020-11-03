package com.revature.project0.pojos;

import java.util.Date;

/*This is a model that holds information about the product 
 * that has to be ordered, the supplier that satisfies the order, payment and order date. */

public class Order {
	
	private int orderId;
	
	private Product product;
	
	private Supplier supplier;
	
	private int orderQty;
	
	
	public Order() {
		super();
	}

	public Order(int orderId, Product products, Supplier supplier, int qt) {
		super();
		this.orderId = orderId;
		this.product = products;
		this.supplier = supplier;
		this.orderQty =qt;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	
	public int getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(int orderQty) {
		this.orderQty = orderQty;
	}

	public Product getProducts() {
		return product;
	}

	public void setProducts(Product product) {
		this.product = product;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	
	

}
