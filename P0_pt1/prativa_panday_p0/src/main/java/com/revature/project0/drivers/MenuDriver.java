package com.revature.project0.drivers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.revature.project0.pojos.Order;
import com.revature.project0.pojos.Product;
import com.revature.project0.pojos.Supplier;
import com.revature.project0.pojos.Product.ProductCategory;
import com.revature.project0.service.OrderServiceImpl;
import com.revature.project0.service.ProductServiceImpl;
import com.revature.project0.service.SupplierServiceImpl;

public class MenuDriver {
	
	private static Scanner scan = new Scanner(System.in);
	
	private static Logger log = Logger.getAnonymousLogger();


	public static void main(String[] args) {
		
		OrderServiceImpl orderImpl = new OrderServiceImpl();
		ProductServiceImpl productImpl = new ProductServiceImpl();
		SupplierServiceImpl supplierImpl = new SupplierServiceImpl();
		
		log.info("Menu displayed to let user make choice");
		System.out.println("******************************************");
		System.out.println("Welcome to Inventory Management System!!");
		System.out.println("******************************************");
		
		String userChoice;
		
		do {
			
			displayMenu();
			
			userChoice = scan.nextLine();
			
			switch(userChoice) {
			
			//first menu option that creates order
			case "1":
				System.out.println("Making order....");
				
				System.out.println("---------------Give Product Details-------------------");
				
				//Getting product details from the user
				System.out.println("Enter the category of the product. 1. Food 2. Beverage 3. Electronics 4. Personal Care 5. Home Decor");
				String productCatChoice = scan.nextLine();
				ProductCategory productCat = null;
				
				System.out.println("Enter the name of the product");
				String name = scan.nextLine();
				
//				System.out.println("Enter the expiry date of the product");
//				String expDate = scan.next();
//				Date date = LocalDate.parse(expDate);
				Date expDate = null;
				
				System.out.println("Enter the quality of the product. Good/Bad/Average");
				String prodQuality = scan.nextLine();
				
				switch(productCatChoice) {
					
					case "1" :
						productCat = ProductCategory.FOOD;
						break;
					
					case "2":
						productCat = ProductCategory.BEVERAGES;
						break;
						
					case "3" :
						productCat = ProductCategory.ELECTRONICS;
						break;
					
					case "4":
						productCat = ProductCategory.PERSONAL_CARE;
						break;
						
					case "5" :
						productCat = ProductCategory.HOME_DECOR;
						break;
					
					default:
						System.out.println("PLease choose from 0 to 5");
						break;
						
				}
				
				productImpl.createProduct(productCat, name, expDate, prodQuality);
				List<Product> allProducts = productImpl.getProducts();
				
				System.out.println("---------------Give Supplier Details-------------------");
				
				
				
				System.out.println("Enter the name of the supplier");
				String supplierName = scan.nextLine();
				
				System.out.println("Enter the id for the supplier");
				int supplierId = scan.nextInt();
				
				System.out.println("Enter the contact number of supplier");
				String contactNum = scan.nextLine();
				
				System.out.println("Enter the email id of the supplier");
				String email = scan.nextLine();
				
				Supplier supplier = supplierImpl.createSupplier(supplierId, supplierName, contactNum, email);
				
				System.out.println("---------------Order Details-------------------");
				
				System.out.println("Enter id for your order:");
				int id = scan.nextInt();
				
				System.out.println("Enter the quantity you want to order");
				int q = scan.nextInt();
				
				orderImpl.makeOrder(id, allProducts.get(allProducts.size() -1), supplier, q);
				log.info("New Order Created!!");
				break;
			
			//second menu option that displays all order information
			case "2":
				System.out.println("Getting Order Info...");
				List<Order> allOrders =  orderImpl.getOrders();
				for(Order o: allOrders) {
					System.out.println(o.getOrderQty() +" quantity of " +o.getProducts().getProductName() +" was ordered from" +o.getSupplier().getSupplierName());
					
				}
				break;
			
			//third menu option that displays information of stored supplier
			case "3":
				System.out.println("Getting Supplier Info...");
				List<Supplier> allSuppliers =  supplierImpl.getSuppliers();
				int i =1;
				for(Supplier s: allSuppliers) {
					System.out.println("---Supplier " +i + " information---");
					System.out.println("Supplier Id: " + s.getSupplierId());
					System.out.println("Supplier name: " +s.getSupplierName());
					System.out.println("Supplier contact number: " +s.getSupplierContactNum()+ "\n");
					i++;
				}
				break;
			
			//getting all the product that is of type entered
			case "4":
				System.out.println("Getting product info... \n");
				
				System.out.println("First, please choose the type of the product you want");
				System.out.println("1. Food 2. Beverage 3. Electronics 4. Personal Care 5. Home Decor");
				String prodCatChoice = scan.nextLine();
				
				ProductCategory prodCat = null;
				
				switch(prodCatChoice) {
				
				case "1" :
					prodCat = ProductCategory.FOOD;
					break;
				
				case "2":
					prodCat = ProductCategory.BEVERAGES;
					break;
					
				case "3" :
					prodCat = ProductCategory.ELECTRONICS;
					break;
				
				case "4":
					prodCat = ProductCategory.PERSONAL_CARE;
					break;
					
				case "5" :
					prodCat = ProductCategory.HOME_DECOR;
					break;
				
				default:
					System.out.println("PLease choose from 0 to 5");
					break;
					
			}
				
				List<Product> sameProducts = productImpl.getProductByType(prodCat);
				
				for(Product p: sameProducts) {
					System.out.println("Product Name: " +p.getProductName());
					System.out.println("Product Type: " +p.getProductCategory() +"\n");
				}
				
				
				
			default:
				System.out.println("Please choose between 0 to 4");
				scan.nextLine();
				break;
			}
			
		}while(!"0".equals(userChoice));
		
		
			

	}
	
	//displaMenu method to make user choose between different options
	private static void displayMenu() {
		System.out.println("Your Menu Options:");
		System.out.println("<<1>> Make Order");
		System.out.println("<<2>> Get Order Information");
		System.out.println("<<3>> Get Supplier Information");
		System.out.println("<<4>> Get same types of product");
		System.out.println("<<0>> EXIT");
	}

}
