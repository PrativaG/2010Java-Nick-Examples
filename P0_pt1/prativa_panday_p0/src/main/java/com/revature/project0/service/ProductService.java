package com.revature.project0.service;

import java.util.Date;
import java.util.List;

import com.revature.project0.pojos.Product;
import com.revature.project0.pojos.Product.ProductCategory;

public interface ProductService {
	
	public boolean createProduct(ProductCategory productCat, String name, Date expiryDate, String quality);
		
	public List<Product> getProductByType(ProductCategory productCat);
	
	public boolean checkIfDamaged(Product p);
		
}
