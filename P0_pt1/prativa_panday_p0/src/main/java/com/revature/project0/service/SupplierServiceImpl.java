package com.revature.project0.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.revature.project0.pojos.Order;
import com.revature.project0.pojos.Supplier;

public class SupplierServiceImpl implements SupplierService {
	
	 private static Logger Log = Logger.getLogger("supplierServiceLog");

		List<Supplier> allSupplier = new ArrayList<>();
		
		public List<Supplier> getSuppliers() {
			return this.allSupplier;
		}

		public void setSuppliers(List<Supplier> s) {
			this.allSupplier = s;
		}	
	
	/*getting the details of supplier from the user and creating a new supplier*/
	@Override
	public Supplier createSupplier(int id, String name, String contact, String email) {
		
		Supplier supplier = new Supplier(id, name, contact, email);
		allSupplier.add(supplier);
		return supplier;
	}
	
	//getting supplier information on the basis of supplier id provided
	@Override
	public Supplier getSupplierInfo(int id) {
		for(Supplier s: allSupplier) {
			if(s.getSupplierId() == id) {
				return s;
			}
		}
		Log.info("Order was not found that has order id " +id);
		return null;
	}

}
