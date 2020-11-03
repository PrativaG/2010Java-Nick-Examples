package com.revature.project0.pojos;

import java.util.Date;

/*
 * The is a model class to hold information about the product.
 * It includes product category, name and other different features of product.
 * */

public class Product {
	
	public enum ProductCategory{
		FOOD,
		BEVERAGES,
		PERSONAL_CARE,
		ELECTRONICS,
		HOME_DECOR
	}
	
	private String productId;
	
	private String productName;
		
	private Date expiryDate;
	
	private String productQuality;
	
	private ProductCategory productCategory;
	
	public Product() {
		super();
	}
	
	public Product(ProductCategory productCat, String productName, Date expiryDate, String productQuality) {
		super();
		this.productId = productName + Math.random()*100;
		this.setProductCategory(productCat);
		this.productName = productName;
		this.expiryDate = expiryDate;
		this.productQuality = productQuality;
	}


	public String getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getProductQuality() {
		return productQuality;
	}

	public void setProductQuality(String productQuality) {
		this.productQuality = productQuality;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	

}
