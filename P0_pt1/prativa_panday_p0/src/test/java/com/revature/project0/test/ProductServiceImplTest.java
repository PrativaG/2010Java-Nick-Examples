package com.revature.project0.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.project0.pojos.Product;
import com.revature.project0.pojos.Product.ProductCategory;
import com.revature.project0.service.ProductService;
import com.revature.project0.service.ProductServiceImpl;

public class ProductServiceImplTest {
	
	private ProductServiceImpl prodService;
	private ProductCategory prodCat;
	private String prodName;
	private Date expDate;
	private String prodQuality;
	private Product product;
	private List<Product> allProducts;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		prodCat = ProductCategory.HOME_DECOR;
		prodName = "pictures";
		expDate = null;
		prodQuality = "good";
		product = new Product(prodCat, prodName, expDate, prodQuality);
		
		allProducts.add(product);
		prodService = new ProductServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void createProductTest() {
		
		assertTrue("create product returned false", prodService.createProduct(ProductCategory.HOME_DECOR, "boards", null, "excellent"));
		
	}
	
	@Test
	public void checkIfDamagedTest() {
		Product p1 = new Product(ProductCategory.FOOD, "chciken", null, "good");
		assertTrue("Can't find product", prodService.checkIfDamaged(p1));
	}
	
	@Test
	public void getOrderTest() {
		prodService.setProducts(allProducts);
		assertEquals("Order was not found", prodService.getProductByType(prodCat));
	}

}
