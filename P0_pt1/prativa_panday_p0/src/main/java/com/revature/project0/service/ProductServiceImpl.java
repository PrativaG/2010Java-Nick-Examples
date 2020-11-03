package com.revature.project0.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.revature.project0.pojos.Order;
import com.revature.project0.pojos.Product;
import com.revature.project0.pojos.Product.ProductCategory;

public class ProductServiceImpl implements ProductService {
	
    private static Logger Log = Logger.getLogger("productServiceLog");

	List<Product> allProducts = new ArrayList<Product>();
	
	public List<Product> getProducts(){
		return this.allProducts;
	}
	
	public void setProducts(List<Product> products) {
		this.allProducts = products;
	}
	
	/** method to create new product*/
	@Override
	public boolean createProduct(ProductCategory productCat, String name, Date expiryDate, String quality) {
				
		//creating new product
		try {
			Product product = new Product(productCat, name, expiryDate, quality);
			allProducts.add(product);
		}catch(Exception e) {
			Log.info("Error" +e + " occured while creating the product.");
		}
		
		return true;
	}
	
	/*method that returns product based on the basis of ProducCategory passed*/

	@Override
	public List<Product> getProductByType(ProductCategory productCat) {
		// TODO Auto-generated method stub
		List<Product> sameTypeProduct = new ArrayList<>();
		for(Product p : allProducts) {
			if(p.getProductCategory() == productCat) {
				sameTypeProduct.add(p);
			}
		}
		return sameTypeProduct;
	}
	
	/*method that returns the boolean value on the basis of product quality. if product
	 * quality is bad then it returns true*/

	@Override
	public boolean checkIfDamaged(Product p) {
		if(!p.getProductQuality().equals("bad")) {
			return false;
		}
		
		return true;
	}
	
}
