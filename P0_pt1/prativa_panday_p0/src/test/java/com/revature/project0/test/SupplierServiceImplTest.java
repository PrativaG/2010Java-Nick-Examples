package com.revature.project0.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.project0.pojos.Supplier;
import com.revature.project0.service.SupplierService;
import com.revature.project0.service.SupplierServiceImpl;

public class SupplierServiceImplTest {
	
	private SupplierServiceImpl supplierService; 
	private int supplierId;
	private String name;
	private String contactNum;
	private String email;
	private Supplier supplier;
	private List<Supplier> allSuppliers;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		supplierId = 23444;
		name  = "Get Trade";
		contactNum = "567882333";
		email = "sd@mail.com";
		
		supplier = new Supplier(supplierId, name, contactNum, email);
		allSuppliers.add(supplier);
		
		supplierService = new SupplierServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void makeNewSupplierTest() {
		Supplier testSupplier = supplierService.createSupplier(12345, "PG", "345546666", "pg@mail.com");
		assertEquals("should create supplier", "PG", testSupplier.getSupplierName());
	}
	
	@Test
	public void getSupplierTest() {
		supplierService.setSuppliers(allSuppliers);
		assertTrue("Supplier was not found", supplierService.getSupplierInfo(supplierId).equals(supplier));
	}

}
