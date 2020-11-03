package com.revature.project0.service;

import com.revature.project0.pojos.Supplier;

public interface SupplierService {
	
	public Supplier createSupplier(int id, String name, String contact, String email);
	
	public Supplier getSupplierInfo(int id);
}
